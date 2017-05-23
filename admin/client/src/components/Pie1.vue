<template lang="html">
   <div>

      <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	    <div id="main" style="width: 600px;height:400px;"></div>
   </div>
</template>

<script>

import echarts from "echarts"

export default {

	props:["data"],

	methods:{
		init(){
			console.log("pie",this.data);

			 // 基于准备好的dom，初始化echarts实例
	        var myChart = echarts.init(document.getElementById('main'));

	        // 指定图表的配置项和数据
	        var option = {
	            title: {
	                text: '分析表'
	            },
	            tooltip: {},
	            legend: {
	                data:['销量']
	            },
	            xAxis: {
	                data: this.data.key
	            },
	            yAxis: {},
	            series: [{
	                name: '销量',
	                type: 'bar',
	                data: this.data.value
	            }]
	        };

	        // 使用刚指定的配置项和数据显示图表。
	        myChart.setOption(option);

		}
	},
	mounted() {
		this.init();
	},
	watch:{
		 data: {
		      handler: function(){
		      	this.init()
		      },
		      deep: true
    	}
	}
 
}

</script>

<style lang="css">

   
</style>