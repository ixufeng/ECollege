<template>
  <div style="width: 100%;">
    <el-row style="background-color: #2c333d;">
      <el-col :offset="6" :span="12">
        <el-row :gutter="20">
          <el-col :span="6"><div class="small-title"><i class="iconfont icon-jiaoshi-copy">&nbsp;</i> <a class="small-title" href="/teacher">TEACHER</a></div></el-col>
          <el-col :span="6"><div class="small-title"><i class="iconfont icon-xuesheng"></i>&nbsp;<a class="small-title" href="/student">STUDENT</a></div></el-col>
          <el-col :span="6"><div class="small-title"><i class="iconfont icon-shiyanshi1"></i>&nbsp;<a class="small-title" href="laboratory">LABORATORY</a></div></el-col>
          <el-col :span="6"><div class="small-title"><i class="iconfont icon-about"></i>&nbsp;<a class="small-title" href="contact">CONTACT</a></div></el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>
<script>

</script>
<style type="text/css">

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
