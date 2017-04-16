/**
 * Created by xufeng on 2017/4/16.
 */
import $ from 'jQuery'
let ajaxUtils = {}

ajaxUtils.send = (url,params,callback) => {
  let fullUrl = _initParams(url,params)
  $.ajax({
    url:url,
    type:'GET',
    success: (result)=> {
      callback(result)
    },
    error: (result)=> {
      callback(-1,result)
    }
  })
}
ajaxUtils.post = (url,params,result) => {
  $.ajax({
    url:url,
    type:'POST',
    success: (result)=> {
      callback(result)
    },
    error: ()=> {
      callback(-1,result)
    }
  })
}

let _initParams = (url,params) => {

}

export  default  ajaxUtils
