<template>
    <div style="width: 100%;height: auto;">
        <lab-part></lab-part>
        <div>
          <center><h2>实验室预约</h2></center>
          <el-row>
            <el-col :span="3" :offset="2">
              <span>选择实验室类型</span>
            </el-col>
            <el-col :span="19">
              <el-radio class="radio" v-model="radio" v-for="(item,index) in labTypeGroup"  :label="index">{{index}}</el-radio>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="3" :offset="2">
              <span>选择实验室</span>
            </el-col>
            <el-col :span="19 ">
                <el-row style="padding-right: 40px">
                  <el-col class="time-cell" :span="3">test</el-col>
                    <el-col class="time-cell" v-for="item in nextWeek" :span="3"><span>{{week[item.getDay()]}}</span></el-col>
                </el-row>
                <el-row style="padding-right: 40px">
                  <el-col class="cell" v-for="item in 24" :span="3">J405</el-col>
                </el-row>
            </el-col>
          </el-row>
        </div>
    </div>
</template>
<script>
  import LabPart from './LabPart.vue'
  import ajaxUtils from '../../http/ajaxUtils'
  import timeUtils from '../../common/utils/timeUtils'
  export default {
      data() {
          return {
              labTypeGroup: {},
              radio:'',
              week:["周日","周一","周二","周三","周四","周五","周六"],
              nextWeek:timeUtils.getNextDays(7)
          }
      },
      components: {
          LabPart
      },

      methods: {
          initData() {
              ajaxUtils.send("/api/lab/group_type",null,result=> {
                  if (result.code==200) {
                      this.labTypeGroup = result.result
                  }
              })
          },
          loadLabState() {

          }
      },
      mounted() {
          this.initData()
      }

  }
</script>
<style type="text/css">
  .cell {
    border: 1px solid #03a9f4;
    height: 100px;
    margin-top: -1px;
    margin-left: -1px;

  }
  .cell :hover {
    border: 1px solid #cccccc;
    height: 100px;
    margin-top: -1px;
    margin-left: -1px;
    background-color: #03a9f4;
  }
  .time-cell {
      border: 1px solid #cccccc;
      height: 40px;
      margin-top: -1px;
      margin-left: -1px;
  }
</style>
