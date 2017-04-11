<template>
  <div style="height: 600px; width: 100%">
    <div style="height: 100%; width: 100%; position: relative;">
      <div style="width: 100%;height: 60px; position:absolute;top: 0px; z-index: 1000;">
        <img style="width: 100%;height:60px;" src="/static/cutter.png" />
      </div>
      <el-carousel :interval="5000" height="600px" arrow="always">
        <el-carousel-item v-for="item in 2">
          <h3><img style="width: 100%;height: 100%;" :src="images[item-1]" alt=""></h3>
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>

</template>

<script>
    export default {
        data() {
            return {
              images:["/static/1.jpg","/static/2.jpg"]
            }

        }
    }
</script>

<style>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>
