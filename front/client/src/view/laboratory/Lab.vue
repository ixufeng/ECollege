<template>
    <div style="width: 100%;height: auto;">
        <lab-part></lab-part>
        <div>
          <el-row>
            <el-col :span="19" :offset="1">
              <el-card>
                <el-radio class="radio" v-model="radio" v-for="(item,index) in labTypeGroup" @change="selectLabTypeHandle" :label="index">{{index}}</el-radio>
              </el-card>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="19" :offset="1">
              <el-card>
                <el-row style="padding-right: 40px">
                  <el-col class="time-cell" :span="3"></el-col>
                  <el-col class="time-cell" v-for="item in nextWeek" :span="3">
                    <span style="font-size: 16px;font-weight: 700;">{{week[item.getDay()]}}</span><br>
                    <span style="font-size: 12px;color: #aaa;">{{formatDate(item,'MM-dd')}}</span>
                  </el-col>
                </el-row>
                <el-row style="padding-right: 40px">
                  <template v-for="(item,index) in labRoomGroup" >
                    <el-col class="cell" :span="3">
                      <span style="font-size: 15px;color: #024db3;font-weight: 700;cursor: pointer">{{item.roomNumber}}</span>
                    </el-col>
                    <el-col class="cell" v-for="date in nextWeek" :span="3">
                      <el-progress :show-text="false" :percentage="getLabApplyClass(item.roomNumber,date)" :status="getLabApplyClass(item.roomNumber,date) >60?'exception':'success'"></el-progress>
                      <div style="text-align: center;">
                        <el-button type="text" @click="detail(item)">详情</el-button>
                        <el-button @click="appoint(item.roomNumber,date)" type="text">预约</el-button>
                      </div>
                    </el-col>
                  </template>
                </el-row>
              </el-card>
            </el-col>
          </el-row>
        </div>
        <el-dialog title="实验室申请" v-model="showAppointDialog" size="tiny">
          <el-form :model="appointForm">
            <el-form-item label-width="80px"  label="实验室">
              <el-input style="width: 80%" v-model="appointForm.labId" :readonly="true" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label-width="80px"    label="时  间">
              <el-input style="width: 80%" v-model="appointForm.dayTime" :readonly="true" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label-width="80px" label="选择课时">
              <el-checkbox-group v-model="appointForm.classesValue" size="small">
                <el-checkbox v-for="index in classChoice" :label="index" :disabled="hasSelected(appointForm.labId,appointForm.dayTime,index)" :key="city">{{index}}</el-checkbox>
              </el-checkbox-group>
            </el-form-item>
            <el-form-item label-width="80px" label="申请理由">
                <el-input  style="width: 80%"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer">
            <el-button type="info">取消</el-button>
            <el-button @click="appointClick" type="success">预约</el-button>
          </div>
        </el-dialog>
        <el-dialog title="实验室详情" v-model="showLabDetail">
          <div id="lab-detail" v-if="selectedLab!=null">
            <el-row class="el-row">
              <el-col :span="8">
                实验室
              </el-col>
              <el-col :span="16">
                {{selectedLab.roomNumber}}
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                实验室类型
              </el-col>
              <el-col :span="16">
                {{selectedLab.roomType}}
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                管理员
              </el-col>
              <el-col :span="16">
                {{selectedLab.adminName}}
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                实验室状态
              </el-col>
              <el-col :span="16">
                {{selectedLab.valid==1?"正常":'异常'}}
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                使用次数
              </el-col>
              <el-col :span="16">
                {{selectedLab.useCount}}
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                设备数量
              </el-col>
              <el-col :span="16">
                {{selectedLab.useCount}}
              </el-col>
            </el-row>
          </div>
        </el-dialog>
    </div>
</template>
<script>
  import LabPart from './LabPart.vue'
  import ajaxUtils from '../../http/ajaxUtils'
  import timeUtils from '../../common/utils/timeUtils'
  import userUtils from '../../common/utils/UserUtils'
  import store from '../../store/index'
  export default {

      data() {
          return {
              user: {

              },
              labTypeGroup: {},
              radio:null,
              week:["周日","周一","周二","周三","周四","周五","周六"],
              nextWeek:timeUtils.getNextDays(7),
              labApplyMap:{},
              showAppointDialog:false,
              showLabDetail:false,
              appointForm: {
                  labId:'',
                  userId:'',
                  dayTime:'',
                  classes:'',
                  classesValue:[],
                  labType:null
              },
              applyKeyVal:{},
              classChoice:["1","2","3","4","5"],
              selectedClass:[],  //某天已经选择过的课时
              selectedLab:null
          }
      },
      components: {
          LabPart
      },
      computed: {
        appointForm() {
            return {

            }
        },
        labRoomGroup() {
            if (this.radio) {
                return this.labTypeGroup[this.radio]
            } else {
                return []
            }
        }
      },
      methods: {
          detail(lab) {
              console.log(lab)
              this.showLabDetail = true
              this.selectedLab = lab


          },
          clearForm() {
            this.appointForm.labId = ''
            this.appointForm.classValue  = []
            this.appointForm.labType = ''
          },
           checkLogin() {
              let u = userUtils.isLogin()
              if (u) {
                  this.user = u
              }else {
                store.commit("SHOW_LOGIN",true)
                return
              }
          },
          appointClick() {
              this.checkLogin()
              let url = "/api/lab/apply"
              let params = Object.assign(this.appointForm)
              params.userId = this.user.id
              params.classes = this.appointForm.classesValue.join(",")

              params.labType = this.radio
              ajaxUtils.post(url,params,result=> {
                  if (result.code == 200) {
                      this.$message.success("申请成功！")
                      this.clearForm()
                      this.showAppointDialog = false
                  }else if (result.code == 414) {
                      this.$message.error(result.message)
                      store.commit("SHOW_LOGIN",true)
                      return
                  } else {
                     this.$message.error(result.message)
                  }

              })
          },
          appoint(roomNumber,date) {
              this.showAppointDialog = true
              this.appointForm.labId = roomNumber
              this.appointForm.dayTime = timeUtils.format(date,"yyyy-MM-dd")
              let time = timeUtils.format(date,'yyyy-MM-dd')
              let key = roomNumber + "-" + time

          },
        /**
         * 获取实验室在某天已预约的课时
         * @param roomNumber
         * @param date
         * @returns {Number}
         */
          getLabApplyClass(roomNumber,date) {
              let time = timeUtils.format(date,'yyyy-MM-dd')
              let key = roomNumber + "-" + time
              let arr  = this.applyKeyVal[key]
              let count = 0
              if (arr && typeof arr != "undefined") {
                  arr.map(apply=> {
                      count += apply.classValue.length
                  })
                  return (count/5) * 100
              }
              return 0
          },
          getLabApplyClassIndexArr(roomNumber,date) {
            let time = timeUtils.format(date,'yyyy-MM-dd')
            let key = roomNumber + "-" + time
            let arr  = this.applyKeyVal[key]
            let index = []
            if (arr && typeof arr != "undefined") {
              arr.map(apply=> {
                index.push(...apply.classValue)
              })
            }
            return index
          },
          hasSelected(roomNumber,date,index) {
              date =  new Date(date)
              return this.getLabApplyClassIndexArr(roomNumber,date).indexOf(index) != -1
          },
          selectLabTypeHandle(val) {
              console.log(val)
          },
          formatDate(date,ftm){
              return timeUtils.format(date,ftm)
          },
          initData() {
              ajaxUtils.send("/api/lab/group_type",null,result=> {
                  if (result.code==200) {

                      this.labTypeGroup = result.result
                  }
              })
          },
          loadLabState() {
              let url = "/api/lab/apply/list?labType=" + this.radio;
              ajaxUtils.send(url,null,result=> {
                  this.labApplyMap = result.result
                  for (let labId in result.result) {
                      let  applyDayMap = result.result[labId]["applyMap"]
                      for(let time in applyDayMap ) {
                          let key = labId + "-" + time
                          this.applyKeyVal[key] = applyDayMap[time]
                      }
                  }
              })
          }
      },
      mounted() {
          this.initData()
      },
      watch: {
          radio: function () {
              this.loadLabState()
          }
      }

  }
</script>
<style type="text/css">
  .cell {
    border: 1px solid #03a9f4;
    height: 100px;
    margin-top: -1px;
    margin-left: -1px;

  }
  .time-cell {
      border: 1px solid #cccccc;
      height: 40px;
      margin-top: -1px;
      margin-left: -1px;
      text-align: center;
      font-size: 16px;
      font-weight: 700;
  }
  #lab-detail > .el-row{
    margin: 10px;
  }
</style>
