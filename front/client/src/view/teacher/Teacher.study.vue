<template>
  <div style="width: 100%">
    <e-avatar></e-avatar>
    <el-row :gutter="10">
      <el-col  :md="8" :lg="6">
        <div class="grid-content bg-purple">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span style="line-height: 20px;font-size: 16px">近期发表的论文</span>
            <el-button style="float: right;"  size="small" type="primary">添加论文</el-button>
          </div>
          <div v-for="o in article"  class="study-item">
            <a @click="pickStudy(o)"><i class="iconfont icon-yanjiubaogao"></i> &nbsp;&nbsp;&nbsp;{{o.studyName}}</a>
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span style="line-height: 20px;font-size: 16px">我的专利</span>
            <el-button style="float: right;" size="small" type="primary">添加专利</el-button>
          </div>
          <div v-for="o in patent"  class="study-item">
            <a @click="pickStudy(o)"><i class="iconfont icon-yanjiubaogao"></i>{{o.studyName}}</a>
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span style="line-height: 20px;font-size: 16px">我的项目</span>
            <el-button style="float: right;" size="small" type="primary">添加项目</el-button>
          </div>
          <div v-for="o in project"  class="study-item">
            <a @click="pickStudy(o)"><i class="iconfont icon-jiaoyuyanjiu2"></i> &nbsp;&nbsp;&nbsp;{{o.studyName }}</a>
          </div>
        </el-card>
      </div>
      </el-col>
      <el-col  :md="16" :lg="16">
        <div class="grid-content bg-purple">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span style="line-height: 20px;font-size: 16px">我的项目</span>
            <el-button style="float: right;" size="small" type="primary">添加项目</el-button>
          </div>
          <div class="study-item">
            this is body
          </div>
        </el-card>
        </div>
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
          return {
            teacher:{},
            studyData:{},
            currentStudy:null
          }
      },
      methods: {
          initData() {
            this.teacher = userUtils.isTeacher()
            if (!this.teacher) {
              store.commit("SHOW_LOGIN",true)
              return
            }
            let params = {
                userId:this.teacher.id
            }
            ajaxUtils.send("/api/study/histogram",params,result=> {
              if (result.code==200) {
                  console.log(result)
                 this.studyData = result.result
              }
            })
          },
          pickStudy(study) {
              console.log(study)
            this.currentStudy = study
          }
      },
      computed: {
          project() {
              let result = []
              for (let item in this.studyData) {
                  if (item.indexOf("研究") != -1) {
                      this.studyData[item].map(i => result.push(i))
                  }
              }
              return result
          },
        article() {
          let result = []
          for (let item in this.studyData) {
            if (item.indexOf("论文") != -1) {
              this.studyData[item].map(i => result.push(i))
            }
          }
          return result
        },
        patent() {
          let result = []
          for (let item in this.studyData) {
            if (item.indexOf("专利") != -1) {
              this.studyData[item].map(i => result.push(i))
            }
          }
          return result
        }
      },
      mounted() {
          this.initData();
      },
      watch() {
      }
  }

</script>
<style type="text/css">

  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .box-card{
    margin: 5px;
  }
  .study-item{
    line-height: 20px;
  }

</style>
