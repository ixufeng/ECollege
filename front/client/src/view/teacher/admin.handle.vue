<template>
  <div>
    <el-table
      :data="labApply"
      style="width: 100%">
      <el-table-column
        prop="labId"
        label="实验室编号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="userName"
        label="申请人"
        width="180">
      </el-table-column>
      <el-table-column
        prop="currentDay"
        label="使用时间">
      </el-table-column>
      <el-table-column
        prop="classes"
        label="申请课时">
      </el-table-column>
      <el-table-column
        label="操作">
        <template scope="scope">
          <el-button type="success" size="mini">同意</el-button>
          <el-button type="danger" size="mini">驳回</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  export default {
      data() {
          return {
              labApply:[]
          }
      },
      props:["userId"],
      methods: {
          initData() {
              ajaxUtils.send("/api/lab_apply/all",null,result=> {
                  if (result.code == 200) {
                    this.labApply = result.result
                  }

              })
          },
        agreeApply(labNumber) {

        },
        disagreeApply(labNumber) {

        }
      },
      watch:{
          userId:function (val) {
              if (val) {
                  this.initData()
              }
          }
      }
  }
</script>
<style>

</style>
