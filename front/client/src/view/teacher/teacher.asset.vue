<template>
  <div style="width: 100%">
    <div style="margin-bottom: 8px">
        <span style="text-align: center;padding-left: 20px;">
          <el-button size="small"  type="success" @click="assetApplyHandle">申请资产</el-button>
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
            v-if="scope.row.valid==1"
            type="text"
            size="small"
            @click="handleAsset(scope.row.id)">
            申请回收
          </el-button>
        </template>
      </el-table-column>
      <el-table-column
        fixed="right"
        label=" 状态"
        width="120">
        <template scope="scope">
          <el-button
            type="success"
            v-if="scope.row.valid==1"
            size="small">
            使用中
          </el-button>
          <el-button
            type="info"
            v-if="scope.row.valid==2"
            size="small">
            审核中...
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="新增项目" v-model="dialogVisible" size="tiny" width="200px">
      <el-form :model="form">
        <el-form-item style="width: 80%" label="资产名称" label-width="100px">
          <el-input v-model="form.assetName" placeholder="资产名称"  class="e-form"></el-input><br/>
        </el-form-item>
        <el-form-item style="width: 80%" label="申请描述" label-width="100px">
          <el-input v-model="form.des"  type="textarea"   class="e-form"></el-input><br/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="assetApplyHandle(0)">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  import ajaxUtils from  '../../http/ajaxUtils'
  export  default {
    props:["userId"],
    data() {
        return {
          assets:{
            init:false,
            data:[]
          },
          dialogVisible:false,
          form: {
              assetName:'',
              des:'',
              userId:''
          }
        }
    },
    methods: {
      assetApplyHandle(flag) {
          this.dialogVisible = true
          if (flag == 0) {
              ajaxUtils.post("/api/asset/apply_asset",this.form,result=> {
                  if (result.code == 200) {
                      this.$message.success("申请成功，等该管理员处理");
                  } else {
                    this.$message.info(result.message)
                  }
              })
            this.dialogVisible = false
          }
      },
        getAssets() {
          ajaxUtils.send("/api/asset/list",{userId:this.userId},result=>{
            console.log(result)
            if (result.code == 200) {
              this.assets.data = result.result
              this.assets.init = true
            }
          })
        },
        handleAsset(assetId) {
          let params  = {
            teacherId:this.userId,
            list:[assetId]
          }
          ajaxUtils.post("/api/asset/recycle",params,result=> {
            if(result.code == 200) {
              this.$message.success("申请成功，等待处理！")
            }else {
              this.$message.error("申请失败，稍后重试！")
            }
          })
        }
    },
    watch: {
        userId: function () {
            this.getAssets()
        }
    }

  }


</script>
<style style="text/css">

</style>
