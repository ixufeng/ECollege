<template>
  <div style="width: 100%;">
    <e-avatar></e-avatar>
    <div class="maintitle">
      <h1 class="font">个人荣誉</h1>
    </div>
    <div class="honor">
      <el-row :gutter="60">
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <img :src="ETeacher.honor">
            <div class="mainBody">
              <div class="title">
                <span>获</span>
                <b>奖</b>
              </div>
              <div class="content">
                <div class="h3">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</div>
                <p>date:&nbsp;<span style="color:#bfe7cd">2017.4.14</span></p>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500
                  when an unknown printer it to make a type specimen book. It has survived not only five centuries, but also the leap.
                  and typesetting industry.</p>
                <el-button type="primary" style="background: #2c333d;border:none;margin-left: 20px">Readmore>></el-button>
              </div>
            </div>

          </div>
        </el-col>
        <el-col :span="12" style="margin-right: 0px;">
          <div class="grid-content bg-purple">
            <img :src="ETeacher.academic">
            <div class="mainBody">
              <div class="title">
                <span>学</span>
                <b>术</b>
              </div>
              <div class="content">
                <div class="h3">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</div>
                <p>date:&nbsp;<span style="color:#bfe7cd">2017.4.14</span></p>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500
                  when an unknown printer it to make a type specimen book. It has survived not only five centuries, but also the leap.
                  and typesetting industry.</p>
                <el-button type="primary" style="background: #2c333d;border:none;margin-left: 20px">Readmore>></el-button>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
      <el-row  :gutter="60" style="margin-top: 60px">
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <img :src="ETeacher.recognize">
            <div class="mainBody">
              <div class="title">
                <span>表</span>
                <b>彰</b>
              </div>
              <div class="content">
                <div class="h3">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</div>
                <p>date:&nbsp;<span style="color:#bfe7cd">2017.4.14</span></p>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500
                  when an unknown printer it to make a type specimen book. It has survived not only five centuries, but also the leap.
                  and typesetting industry.</p>
                <el-button type="primary" style="background: #2c333d;border:none;margin-left: 20px">Readmore>></el-button>
              </div>
            </div>

          </div>
        </el-col>
        <el-col :span="12" style="margin-right: 0px;">
          <div class="grid-content bg-purple">
            <img :src="ETeacher.media">
            <div class="mainBody">
              <div class="title">
                <span>煤</span>
                <b>体</b>
              </div>
              <div class="content">
                <div class="h3">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</div>
                <p>date:&nbsp;<span style="color:#bfe7cd">2017.4.14</span></p>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500
                  when an unknown printer it to make a type specimen book. It has survived not only five centuries, but also the leap.
                  and typesetting industry.</p>
                <el-button type="primary" style="background: #2c333d;border:none;margin-left: 20px">Readmore>></el-button>
              </div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
  export default{
      data() {
          return{
              ETeacher:{
                  honor:"/static/honor.png",
                  academic:"/static/academic.png",
                  recognize:"/static/recognize.png",
                  media:"/static/media.png"
              }
          }
      }
  }
</script>
<style>
  .honor{
    width: 60%;
    margin: 50px auto;
  }
  .font{
    width:120px;
    margin:30px auto;
    font-size: 2.5em;
    color: #2C333D;
  }
  .title{
    float:left;
    width:70px;
    height:100px;
    border-right:1px solid #B6B3B3;
  }
  .title span{
    display: block;
    text-align: center;
    font-size: 3em;
    font-weight: bold;
    color:#bfe7cd;
    margin-top:7px;
  }
  .title b{
    display: block;
    text-align: center;
    font-size: 1.8em;
    font-weight: 500;
    color:#bfe7cd;
    margin-top: 6px;
  }
  .content{
    float: right;
    width: 470px;
  }
  .content .h3{
    line-height: 2em;
    font-size: 1.3em;
    color:#2c333d;
    padding-left: 20px;
    margin-top: 10px;
  }
  .content p{
    line-height: 2em;
    font-size: 1em;
    color:#A09F9F;
    padding-left: 20px;
  }
</style>
