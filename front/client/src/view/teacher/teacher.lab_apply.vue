<template>
  <div style="width: 100%">
    <el-table
      :data="applyData"
      style="width: 100%">
      <el-table-column
        prop="labId"
        label="实验室编号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="classes"
        label="使用课时"
        width="180">
      </el-table-column>
      <el-table-column
        prop="createTime"
        label="申请时间">
      </el-table-column>
      <el-table-column
        label="处理状态">
        <template scope="scope">
          <span v-if="scope.row.state==0">等待审核</span>
          <span v-if="scope.row.state==1">处理成功</span>
          <span v-if="scope.row.state==2">未通过</span>
        </template>
      </el-table-column>
      <el-table-column
        prop="handlerName"
        label="审核人">
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  export default {
      data() {
          return {
              applyData:[]
          }
      },
      props:["userId"],
      methods:{
          initData() {
              let url = "/api/lab_apply/list"
              let params = {
                  userId:this.userId,
                  state:-1
              }
              ajaxUtils.send(url,params,result=> {
                  if (result.code == 200) {
                      console.log('apply',result)
                      this.applyData = result.result
                  }
              })
          }
      },
      watch: {
        userId: function () {
          this.initData()
        }
      }
  }

</script>
<style>

</style>
