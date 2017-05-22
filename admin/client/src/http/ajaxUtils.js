
import $ from "jQuery"
let ajaxUtils = {}

ajaxUtils.get= (url,callback)=>{

	$.ajax({
		 url: url, 
		 type:'GET',
		 success: function(data){
        	callback(data)
      	},
      	error:function(data){
      		callback(data)
      	}
     });

}

ajaxUtils.post = (url,params,reuslt)=>{


}




export default ajaxUtils