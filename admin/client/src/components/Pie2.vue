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
   				     backgroundColor: '#2c343c',

				    title: {
				        text: '饼状图',
				        left: 'center',
				        top: 20,
				        textStyle: {
				            color: '#ccc'
				        }
				    },

				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },

				    visualMap: {
				        show: false,
				        min: 80,
				        max: 600,
				        inRange: {
				            colorLightness: [0, 1]
				        }
				    },
				    series : [
				        {
				            name:'访问来源',
				            type:'pie',
				            radius : '55%',
				            center: ['50%', '50%'],
				            data:[
				                {value:335, name:'直接访问'},
				                {value:310, name:'邮件营销'},
				                {value:274, name:'联盟广告'},
				                {value:235, name:'视频广告'},
				                {value:400, name:'搜索引擎'}
				            ].sort(function (a, b) { return a.value - b.value}),
				            roseType: 'angle',
				            label: {
				                normal: {
				                    textStyle: {
				                        color: 'rgba(255, 255, 255, 0.3)'
				                    }
				                }
				            },
				            labelLine: {
				                normal: {
				                    lineStyle: {
				                        color: 'rgba(255, 255, 255, 0.3)'
				                    },
				                    smooth: 0.2,
				                    length: 10,
				                    length2: 20
				                }
				            },
				            itemStyle: {
				                normal: {
				                    color: '#c23531',
				                    shadowBlur: 200,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				            },

				            animationType: 'scale',
				            animationEasing: 'elasticOut',
				            animationDelay: function (idx) {
				                return Math.random() * 200;
				            }
				        }
				    ]
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