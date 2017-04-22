<template>
  <div style="width: 100%;">
    <e-avatar></e-avatar>
    <el-row>

        <el-col :span="20" :offset="2">
          <center>
            <h1 class="font">个人荣誉</h1>
          </center>
          <div>
            <span style="text-align: center;padding-left: 20px;">
              <el-button size="middle" @click="sortHonor(1)" type="success">时间 <i class="iconfont icon-xiajiang"></i></el-button>
              <el-button type="warning" @click="sortHonor(2)">访问 <i class="iconfont icon-xiajiang"></i></el-button>
              <el-select v-model="values"
                         multiple placeholder="按类型筛选"
                         style="margin-left: 10px;"
                         @visible-change="extractHonorType"
                         :remote="true"
                         @change="selectByHonorType"
                         :loading="honorTypeLoading"
                          @remove-tag="removeTag">
                <el-option
                  v-for="item in honorTypeOptions"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
              <el-button size="middle" @click="addHonor" style="margin-left: 10px" type="success"><i class="iconfont icon-shenqing"></i>申请荣誉</el-button>
            </span>
          </div>
          <el-row>
            <el-col :span="4" v-for="(item, index) in honors" :offset="0" style="margin: 20px;">
              <el-card :body-style="{ padding: '0px' }">
                <img src="/static/abt.jpg" class="image">
                <div style="padding: 14px;">
                  <span>{{item.des}}</span>
                  <div class="bottom clearfix">
                    <time class="time">{{ item.achieveTime }}</time>
                    <el-button type="info" size="small" class="button">查看详细</el-button>
                    <el-button type="danger" size="small" class="button">删除</el-button>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-col>
    </el-row>
    <el-dialog :close-on-click-modal="false" title="申请新的荣誉" v-model="newHonor.isShow" size="tiny">
      <el-form :model="newHonor.model">
          <el-input v-model="newHonor.model.honorType" class="form" placeholder="荣誉类型" auto-complete="off"></el-input>
          <el-input v-model="newHonor.model.des" class="form" placeholder="描述"></el-input>
          <el-date-picker class="form"
            v-model="newHonor.model.achieveTime"
            type="date"
            placeholder="选择日期">
          </el-date-picker>

      </el-form>
      <div slot="footer">
        <el-button type="info" @click="newHonor.isShow=false">撤销</el-button>
        <el-button @click="addHonor" type="success">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  import {getSessionUser,setSessionUser} from '../../storage/index'
  import store from '../../store/index'
  import userUtils from '../../common/utils/UserUtils'
  export default{
      data() {
          return{
            currentDate: new Date(),
            honorTypeOptions: [],
            values:[],
            honors:[],
            honorTypeLoading:true,
            newHonor:{
                isShow:false,
                model:{
                    achieveTime:null,
                    des:null,
                    honorType:null
                }
            }
          }
      },
    methods: {
          initData() {
            let teacher = userUtils.isTeacher()
            if (!teacher) {
                store.commit("SHOW_LOGIN",true)
                return
            }
            let params = {userId:teacher.id}
            ajaxUtils.send("/api/honor/list",params,result=> {
                if (result.code==200) {
                    this.honors = result.result

                } else if (result.code == 414) {
                    store.commit("SHOW_LOGIN",true)
                    return
                }
            })
          },
          // 提取荣誉类型
          extractHonorType(flag) {
              if (flag) {
                  let honorTypeId = []
                  this.honors.map(h=>honorTypeId.push(h.honorType))
                  this.honorTypeLoading = true
                  ajaxUtils.post("/api/honor/item",{list:honorTypeId},result=>{
                      if (result.code == 200) {
                          this.honorTypeOptions = []
                          result.result.map(item=> {
                              this.honorTypeOptions.push({
                                  label: item.name,
                                  value:item.id
                            })
                          })
                        this.honorTypeLoading = false
                      }else {

                      }
                  })
              }
          },
          sortHonor(flag) {
          },
          selectByHonorType(values) {

          },
          removeTag(value) {
              console.log(value)
          },
          addHonor() {
              this.newHonor.isShow = true
          }

    },
    mounted() {
        this.initData()
    }
  }
</script>
<style>

  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 3px;
    margin:2px;
    float: right;
    margin-top: 0px;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
  .form{
    margin-bottom: 10px;
  }

</style>
