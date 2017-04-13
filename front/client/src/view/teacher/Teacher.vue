<template>
    <div style="width: 100%;">
        <e-avatar></e-avatar>
        <el-row style="width: 100%;">
          <el-col class="teacher-item" :offset="4" :span="8">
            <el-row>
                <el-col :span="6">
                  <el-badge :value="7">
                    <i class="iconfont icon-jiaoshi-copy teacher-item-icon"></i>
                  </el-badge>
                  <h2>个人资料</h2>
                </el-col>
                <el-col :span="18">
                  <p>
                    sdfsgfsg
                  </p>
                </el-col>
            </el-row>
          </el-col>
          <el-col class="teacher-item" :offset="4" :span="6">
            <el-row>
              <el-col :span="6">
                <el-badge :value="7">
                  <i class="iconfont icon-rongyu teacher-item-icon"></i>
                </el-badge>
                <h2>个人荣誉</h2>
              </el-col>
              <el-col :span="18">
                <p>
                  sdfgdyhrthrtjhrj
                </p>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row>
          <el-col class="teacher-item" :offset="4" :span="8">
            <el-row>
              <el-col :span="6">
                <el-badge :value="3">
                  <i class="iconfont icon-kecheng teacher-item-icon"></i>
                </el-badge>
                <h2>历史课程</h2>
              </el-col>
              <el-col :span="18">
                <p>wesgyertujh</p>
              </el-col>
            </el-row>
          </el-col>
          <el-col class="teacher-item" :offset="4" :span="6">
            <el-row>
              <el-col :span="6">
                <el-badge :value="1">
                  <i class="iconfont icon-jiaoyuyanjiu teacher-item-icon"></i>
                </el-badge>
                <h2>科研情况</h2>
              </el-col>
              <el-col :span="18">
                <p>
                  sgrdhttjh
                </p>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
    </div>
</template>
<script>
  export default {
      methods: {

      },
      mounted() {
          console.log(this.$route)
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
    padding-top: 30px;
    height:180px;
    padding-bottom: 10px;
  }
  .teacher-item-text {
    width: 80%;
    float: right;
    padding-top: 30px;
  }
  .teacher-item h2 {
    font-family: 'Nunito-Bold';

  }
</style>
