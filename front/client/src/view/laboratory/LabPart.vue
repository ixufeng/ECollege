<template>
  <div style="width: 100%;height: 420px;">
    <div style="width: 100%;height: 60px;">
      <img style="width: 100%;height:60px;-webkit-transform: rotateY(180deg);" src="/static/cutter1.png" />
    </div>
    <el-row>
      <el-col :span="18">
        <lab-pie></lab-pie>
      </el-col>
      <el-col :span="4" :offet="2">
        <el-button type="success">立即预约</el-button>
      </el-col>
    </el-row>
  </div>
</template>
<script>
  import labPie from '../../components/charts/LabPie.vue'
  export default {
      data() {
          return {

          }
      },
      methods: {

      },
      components: {
          labPie
      }
  }

</script>
<style>

</style>
