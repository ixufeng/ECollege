<template>
  <div style="width: 100%">
    <el-table
      :data="applyData"
      style="width: 100%">
      <el-table-column
        prop="assetNumber"
        label="申请编号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="assetName"
        label="申请内容"
        width="usedCount">
      </el-table-column>
      <el-table-column
        prop="createTime"
        label="申请时间">
      </el-table-column>
      <el-table-column
        label="处理状态">
          <template scope="scope">
              <span v-if="scope.row.state==0">等待处理</span>
              <span v-if="scope.row.state==1">处理成功</span>
              <span v-if="scope.row.state==2">未通过</span>
          </template>
      </el-table-column>
    </el-table>
  </div>

</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  export  default {
      props:["userId"],
      data() {
          return{
              applyData:[]
          }
      },
      methods: {
          initData() {
              let params = {
                  userId:this.userId
              }
              ajaxUtils.send("/api/asset/apply",params,result=> {
                  if ( result.code == 200 ) {
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
