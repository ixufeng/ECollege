<!--供应商添加-->
<template>
  <content-module name="dashboard">
      <gysFrom></gysFrom>
  </content-module>
</template>
<script>

//import ajaxUtils from '../http/ajaxUtils.js'

export default {



	data(){
		return{
			pieData:{}
		}
	},

    methods: {

    	getData(){
    		var data = {
    			key:[5, 20, 36, 10, 10, 20],
    			value:[5, 20, 36, 10, 10, 20]
    		}

    		this.pieData = data

    	}
    },
    mounted() {

    	this.getData()
    	// ajaxUtils.get("www.baidu.com?q=123",function(result){
    	// 	console.log(result);
    	// })
    }


}
</script>
