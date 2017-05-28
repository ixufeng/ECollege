<template>
  <div style="width: 100%;">
    <el-checkbox-group @change="filterAsset" style="margin: 20px" v-model="checkList">
      <el-checkbox label="未分配资产"></el-checkbox>
      <el-checkbox label="已分配资产"></el-checkbox>
      <el-checkbox label="损坏资产"></el-checkbox>
    </el-checkbox-group>
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
        label="现状">
        <template scope="scope">
            <el-button v-if="scope.row.valid==1" type="text">用使中</el-button>
            <el-button v-if="scope.row.valid==2" type="text">转移中</el-button>
            <el-button v-if="scope.row.valid==-1" type="text" style="color:red">已损坏</el-button>
        </template>
      </el-table-column>
      <el-table-column
        label="使用者">
        <template scope="scope">
            <span>{{scope.row.userName}}</span>
            <el-button v-if="scope.row.userName == null" type="info" size="small" @click="allocation(scope.row.id)">分配</el-button>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="200">
        <template scope="scope">
          <el-button size="small" v-if="scope.row.userId == null" type="danger" @click="remove(scope.row.id)">报废</el-button>
          <el-button size="small" type="info" @click="markAs(scope.row.id,1)">标记为</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[20, 40, 60, 100]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="assetBack.length">
    </el-pagination>
    <el-dialog title="资产标记" v-model="dialogVisible">
      <el-form>
        <el-form-item label="标记为" label-width="100px">
          <el-select v-model="assetMark" placeholder="请选择">
              <el-option label="损坏" value="-1"></el-option>
              <el-option label="使用中" value="1"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="markAs(null,0)">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  export default {
      data() {
          return {
            asset:[],
            assetBack:[],
            checkList: [],
            currentPage:1,
            pageSize:20,
            dialogVisible:false,
            assetMark:'',
            markId:''
          }
      },
      methods: {
          markAs(id,flag) {

            if(flag == 1) {
              this.markId = id
              this.dialogVisible = true
              return
            }
            let params = {
              id:this.markId,
              state:this.assetMark
            }
            ajaxUtils.post("/api/asset/mark",params,result=> {
              if (result.code == 200) {
                this.$message.success("标记成功!")
              }else {
                this.$message.error(result.message)
              }
            })
            this.dialogVisible = false
          },
          handleSizeChange(val) {
              this.pageSize = val
          },
          handleCurrentChange(val) {
              let start = (val-1) * this.pageSize
              this.asset = [...this.assetBack].splice(start,this.pageSize)
          },
          filterAsset() {
              this.asset = []
              if (this.checkList.length == 0) {
                  this.asset = [...this.assetBack]
              }
              this.assetBack.map(item=> {
                  if (this.checkList.indexOf("已分配资产")!= -1) {
                      if (item.userId !=null) {
                          this.asset.push(item)
                      }
                  }
                  if (this.checkList.indexOf("未分配资产")!= -1) {
                      if (item.userId ==null) {
                        this.asset.push(item)
                      }
                  }
                  if (this.checkList.indexOf("损坏资产")!= -1) {
                    if (item.valid == -1) {
                      this.asset.push(item)
                    }
                  }
              })
              console.log(this.checkList)
          },
          allocation(id) {
            let url = "/api/asset_apply/allocation"
            this.$prompt("请输入分配人编号","驳回",{
              confirmButtonText: '确定',
              cancelButtonText: '取消',
            }).then(({value})=> {
              let params = {
                assetId:id,
                userId:value
              }
              ajaxUtils.send(url,params,result=> {
                if(result.code == 200) {
                  this.$message.success("操作成功");
                } else {
                  this.$message.error(result.message)
                }
              })
            })
          },
          loadAsset() {
              let url = "/api/asset/all";
              ajaxUtils.send(url,null,result => {
                  if(result.code == 200) {
                      this.assetBack = [...result.result]
                      this.handleCurrentChange(1)
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
