<template>
    <div style="width: 100%">
      <el-radio-group style="margin: 20px" @change="change" v-model="radio">
        <el-radio :label="1">未处理</el-radio>
        <el-radio :label="2">处理历史</el-radio>
      </el-radio-group>
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
          prop="userId"
          label="申请人编号"
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
          label="操作">
            <template scope="scope">
                <el-button v-if="scope.row.state==0" size="small" @click="refuse(scope.row.id)">驳回</el-button>
                <el-button v-if="scope.row.state==0" size="small">分配资产</el-button>
            </template>
        </el-table-column>
        <el-table-column
          label="状态">
          <template scope="scope">
            <el-button v-if="scope.row.state==1" type="text" size="small">已分配</el-button>
            <el-button v-if="scope.row.state==2" type="text" size="small">已驳回</el-button>
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
                asset_apply:[],
                asset_apply_back:[],
                radio:1
            }
        },
        methods: {
            change(val) {
                    this.asset_apply = []
                    this.asset_apply_back.map(item=> {
                        if (val == 1) {
                            if(item.state == 0) {
                              this.asset_apply.push(item)
                            }
                        } else {
                          if(item.state != 0) {
                            this.asset_apply.push(item)
                          }
                        }

                    })
            },
            initData() {
                ajaxUtils.send("/api/asset/apply/all",null,result=> {
                    if (result.code == 200) {
                        this.asset_apply_back = result.result
                        this.asset_apply = this.change(1)
                    }
                })
            },
            refuse(id) {
              let url = "/api/asset_apply/refuse"
                this.$prompt("请输入理由","驳回",{
                  confirmButtonText: '确定',
                  cancelButtonText: '取消',
                }).then(({value})=> {
                    let params = {
                        id:id,
                        result:value
                    }
                    ajaxUtils.send(url,params,result=> {
                        if(result.code == 200) {
                          this.$message.success("操作成功");
                        } else {
                            this.$message.error(result.message)
                         }
                    })
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
