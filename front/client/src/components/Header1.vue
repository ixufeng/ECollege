<template lang="html">
    <div class="e-header">
        <el-row style="background-color: #2c333d;" :gutter="20">
             <el-col :offset="3" :span="6">
                <div class="header-con">
                    <i class="el-icon-message"></i>&nbsp;&nbsp;Email : 1054993687@qq.com
                </div>
             </el-col>
             <el-col :span="6">
                 <div class="header-con">
                     <h1 class="p-title">
                         <a href="#">ECollege</a>
                     </h1>
                 </div>
             </el-col>
             <el-col :span="6">
                 <div class="header-con">
                       <i class="iconfont icon-QQ1"></i>&nbsp;&nbsp;&nbsp;&nbsp;
                       <i class="iconfont icon-weixin"></i>
                 </div>
             </el-col>
        </el-row>
      <el-row style="background-color: #2c333d;">
          <el-col :offset="6" :span="12">
             <el-row :gutter="20">
                <el-col :span="6"><div class="small-title"><i class="iconfont icon-jiaoshi-copy">&nbsp;</i>TEACHER</div></el-col>
                <el-col :span="6"><div class="small-title"><i class="iconfont icon-xuesheng"></i>&nbsp;STUDENT</div></el-col>
                <el-col :span="6"><div class="small-title"><i class="iconfont icon-shiyanshi1"></i>&nbsp;LABORATORY</div></el-col>
                <el-col :span="6"><div class="small-title"><i class="iconfont icon-about"></i>&nbsp;CONTACT</div></el-col>
             </el-row>
          </el-col>
      </el-row>
    </div>
</template>

<script>
export default {

}
</script>

<style lang="css">

    .e-header{
        width: 100%;
    }
    .p-title a{
        text-align: center;
        text-decoration: none;
        color: #bfe7cd;
        font-size: 1.4em;
    }
    .header-con{
        padding-left: 30px;
        padding-right: 30px;
        line-height: 100px;
        text-align: center;
    }

    .header-con {
        color: #fff;
        font-size: 1em;
        margin-top: 1.1em;
        text-align: center;
    }
   .small-title{
      text-align: center;
      line-height: 20px;
      height: 40px;
      color: #eee;
      cursor: pointer;
      font-size: 1.1em;
      font-size: 16px;
      font-weight:700;
  }
  .small-title:hover{
    color: #bfe7cd;
  }
</style>
