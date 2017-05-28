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
              <el-button size="small" @click="markAs(scope.row.id,1)">标记为</el-button>
              <el-button size="small" type="info" @click="modify(scope.row)">修改</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10,20, 40, 60, 100]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="labListBack.length">
      </el-pagination>
      <el-dialog title="实验室标记" v-model="dialogVisible">
        <el-form>
          <el-form-item label="标记为"  label-width="100px">
            <el-select v-model="labMark" placeholder="请选择">
              <el-option label="维护中" value="2"></el-option>
              <el-option label="损坏" value="1"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="markAs(null,0)">确 定</el-button>
        </div>
      </el-dialog>
      <el-dialog title="实验室修改" v-model="dialogVisible2">
          <el-form>
            <el-form-item label="编号" label-width="100px">
              <el-input :value="modifyLab.roomNumber"  :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="类型" label-width="100px">
              <el-input :value="modifyLab.roomType"></el-input>
            </el-form-item>
            <el-form-item label="使用次数" label-width="100px">
              <el-input :value="modifyLab.useCount" type="number"></el-input>
            </el-form-item>
            <el-form-item label="描述" label-width="100px">
              <el-input :value="modifyLab.des"></el-input>
            </el-form-item>
          </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="modify(null,0)">确 定</el-button>
        </div>
      </el-dialog>
    </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  export default {
        data () {
            return {
                labList:[],
                labListBack:[],
                currentPage:1,
                pageSize:10,
                dialogVisible:false,
                dialogVisible2:false,
                markId:'',
                labMark:'',
                modifyLab:{
                    roomNumber:'',
                    roomType:'',
                    des:'',
                    useCount:''
                }
            }
        },
        methods: {
          modify(item,flag) {
              Object.assign(this.modifyLab,item)
              this.dialogVisible2 = true
              if(flag == 0) {  //submit
                  this.dialogVisible2 = false
                  ajaxUtils.post("/api/lab/modify",this.modifyLab,result=> {
                      console.log(this.modifyLab)
                      if (result.code == 200) {
                          this.$message.success("修改成功");
                      } else {
                          this.$message.error(result.message);
                      }
                  })
              }
          },
          markAs(id,flag) {
              if (flag == 1) {
                  this.markId = id
                  this.dialogVisible = true
                  return
              }
              let params = {
                  labId:this.markId,
                  labMark:this.labMark
              }
              ajaxUtils.send("/api/lab/mark",params,result=> {
                  if (result.code == 200) {
                      this.$message.success("更新成功");
                  } else {
                      this.$message.error(result.message)
                  }
              })

          },
          handleSizeChange(val) {
            this.pageSize = val
            this.handleCurrentChange(this.currentPage)
          },
          handleCurrentChange(val) {
            this.currentPage = val
            this.labList = []
            let start = (val-1) * this.pageSize
            this.labList = [...this.labListBack].splice(start,this.pageSize)
            console.log(this.labList)
          },
            loadData() {
                let url = "/api/lab/all"
                ajaxUtils.send(url,null,result=> {
                    if (result.code == 200) {
                        this.labListBack = result.result
                        this.handleCurrentChange(1)
                    }
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
