<template>
    <div  v-if="isLogin" style="width: 100%;">
      <e-avatar></e-avatar>
        <el-row class="row-style">
          <el-col class="teacher-item" :offset="3" :span="8">
            <el-row style="height: 240px;">
                <el-col :span="6" style="padding-top: 50px">
                  <el-badge :value="7">
                    <a href="/teacher/data">
                      <i class="iconfont icon-jiaoshi-copy teacher-item-icon"></i>
                    </a>
                  </el-badge>
                  <h2>管理中心</h2>
                </el-col>
                <el-col :span="18">
                  <br>
                  <br>
                  <br>
                  <br>
                  <a href="#" style="height: 25px;line-height: 25px;">你有三个资源更新了状态</a><br>
                  <a href="#" style="height: 25px;line-height: 25px;">有新的任务为处理</a><br>
                  <a href="#" style="height: 25px;line-height: 25px;">上次登录时间为 20：08</a><br>
                </el-col>
            </el-row>
          </el-col>
          <el-col class="teacher-item" :offset="2" :span="8">
            <el-row style="height: 240px;">
              <el-col :span="6" style="padding-top: 50px">
                <el-badge :value="7">
                  <a href="/teacher/honor">
                    <i class="iconfont icon-rongyu teacher-item-icon"></i>
                  </a>
                </el-badge>
                <h2>个人荣誉</h2>
              </el-col>
              <el-col :span="18">
                  <honor-histogram :userId="teacher.id"></honor-histogram>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row class="row-style">
          <el-col class="teacher-item" :offset="3" :span="8">
            <el-row style="height: 240px;">
              <el-col :span="6" style="padding-top: 50px">
                <el-badge :value="3">
                  <a href="/teacher/class">
                    <i class="iconfont icon-kecheng teacher-item-icon"></i>
                  </a>
                </el-badge>
                <h2>历史课程</h2>
              </el-col>
              <el-col :span="18">
                  <histogram :userId="teacher.id"></histogram>
              </el-col>
            </el-row>
          </el-col>
          <el-col class="teacher-item" :offset="2" :span="8">
            <el-row style="height: 240px;">
              <el-col :span="6" style="padding-top: 50px">
                <el-badge :value="1">
                  <a href="/teacher/study">
                    <i class="iconfont icon-jiaoyuyanjiu teacher-item-icon"></i>
                  </a>
                </el-badge>
                <h2>科研情况</h2>
              </el-col>
              <el-col :span="18">
                <study-histogram :userId="teacher.id"></study-histogram>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
    </div>
</template>
<script>
  import ajaxUtils from '../../http/ajaxUtils'
  import store from '../../store/index'
  import userUtils from '../../common/utils/UserUtils'
  import histogram from '../../components/charts/TeacherHistogram.vue'
  import honorHistogram from '../../components/charts/TeacherHistogramHonor.vue'
  import studyHistogram from '../../components/charts/TeacherHistogramStudy.vue'
  import tableContainer from '../../components/TableContainer.vue'
  export default {
      data() {
          return {
              teacher: {

              }
          }
      },
      methods: {
          initTeacherPage() {
              this.teacher = userUtils.isTeacher()
              if (!this.teacher) {
                  store.commit("SHOW_LOGIN",true)
                  return
              }
          }
      },
      components: {
        histogram,
        honorHistogram,
        studyHistogram,
        tableContainer
      },

      mounted() {
          this.initTeacherPage()
      },
      computed: {
           isLogin : ()=>{
               return !store.getters.showLogin
           }
      }


  }
</script>

<style type="text/css">
  .teacher-item-icon {
    margin-top: 20px;
    font-size: 80px;
    color: #BFE7CD;
    cursor: pointer;
  }
  .teacher-item-icon:hover {
    color: #00cfbd;
  }
  .teacher-item {
    margin-top: 10px;
    border: 1px solid #ccc;
    padding-left: 20px;

  }
  .teacher-item-text {
    width: 80%;
    float: right;
    padding-top: 30px;
  }
  .teacher-item h2 {
    font-family: 'Nunito-Bold';

  }
  .row-style{

  }

</style>
