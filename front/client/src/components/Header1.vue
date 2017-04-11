<template lang="html">
    <div class="e-header">
        <el-row style="background-color: #2c333d;" :gutter="20">
             <el-col :offset="2" :span="6">
                <div class="header-con">
                    <p><i class="el-icon-message"></i>&nbsp;&nbsp;Email : 1054993687@qq.com</p>
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
                     <p>xxxxxxx</p>
                 </div>
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
        padding-left: 50px;
        padding-right: 50px;
        line-height: 100px;
        text-align: center;
    }

    .header-con p{
        color: #fff;
        font-size: 1em;
        margin-top: 1.1em;
    }
    .header-nav-con{
        padding-left: 100px;
        padding-right: 100px;
        background-color: #2c333d;
    }
    .header-nav{
        text-align: center;
        color: #fff;
        padding-left: 40px;
        padding-right: 40px;
    }
</style>
