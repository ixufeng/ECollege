<template>
  <div style="width: 100%">
    <e-avatar></e-avatar>
    <el-row :gutter="10">
      <el-col  :md="8" :lg="6">
        <div class="grid-content bg-purple">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span style="line-height: 20px;font-size: 16px">近期发表的论文</span>
            <el-button style="float: right;"  size="small" type="primary" @click="addNewStudy(1)">添加论文</el-button>
          </div>
          <div v-for="o in article"  class="study-item">
            <a @click="pickStudy(o)"><i class="iconfont icon-yanjiubaogao"></i> &nbsp;&nbsp;&nbsp;{{o.studyName}}</a>
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span style="line-height: 20px;font-size: 16px">我的专利</span>
            <el-button style="float: right;" size="small" type="primary"  @click="addNewStudy(1)">添加专利</el-button>
          </div>
          <div v-for="o in patent"  class="study-item">
            <a @click="pickStudy(o)"><i class="iconfont icon-yanjiubaogao"></i>{{o.studyName}}</a>
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span style="line-height: 20px;font-size: 16px">我的项目</span>
            <el-button style="float: right;" size="small" type="primary"  @click="addNewStudy(1)">添加项目</el-button>
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
          <div style="display: block;">
            <study-histogram :userId="teacher.id" _type="bar"></study-histogram>
          </div>
          <div v-if="currentStudy!=null" style="width: 100%;">
            <div class="title">
              <span> <i class="iconfont icon-bumenchuangxinyanjiubu"></i> {{currentStudy.studyName}}</span>
              <span style="float: right;font-size: 13px ;color: #7b7b7b;margin-right: 10px"><i class="iconfont icon-shijian"></i>&nbsp;创建时间：{{timeFormat(currentStudy.beginTime)}}</span>
            </div>
            <div>
              <span class="small-title"><i class="iconfont icon-hand"></i>研究方向</span>
              <p style="margin-left: 40px">
                {{currentStudy.studyType}}
              </p>
              <span class="small-title"><i class="iconfont icon-hand"></i>研究简介</span>
              <p style="margin-left: 40px;line-height: 20px">
                {{currentStudy.studyIntro}}
              </p>
              <span class="small-title"><i class="iconfont icon-hand"></i>友情链接</span>
              <p style="margin-left: 40px">
                {{currentStudy.studyLink}}
              </p>
            </div>
          </div>
        </el-card>
        </div>
      </el-col>
    </el-row>
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
            dialogVisible:false,
            teacher:{},
            studyData:{},
            currentStudy:null,
            form: {
                beginTime:'',
                studyType:'',
                intro:'',
                userId:'',
                studyName:''
            }
          }
      },
      components: {
        studyHistogram
      },
      methods: {
          addNewStudy(flag) {
              this.dialogVisible = true
              if(flag == 0) {
                  this.form.userId = this.teacher.id
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
          timeFormat(time,fmt) {
              return commonUtils.formatDate(time,fmt);
          },
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
    padding-bottom: 20px;
    margin: 5px;
  }
  .study-item{
    cursor:pointer;
    line-height: 20px;
  }
  .study-item :hover{
    color: #0086b3;
    text-decoration: underline;
  }
  .title{
    margin-top: 10px;
    height:30px;
    padding-left: 10px;
    border: 1px solid #ccc;
    line-height: 30px;
    font-size: 15px;
    color: #03a9f3;
    font-weight: 600;
  }
  .small-title{
    margin-top: 40px;
    font-size: 14px;
    font-weight: 600;
    line-height: 30px;
  }

</style>
