<template>
    <div v-if="!showLogin" style="width: 100%;">
        <e-avatar></e-avatar>
        <el-row style="padding-bottom: 20px;">
            <el-col :span="16" :offset="3" style="height: 500px;padding-top: 20px;">
              <el-tabs type="border-card">
                <el-tab-pane>
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
                <el-tab-pane label="消息中心">我的资产</el-tab-pane>
                <el-tab-pane label="角色管理">角色管理</el-tab-pane>
                <el-tab-pane label="定时任务补偿">定时任务补偿</el-tab-pane>·
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
    export default{
        data() {
            return {
              teacherData:[],
              form:{
                name:"徐峰",
                region:''
              },
              formLabelWidth:"200px",
              dialogVisible:false
            }
        },
      methods:{
            modifyData() {
                this.dialogVisible = true;
            },
            initData () {
                let teacher = userUtils.isTeacher()
                if (!teacher) {
                    store.commit("SHOW_LOGIN",true)
                    return
                }
                for (let item in teacher) {
                   /* if (item=="name") {
                        this.teacherData.push({label:"姓名",value:teacher[item]})
                    }  else if(item=="id") {
                        this.teacherData.push({label:"工号",value:teacher[item]})
                    } else if (item=="email") {
                        this.teacherData.push({label:"邮箱",value:teacher[item]})
                    } else if (item==)*/
                   this.teacherData.push({
                       label:item,
                        value:teacher[item]
                   })
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

</style>
