<template>
    <div v-if="!showLogin" style="width: 100%; height: auto;">
        <e-avatar></e-avatar>
        <el-row style="padding-bottom: 20px;">
            <el-col :span="16" :offset="3" style="height: 500px;padding-top: 20px;">
              <el-tabs type="border-card" @tab-click="tabClick">
                <el-tab-pane :isFirstInit = "true" >
                  <span slot="label"><i class="iconfont icon-gerenziliao"></i> 个人资料</span>
                  <div style="width: 100%;height: 40px;border-bottom: 1px solid #fdf;margin-bottom: 20px;">
                    <h3 style="float: left">基本资料</h3>
                    <el-button @click="modifyData('password')" type="default" size="small" style="float: right;"><i class="iconfont icon-modify"></i>&nbsp;修改密码</el-button>
                  </div>
                  <div>
                    <span class="label">姓名:</span>
                    <span class="label_val">{{teacher.name}}</span>

                  </div>
                  <div>
                    <span class="label">工号:</span>
                    <span class="label_val">{{teacher.id}}</span>
                  </div>
                  <div>
                    <span class="label">性别:</span>
                    <span class="label_val">{{teacher.sex}}</span>
                  </div>
                  <div>
                    <span class="label">电话:</span>
                    <span class="label_val">{{teacher.phone}}</span>
                    <el-button @click="modifyData('phone')" type="default" size="small" style="float: right;"><i class="iconfont icon-modify"></i>&nbsp;修改</el-button>
                  </div>
                  <div>
                    <span class="label">邮箱:</span>
                    <span class="label_val">{{teacher.mail}}</span>
                    <el-button @click="modifyData('mail')" type="default" size="small" style="float: right;"><i class="iconfont icon-modify"></i>&nbsp;修改</el-button>
                  </div>
                </el-tab-pane>
                <el-tab-pane label="我的资产" name="asset">
                    <span slot="label"><i class="iconfont icon-iconfontzichan"></i> 我的资产</span>
                    <asset-list :userId="user_id_asset"></asset-list>
                </el-tab-pane>
                <el-tab-pane label="资产相关" name="apply" >
                    <span slot="label"><i class="iconfont icon-iconfontzichan"></i>资产相关</span>
                    <apply-list :userId="user_id_apply"></apply-list>
                </el-tab-pane>
                <el-tab-pane label="实验室申请" name="lab" >
                  <span slot="label"><i class="iconfont icon-shiyanshi1"></i> 实验室申请</span>
                    <lab-apply-list :userId="user_id_lab"></lab-apply-list>
                </el-tab-pane>
                <el-tab-pane label="代办事项" name="things" >
                    <span slot="label"> <i class="iconfont icon-shijian"></i> 待办事项 </span>
                    <admin-handle :userId="user_id_handle"></admin-handle>
                </el-tab-pane>
              </el-tabs>
            </el-col>
        </el-row>
      <el-dialog title="个人信息修改" v-model="dialogVisible" size="tiny">
        <el-form :model="form">
          <el-form-item style="width: 80%" v-if="form.flag=='password'" autofocus  label="原密码" label-width="100px">
            <el-input  v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item style="width: 80%" v-if="form.flag=='password'" label="新密码" label-width="100px">
            <el-input v-model="form.newPassword"></el-input>
          </el-form-item>
          <el-form-item style="width: 80%" v-if="form.flag=='mail'" autofocus label="新邮箱" label-width="100px">
            <el-input v-model="form.mail"></el-input>
          </el-form-item>
          <el-form-item style="width: 80%" v-if="form.flag=='phone'" autofocus label="新号码" label-width="100px">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
          <el-button v-if="form.flag=='password'" style="float: right;margin-right: 20%" type="text">忘记密码?</el-button>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="modifyData(null)">确 定</el-button>
        </div>
      </el-dialog>
    </div>
</template>
<script>
    import store from '../../store/index'
    import {getSessionUser,setSessionUser} from '../../storage/index'
    import userUtils from '../../common/utils/UserUtils'
    import ajaxUtils from '../../http/ajaxUtils'
    import assetList from './teacher.asset.vue'
    import applyList from './teacher.apply.vue'
    import labApplyList from './teacher.lab_apply.vue'
    import adminHandle from './admin.handle.vue'
    import tableContainer from '../../components/TableContainer.vue'
    export default{
        components: {
          assetList,
          applyList,
          labApplyList,
          adminHandle,
          tableContainer
        },
        data() {
            return {
              teacher: {},
              form: {
                flag:"",
                password:'',
                newPassword:'',
                mail:'',
                phone:''
              },
              dialogVisible: false,
              user_id_asset: '',
              user_id_apply: '',
              user_id_lab:'',
              user_id_handle:''
            }
        },
      methods:{
        tabClick(tab) {
          if(tab.name == 'asset') {
              this.user_id_asset = this.teacher.id
          } else if (tab.name =="apply") {
              this.user_id_apply = this.teacher.id
          } else if (tab.name == "lab") {
              this.user_id_lab = this.teacher.id
          } else if (tab.name == "things") {
              this.user_id_handle = this.teacher.id
          }
        },
          modifyData(flag) {
            console.log(flag)
            if (flag != null) {
              this.form.flag = flag
              this.dialogVisible = true
              return
            }

            let url = "/api/teacher/update"
            if (flag == 'password') {
                return
            }
            let params = {
                userId:this.teacher.id,
                mail:this.form.mail,
                phone:this.form.phone
            }

            ajaxUtils.post(url,params,result=> {
                if (result.code == 200) {
                    this.$message.success("修改成功！")
                    this.dialogVisible = false;
                    return
                }
                if (result.code == 414) {
                  this.$message.info("请先登录")
                  this.dialogVisible = false
                  store.commit("SHOW_LOGIN",true)
                  return
                }
                this.$message.error(result.message);
            })


          },
          initData () {
               this.teacher = userUtils.isTeacher()
              if (!this.teacher) {
                  store.commit("SHOW_LOGIN",true)
                  return
              }
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
  .label{
    width: 80px;
    text-align: right;
    height: 40px;
    line-height: 40px;
    font-size: 16px
  }
  .label_val{
    width: 80px;
    margin-left: 10px;
    height: 40px;
    line-height: 40px;
    font-size: 16px
  }

</style>
