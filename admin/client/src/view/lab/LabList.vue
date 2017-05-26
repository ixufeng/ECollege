<template>
    <div style="width: 100%;">
      <el-table
        :data="labList"
        style="width: 100%">
        <el-table-column
          prop="roomNumber"
          label="实验室编号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="roomType"
          label="类型">
        </el-table-column>
        <el-table-column
          prop="adminName"
          label="管理员">
        </el-table-column>
        <el-table-column
          prop="useCount"
          label="使用次数">
        </el-table-column>
        <el-table-column
          prop="des"
          label="描述">
        </el-table-column>
        <el-table-column
          prop="des"
          label="现状">
        </el-table-column>
        <el-table-column
          label="操作">
          <template scope="scope">
              <el-button size="small">标记为</el-button>
              <el-button size="small" type="info">修改</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  export default {
        data () {
            return {
                labList:[]
            }
        },
        methods: {
            loadData() {
                let url = "/api/lab/all"
                ajaxUtils.send(url,null,result=> {
                    if (result.code == 200) {
                        this.labList = result.result
                    }
                    console.log(result)
                })
            }
        },
        mounted() {
            this.loadData()
        }
    }
</script>
<style type="text/css">

</style>
