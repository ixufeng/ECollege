<template>
    <div style="width: 100%;">
      <el-table
        :data="course"
        style="width: 100%">
        <el-table-column
          prop="courseId"
          label="课程编号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="courseName"
          label="课程名称"
          width="180">
        </el-table-column>
        <el-table-column
          prop="createTime"
          label="录入时间">
        </el-table-column>
        <el-table-column
          label="操作">
          <template scope="scope">
              <el-button size="small" type="danger" @click="deleteCourse(scope.row.courseId)">删除</el-button>
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
              course:[]
          }
      },
      methods: {
          deleteCourse(courseId) {
              if (window.confirm("确认删除?")) {
                  let params = {
                      courseId:courseId
                  }
                  ajaxUtils.post("/api/course/del",params,result=> {
                      if (result.code = 200) {
                          this.$message.success("删除成功");
                      }else {
                          this.$message.error(result.message)
                      }
                  })
              }
          },
          initData() {
              console.log("load data")
              let url = "/api/course/all"
              ajaxUtils.send(url,null,result=> {
                  if (result.code == 200) {
                      this.course = result.result
                  }else  {
                      this.$message.error(result.message)
                  }
              })
          }
      },
      mounted() {
          this.initData()
      }
  }

</script>
<style type="text/css">

</style>
