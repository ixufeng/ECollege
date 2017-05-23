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
             <!-- <el-button type="warning" @click="sortHonor(2)">访问 <i class="iconfont icon-xiajiang"></i></el-button>-->
              <el-select v-model="values"
                         multiple placeholder="按类型筛选"
                         style="margin-left: 10px;"
                         @visible-change="extractHonorType"
                         :remote="true"
                         @change="selectByHonorType"
                         :loading="honorTypeLoading"
                          @remove-tag="selectByHonorType">
                <el-option
                  v-for="item in honorTypeOptions"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
              <el-button size="middle" @click="addHonor" style="margin-left: 10px" type="success"><i class="iconfont icon-shenqing"></i>添加荣誉</el-button>
            </span>
          </div>
          <el-row>
            <el-col :span="4" v-for="(item, index) in pageHonor" :offset="0" style="margin: 20px;">
              <el-card :body-style="{ padding: '0px' }">
                <img src="/static/abt.jpg" class="image">
                <div style="padding: 14px;">
                  <span>{{item.des}}</span>
                  <div class="bottom clearfix">
                    <time class="time">{{ item.achieveTime }}</time>
                    <el-button type="info" size="small" class="button">查看详细</el-button>
                    <el-button type="danger" size="small" class="button" @click="deleteHonor(item)">删除</el-button>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="current_page"
            :page-sizes="[10, 20, 30, 40]"
            :page-size="page_size"
            layout="total, sizes, prev, pager, next, jumper"
            :total="honors.length">
          </el-pagination>
        </el-col>
    </el-row>
    <el-dialog :close-on-click-modal="false" title="申请新的荣誉" v-model="newHonor.isShow" size="tiny">
      <el-form :model="newHonor.model">
          <el-select v-model="newHonor.model.honorType" class="form" clearable placeholder="请选择荣誉类型">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
          <el-input v-model="newHonor.model.des" required class="form" placeholder="描述"></el-input>
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
      computed: {
          pageHonor() {
              let start = (this.current_page - 1) * this.page_size
              return [...this.honors].splice(start,this.page_size)
          }
      },
      data() {
          return{
            page_size:10,
            current_page:1,
            currentDate: new Date(),
            teacher: {},
            honorTypeOptions: [],
            values:[],
            honors:[],
            honorsBack:[],
            options:[],
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
          handleSizeChange(size) {
            this.page_size = size
          },
          handleCurrentChange(pageIndex) {

            this.current_page = pageIndex
          },
          deleteHonor(honor) {
              let flag = false
              if(honor) {
                  flag = window.confirm("确认删除此条记录？")
              }
              if (flag) {
                  let params = {
                      id:honor.id
                  }
                  ajaxUtils.post("/api/honor/delete",params,result=> {
                      if (result.code == 200) {
                          this.$message.success("删除成功！")
                      }else {
                        this.$message.warning("删除失败！")
                      }
                  })
              }
          },
          initData() {
             this.teacher = userUtils.isTeacher()
            if (!this.teacher) {
                store.commit("SHOW_LOGIN",true)
                return
            }
            let params = {userId:this.teacher.id}
            ajaxUtils.send("/api/honor/list",params,result=> {
                if (result.code==200) {
                    this.honors = result.result
                    this.honorsBack = [...this.honors]
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
                  this.honorsBack.map(h=>honorTypeId.push(h.honorType))
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
              if (flag == 1) {
                  //sort by time
                  this.honors.sort((h1,h2)=>{
                      return new Date(h1.achieveTime).getTime() >new Date(h2.achieveTime).getTime();
                  })
              }
          },
          selectByHonorType(values) {
              console.log(values)
              if (values.length == 0 ) {
                  this.honors = [...this.honorsBack]
                  return
              }
              this.honors = this.honorsBack.filter(item =>values.indexOf(item.honorType) != -1 )
          },
          loadHonorType() {
              let url = "/api/honorType/list"
              ajaxUtils.send(url,null,result=> {
                  if(result != -1 && result.code == 200) {
                      this.options = result.result
                  }
              })
          },

          checkHonorForm() {
              if (this.newHonor.model.honorType == null || this.newHonor.model.honorType == "" ||
                  this.newHonor.model.des == null || this.newHonor.model.des.trim() == "" ||
                  this.newHonor.model.achieveTime == null){
                  this.$message.info("请补充完信息后提交！")
                  return false;
              }
              return true
          },
          addHonor() {
              if (this.options.length == 0 ) {
                  this.loadHonorType()
              }
              this.newHonor.model.userId = this.teacher.id  //添加用户
              this.newHonor.isShow = true
              if ( !this.checkHonorForm() ) return
              let url = "/api/honor/add"
              ajaxUtils.post(url,this.newHonor.model,result=> {
                  if (result != -1 && result.code == 200) {
                      this.$message.success("申请成功，等待审核");
                      this.newHonor.isShow = false
                  }
              })



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
    width:80%;;
    margin-bottom: 10px;
  }

</style>
