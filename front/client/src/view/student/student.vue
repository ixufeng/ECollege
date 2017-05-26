<template>
  <div style="width: 100%">
  <el-tabs v-model="activeName" style="width: 100%;" @tab-click="handleTabClick">
    <el-tab-pane label="我的项目" name="first">
        <div class="s_cover">
          <div class="left_con">
            <el-autocomplete
              v-model="state"
              style="width: 300px;"
              :fetch-suggestions="queryPro"
              placeholder="项目搜索"
              @select="selectPro"
            ></el-autocomplete>
           <el-button style="float: right;margin-right: 80px" size="small" @click="addNewStudy">添加项目</el-button>
          </div>
          <el-table
            :data="pro"
            style="width: 100%">
            <el-table-column
              prop="studyName"
              label="项目名称"
              width="250">
            </el-table-column>
            <el-table-column
              prop="studyType"
              label="项目类型"
              width="180">
            </el-table-column>
            <el-table-column
              prop="studyLink"
              label="项目链接">
            </el-table-column>
            <el-table-column
              prop="studyIntro"
              label="项目介绍">
            </el-table-column>
            <el-table-column
              label="操作">
              <template scope="scope">
                  <el-button size="small" type="danger" @click="deletePro(scope.row.id)">删除</el-button>
                  <el-button size="small" type="info">修改</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
    </el-tab-pane>
    <el-tab-pane label="我的荣誉" name="second">
      <div class="s_cover">
        <div class="s_cover">
          <div class="left_con">
            <el-autocomplete
              v-model="state"
              style="width: 300px;"
              :fetch-suggestions="queryPro"
              placeholder="项目搜索"
              @select="selectPro"
            ></el-autocomplete>
            <el-button style="float: right;margin-right: 80px" size="small" @click="addNewStudy">添加荣誉</el-button>
          </div>
          <el-table
            :data="honor"
            style="width: 100%">
            <el-table-column
              prop="des"
              label="荣誉"
              width="250">
            </el-table-column>
            <el-table-column
              prop="honorType"
              label="荣誉类型"
              width="180">
            </el-table-column>
            <el-table-column
              prop="achieveTime"
              label="获取时间">
            </el-table-column>
            <el-table-column
              label="操作">
              <template scope="scope">
                <el-button size="small" type="danger" @click="deletePro(scope.row.id)">删除</el-button>
                <el-button size="small" type="info">修改</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </div>
    </el-tab-pane>
    <el-tab-pane label="消息通知" name="third">
      <div class="s_cover">
          消息通知
      </div>
    </el-tab-pane>
  </el-tabs>
    <el-dialog title="新增项目" v-model="dialogVisible" size="tiny" width="200px">
      <el-form :model="form">
        <el-form-item style="width: 80%" label="项目名称" label-width="100px">
          <el-input v-model="form.studyName" placeholder="课程名称"  class="e-form"></el-input><br/>
        </el-form-item>
        <el-form-item style="width: 80%" label="项目类别" label-width="100px">
          <el-select v-model="form.studyType" placeholder="请选择项目类别" class="e-form">
            <el-option
              label="科学研究"
              value="科学研究"
            ></el-option>
            <el-option
              label="教学研究"
              value="教学研究">
            </el-option>
            <el-option
              label="论文"
              value="论文">
            </el-option>
            <el-option
              label="专利"
              value="专利">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item style="width: 80%" label="项目时间" label-width="100px">
          <el-date-picker
            class="e-form"
            v-model="form.beginTime"
            type="month"
            placeholder="请选择开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item style="width: 80%" label="项目介绍" label-width="100px">
          <el-input v-model="form.intro"  type="textarea"   class="e-form"></el-input><br/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addNewStudy(0)">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  import store from '../../store/index'
  import userUtils from '../../common/utils/UserUtils'
  import studyHistogram from '../../components/charts/TeacherHistogramStudy.vue'
  import commonUtils from '../../common/commonUtils'
  export default {
      data() {
        return {
          student:null,
          activeName:"first",
          state:'',
          pro:[],
          honor:[],
          form: {
            beginTime:'',
            studyType:'',
            intro:'',
            userId:'',
            studyName:''
          },
          dialogVisible:false,
        }
      },
      methods: {
          addNewStudy(flag) {
            this.dialogVisible = true
            if(flag == 0) {
              this.form.userId = this.student.id
              ajaxUtils.post("/api/study/add",this.form,result=> {
                if(result.code == 200) {
                  this.$message.success("添加成功！")
                } else if (result.code == 414) {
                  this.$message.error("请先登录")
                }

              })
              this.dialogVisible = false
            }
          },
          deletePro(proId) {
              if(proId) {
                  if(window.confirm("确认删除")) {
                      let params = {
                          studyId: proId
                      }
                      ajaxUtils.post("/api/study/delete1",params,result=>{
                          if (result.code == 200) {
                              this.$message.success("删除成功")
                          }else {
                              this.$message.error(result.message)
                          }
                    })
                  }
              }
          },
          handleTabClick(tab) {
              if(tab.name == "second") {
                  this.loadPro(1)
              } else if(tab.name == "third") {
                  this.loadPro(2)
              }
          },
          loadPro(flag) {
              let url = "/api/study/list"
              if (flag == 1) {
                  url = "/api/honor/list"
              } else if (flag == 2) {
                  url = ""
              }
              let params = {
                  userId:this.student.id
              }
              ajaxUtils.send(url,params,result=> {
                  if(result.code == 200) {
                      console.log(result)
                      if(flag == 1) {
                          this.honor = result.result
                      }else if (flag == 2) {

                      }else {
                        this.pro = result.result
                      }
                  }else if (result.code == 414) {
                    store.commit("SHOW_LOGIN",true)
                    return
                  }
              })
          },
          initData() {

          },
          queryPro(str) {

          },
          selectPro(item) {

          }
      },
      computed() {

      },
      mounted() {
        this.student = userUtils.isStudent()
        if (!this.student) {
            store.commit("SHOW_LOGIN",true)
            return
        }
        this.loadPro()
      }
  }
</script>
<style type="text/css">
  .s_cover{
    width:100%;
    padding-left: 30px;
    padding-right: 30px;
  }
  .left_con{
    width:100%;
    height: 30px;
    border:1px solid #ccc;
  }
</style>
