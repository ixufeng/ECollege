<template>
    <div style="width: 100%">
      <e-avatar></e-avatar>
      <el-row>
        <el-col :offset="2" :span="20">
          <div style="margin-top: 10px">
            <span style="text-align: center;padding-left: 20px;">
              <el-button size="middle"  style="margin-left: 0px;" type="success"><i class="iconfont icon-shenqing"></i>添加课程</el-button>
            </span>
          </div>
          <el-table
            :data="tableData"
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
        </el-col>
      </el-row>
    </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  import store from '../../store/index'
  import userUtils from '../../common/utils/UserUtils'
  export default {
    data() {
        return{
            tableData:[]
        }
    },
    methods: {
      initData() {
        let teacher = userUtils.isTeacher()
        if (!teacher) {
          store.commit("SHOW_LOGIN",true)
          return
        }
        let params = {
            teacherId:teacher.id
        }
        ajaxUtils.send("/api/course/list",params,result=> {
            if (result.code==200) {
                console.log(result.result)
                this.tableData = result.result
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


</style>
