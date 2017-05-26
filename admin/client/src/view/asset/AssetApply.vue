<template>
    <div style="width: 100%">
      <el-table
        :data="asset_apply"
        style="width: 100%">
        <el-table-column
          prop="id"
          label="申请编号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="assetName"
          label="申请资产"
          width="180">
        </el-table-column>
        <el-table-column
          prop="userName"
          label="申请人">
        </el-table-column>
        <el-table-column
          prop="createTime"
          label="申请时间">
        </el-table-column>
        <el-table-column
          prop="des"
          label="申请理由">
        </el-table-column>
        <el-table-column
          label="申请理由">
            <template scope="scope">
                <el-button size="small">驳回</el-button>
                <el-button size="small">分配资产</el-button>
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
                asset_apply:[]
            }
        },
        methods: {
            initData() {
                ajaxUtils.send("/api/asset/apply/all",null,result=> {
                    if (result.code == 200) {
                        this.asset_apply = result.result
                    }
                    console.log(result)
                })
            }
        },
        mounted() {
            this.initData()
        }
    }
</script>
<style>

</style>
