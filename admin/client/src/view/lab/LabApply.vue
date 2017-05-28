<template>
  <div style="width: 100%">
    <el-radio-group style="margin: 20px" @change="change" v-model="radio">
      <el-radio :label="0">未处理</el-radio>
      <el-radio :label="1">处理历史</el-radio>
    </el-radio-group>
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
          <el-button type="success" v-if="scope.row.state==0" size="mini" @click=handleLabApply(scope.row.id,2)>同意</el-button>
          <el-button type="danger" v-if="scope.row.state==0" size="mini" @click="handleLabApply(scope.row.id,3)">驳回</el-button>
        </template>
      </el-table-column>
      <el-table-column
        label="状态">
        <template scope="scope">
          <el-button type="text" v-if="scope.row.state==2" size="mini">已同意</el-button>
          <el-button type="text" v-if="scope.row.state==3" size="mini">已驳回</el-button>
          <el-button type="text" v-if="scope.row.state==1" size="mini">待审核</el-button>
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
        labApply:[],
        labApplyBack:[],
        radio:1
      }
    },
    methods: {
      change() {
          this.labApply = []
          this.labApplyBack.map(item=> {
              if (this.radio == 0) {
                  this.labApply = this.labApplyBack.filter(item=> item.state == 0)
              }else  {
                  this.labApply = this.labApplyBack.filter(item=> item.state != 0)
              }
          })

      },
      handleLabApply(labId,flag) {
          let params = {
              labApplyId:labId,
              state:flag
          }
          if (flag == 3) {
            this.$prompt("请输入原因","提示",{
              confirmButtonText: '确定',
              cancelButtonText: '取消',
            }).then(({value})=> {
                params.result = value
                ajaxUtils.send("/api/lab_apply/handle",params,result=> {
                    if (result.code == 200) {
                        this.$message.success("操作成功")
                    } else {
                        this.$message.error(result.message)
                    }
                })
            })
          }else {
            ajaxUtils.send("/api/lab_apply/handle",params,result=> {
                if (result.code == 200) {
                    this.$message.success("操作成功")
                }else {
                    this.$message.error(result.message)
                }
            })
          }
      },
      initData() {
        ajaxUtils.send("/api/lab_apply/all",null,result=> {
          if (result.code == 200) {
              this.labApplyBack = result.result
              this.change()
          }
        })
      },
      agreeApply(labNumber) {

      },
      disagreeApply(labNumber) {

      }
    },
    watch:{

    },
    mounted() {
        this.initData()
    }
  }
</script>
<style>

</style>
