<template>
  <div style="width: 100%;">
    <el-table
      :data="asset"
      style="width: 100%">
      <el-table-column
        prop="id"
        label="编号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="typeId"
        label="类型编号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="price"
        label="价格">
      </el-table-column>
      <el-table-column
        prop="model"
        label="模型">
      </el-table-column>
      <el-table-column
        prop="buyTime"
        label="购买时间">
      </el-table-column>
      <el-table-column
        prop="incoming"
        label="入库时间">
      </el-table-column>
      <el-table-column
        prop="factoryName"
        label="厂家">
      </el-table-column>
      <el-table-column
        prop="des"
        label="现状">
      </el-table-column>
      <el-table-column
        prop="userName"
        label="使用者">
      </el-table-column>
      <el-table-column
        label="操作"
        width="200">
        <template scope="scope">
          <el-button size="small">报废</el-button>
          <el-button size="small">标记为</el-button>
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
            asset:[]
          }
      },
      methods: {
          loadAsset() {
              let url = "/api/asset/all";
              ajaxUtils.send(url,null,result => {
                  if(result.code == 200) {
                      this.asset = result.result
                  }
                  console.log(result)
              })

          }
      },
      mounted() {
          this.loadAsset()
      }
  }
</script>
<style type="text/css">

</style>
