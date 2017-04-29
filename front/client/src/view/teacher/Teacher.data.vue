<template>
    <div v-if="!showLogin" style="width: 100%;">
        <e-avatar></e-avatar>
        <el-row style="padding-bottom: 20px;">
            <el-col :span="16" :offset="3" style="height: 500px;padding-top: 20px;">
              <el-tabs type="border-card" @tab-click="tabClick">
                <el-tab-pane :isFirstInit = "true" >
                  <span slot="label"><i class="iconfont icon-gerenziliao"></i> 个人资料</span>
                  <div style="width: 100%;height: 40px;border-bottom: 1px solid #fdf;margin-bottom: 20px;">
                    <h3 style="float: left">基本资料</h3>
                    <el-button @click="modifyData" type="default" size="small" style="float: right;"><i class="iconfont icon-modify"></i>&nbsp;修改</el-button>
                  </div>
                  <el-row v-for="item in teacherData" style="height: 30px;line-height: 30px;">
                    <el-col :span="6">
                      {{item.label}}
                      <span>:</span>
                    </el-col>
                    <el-col :span="18">
                      {{item.value}}
                    </el-col>
                  </el-row>
                </el-tab-pane>
                <el-tab-pane label="我的资产" name="asset">
                  <div style="margin-bottom: 8px">
                    <span style="text-align: center;padding-left: 20px;">
                      <el-button size="small"  type="success">申请资产</el-button>

                      <el-button size="small" style="margin-left: 10px" type="success">批量转移资产</el-button>
                    </span>
                  </div>
                    <el-table
                      :data="assets.data"
                      style="width: 100%">
                      <el-table-column
                        prop="id"
                        label="编号"
                        width="180">
                      </el-table-column>
                      <el-table-column
                        prop="name"
                        label="使用次数"
                        width="usedCount">
                      </el-table-column>
                      <el-table-column
                        prop="buyTime"
                        label="使用时间">
                      </el-table-column>
                      <el-table-column
                        prop="buyTime"
                        label="购买时间">
                      </el-table-column>
                      <el-table-column
                        prop="userName"
                        label="使用人">
                      </el-table-column>
                      <el-table-column
                        prop="handleUserName"
                        label="经手人">
                      </el-table-column>
                      <el-table-column
                        fixed="right"
                        label=" 操作"
                        width="120">
                        <template scope="scope">
                          <el-button
                            type="text"
                            size="small"
                          @click="handleAsset(scope.row.id)">
                            申请回收
                          </el-button>
                        </template>
                      </el-table-column>
                    </el-table>
                </el-tab-pane>
                <el-tab-pane label="我的申请" name="apply" >我的申请</el-tab-pane>
                <el-tab-pane label="定时任务补偿"  name="" >定时任务补偿</el-tab-pane>
              </el-tabs>
            </el-col>
        </el-row>

      <el-dialog title="个人信息修改" v-model="dialogVisible">
        <el-form :model="form">
          <el-form-item label="活动名称" :label-width="formLabelWidth">
            <el-input v-model="form.name" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="活动区域" :label-width="formLabelWidth">
            <el-select v-model="form.region" placeholder="请选择活动区域">
              <el-option label="男" value="男"></el-option>
              <el-option label="女" value="女"></el-option>
              <el-option label="保密" value="保密"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
        </div>
      </el-dialog>
    </div>
</template>
<script>
    import store from '../../store/index'
    import {getSessionUser,setSessionUser} from '../../storage/index'
    import userUtils from '../../common/utils/UserUtils'
    import ajaxUtils from '../../http/ajaxUtils'
    export default{
        data() {
            return {
              teacher:{},
              teacherData:[],
              form:{
                name:"徐峰",
                region:''
              },
              formLabelWidth:"200px",
              dialogVisible:false,
              assets:{
                  init:false,
                  data:[]
              }
            }
        },
      methods:{
        tabClick(tab) {
          if((tab.name=='asset' && !this.assets.init)) {
              this.getAssets();
          }
        },
            modifyData() {
                this.dialogVisible = true;
            },
            initData () {
                 this.teacher = userUtils.isTeacher()
                if (!this.teacher) {

                    store.commit("SHOW_LOGIN",true)
                    return
                }
                for (let item in this.teacher) {
                   this.teacherData.push({
                       label:item,
                       value:this.teacher[item]
                   })
                }
            },
          getAssets() {
              ajaxUtils.send("/api/asset/list",{userId:this.teacher.id},result=>{
                  console.log(result)
                  if (result.code == 200) {
                      this.assets.data = result.result
                      this.assets.init = true
                  }
              })
          },
          handleAsset(assetId) {
            let params  = {
                teacherId:this.teacher.id,
                list:[assetId]
            }
            ajaxUtils.post("/api/asset/recycle",params,result=> {
                if(result.code == 200) {
                  this.$message.success("申请成功，等待处理！")
                }else {
                  this.$message.error("申请失败，稍后重试！")
                }
            })
            console.log(assetId)
          }
      },
      mounted() {
        this.initData()
      },
      computed: {
            showLogin: ()=>{
                return store.getters.showLogin
            }
      }
    }
</script>
<style>

</style>
