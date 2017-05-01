<template>
  <div style="width:100%;height: auto;">
    <el-row>
       <el-col :span="11" >
         <div style="width: 100%;height: 360px;margin-left: 20px" id="pie-charts">
         </div>
       </el-col>
        <el-col :span="12">
          <div style="width: 100%;height: 360px;" id="his-charts">

          </div>
        </el-col>
    </el-row>
  </div>

</template>
<script>
  import eCharts from 'echarts'
  import ajaxUtils from '../../http/ajaxUtils'
  export default {
      data () {
          return {
              legendData:[],
              pieData: [],
              hisDataY:[]
          }
      },
      computed: {
         option () {
             return {
               title : {
                 text: '电信学院实验室组成',
                 subtext: '详情可咨询管理员',
                 x:'center'
               },
               tooltip : {
                 trigger: 'item',
                 formatter: "{a} <br/>{b} : {c}个({d}%)"
               },
               legend: {
                 orient: 'vertical',
                 left: 'left',
                 data: this.legendData
               },
               series : [
                 {
                   name: '实验室',
                   type: 'pie',
                   radius : '55%',
                   center: ['50%', '60%'],
                   data:this.pieData,
                   itemStyle: {
                     emphasis: {
                       shadowBlur: 10,
                       shadowOffsetX: 0,
                       shadowColor: 'rgba(0, 0, 0, 0.5)'
                     }
                   }
                 }
               ]
             }
         },
        histogramOptions() {
             return {
               title : {
                 subtext: '实验室使用总次数分布',
                 x:'center'
               },
               color: ['#3398DB'],
               tooltip : {
                 trigger: 'axis',
                 axisPointer : {
                   type : 'shadow'
                 }
               },
               grid: {
                 left: '3%',
                 right: '4%',
                 bottom: '3%',
                 containLabel: true
               },
               xAxis : [
                 {
                   type : 'category',
                   data : this.legendData,
                   axisTick: {
                     alignWithLabel: true
                   }
                 }
               ],
               yAxis : [
                 {
                   type : 'value'
                 }
               ],
               series : [
                 {
                   name:'直接访问',
                   type:'bar',
                   barWidth: '60%',
                   data:this.hisDataY
                 }
               ]
             }
        }
      },
      methods: {
          initData() {
              let  url = "/api/lab/group_chart"
              ajaxUtils.send(url,null,result=> {
                  console.log(result)
                  if (result.code == 200) {
                      let source = result.result
                      for (let key in source) {
                          this.pieData.push({
                              name:key,
                              value:source[key].number
                          })
                          this.hisDataY.push(source[key].useCount)
                          this.legendData.push(key)
                      }
                    let dom = document.getElementById("pie-charts")
                    let hisDom = document.getElementById("his-charts")
                    let myCharts = eCharts.init(dom)
                    let myCharts1 = eCharts.init(hisDom)
                    myCharts.setOption(this.option)
                    myCharts1.setOption(this.histogramOptions)
                  }
              })
          }
      },
      mounted() {
          this.initData()
      }
  }
</script>
<style>

</style>
