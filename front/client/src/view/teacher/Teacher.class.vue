<template>
    <div  style="width: 100%">
      <e-avatar></e-avatar>
      <el-row>
        <el-col :offset="2" :span="20">
          <div style="margin-top: 10px">
            <span style="text-align: center;padding-left: 20px;">
              <el-button size="middle" @click="showForm"  style="margin-left: 0px;" type="success"><i class="iconfont icon-shenqing"></i>添加课程</el-button>
            </span>
          </div>
          <el-table
            :data="pageData"
            stripe
            style="width: 100%;margin-top: 20px;">
            <el-table-column
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column
              prop="beginTime"
              label="年份"
              width="180">
            </el-table-column>
            <el-table-column
              prop="courseId"
              label="科目编号"
              width="200">
            </el-table-column>
            <el-table-column
              prop="courseName"
              label="科目名称"
              width="180">
            </el-table-column>
            <el-table-column
              prop="majorNumber"
              label="专业编号"
              width="180">
            </el-table-column>
            <el-table-column
              prop="address"
              label="学期">
            </el-table-column>
            <el-table-column
            label="操作">
              <template scope="scope">
                <el-button
                  type="text"
                  size="small">
                  移除
                </el-button>
                <el-button
                  type="text"
                  size="small">
                  修改
                </el-button>
              </template>
            </el-table-column>

          </el-table>
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="current_page"
            :page-sizes="[10, 20]"
            :page-size="page_size"
            layout="total, sizes, prev, pager, next, jumper"
            :total="tableData.length">
          </el-pagination>
        </el-col>
      </el-row>
      <el-dialog title="新增课程" v-model="dialogVisible" size="tiny" width="200px">
        <el-form :model="form">
            <el-select v-model="form.courseId" placeholder="请选择科目" class="e-form">
              <el-option v-for="item in course"
                :label="item.courseName + '('+ item.courseId +')'"
                :value="item.courseId">
              </el-option>
            </el-select><br/>
            <el-input v-model="form.majorId" placeholder="请输入专业号" type="number" class="e-form"></el-input><br/>
            <el-date-picker
              class="e-form"
              v-model="form.beginTime"
              type="month"
              placeholder="请选择开始时间">
            </el-date-picker><br/>
            <el-date-picker
              class="e-form"
              v-model="form.endTime"
              type="month"
              placeholder="请选择结束时间">
            </el-date-picker>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addNewClass">确 定</el-button>
        </div>
      </el-dialog>
    </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  import store from '../../store/index'
  import userUtils from '../../common/utils/UserUtils'
  import {getSessionUser,setSessionUser} from '../../storage/index'
  export default {
      computed: {
          pageData() {
              let start = (this.current_page - 1) * this.page_size
              return [...this.tableData].splice(start,this.page_size)
          }
      },
    data() {
        return{
            page_size:10,
            current_page:1,
            tableData:[],
            dialogVisible:false,
            teacher: {},
            form: {
                teacherId:'',
                courseId:'',
                majorId:'',
                beginTime:'',
                endTime:''
            },
            course:[],
        }
    },
    methods: {
      handleSizeChange(size) {
          this.page_size = size;
      },
      handleCurrentChange(pageIndex) {
          this.current_page = pageIndex
      },
      initData() {
        let teacher = userUtils.isTeacher()
        if (!teacher) {
          store.commit("SHOW_LOGIN",true)
          return
        }
        this.teacher = teacher
        let params = {
            teacherId:teacher.id
        }
        ajaxUtils.send("/api/course/list",params,result=> {
            if (result.code==200) {
                console.log(result.result)
                this.tableData = result.result
            } else if ( result.code == 414) {
              store.commit("SHOW_LOGIN",true)
              return
            }
        })
      },
      addNewClass() {
          this.form.teacherId = this.teacher.id;
          this.form.beginTime = new Date(this.form.beginTime).getTime()
          this.form.endTime = new Date(this.form.endTime).getTime()
          ajaxUtils.post("/api/course/history/add",this.form,result=> {
              if (result.code == 200 ) {
                  this.$message.success("插入成功！")
                  this.dialogVisible = false
              }else {
                  this.$message.error(result.message || "unKnown error")
              }
          })
      },


      showForm() {
          this.dialogVisible = true
          this.loadCourseList()
      },
      loadCourseList(){
          ajaxUtils.send("/api/course/all",null,result=>{
              if (result.code == 200) {
                this.course = result.result;
              }
          })
      }
    },
    mounted() {
        this.initData()
    }
  }
</script>
<style>
  .time-text{
    font-family:"webfont" !important;
    font-size:16px;font-style:normal;
    -webkit-font-smoothing: antialiased;
    -webkit-text-stroke-width: 0.2px;
    -moz-osx-font-smoothing: grayscale;
  }
.e-form{
  width: 95%;
  margin-top: 5px;
  margin-bottom: 5px;
}

</style>
