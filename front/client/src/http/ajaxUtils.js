/**
 * Created by xufeng on 2017/4/16.
 */
import $ from 'jQuery'
let ajaxUtils = {}

ajaxUtils.send = (url,params,callback) => {
  let fullUrl = _initParams(url,params)
  $.ajax({
    url:fullUrl,
    type:'GET',
    success: (result)=> {
      callback(result)
    },
    error: (result)=> {
      callback(-1,result)
    }
  })
}
ajaxUtils.post = (url,params,callback) => {
  $.ajax({
    url:url,
    type:'POST',
    data:params,
    dataType: "json",
    success: (result)=> {
      callback(result)
    },
    error: (result)=> {
      callback(-1,result)
    }
  })
}
ajaxUtils.put = (url,params,callback) => {
  $.ajax({
    url:url,
    type:'PUT',
    data:params,
    dataType: "json",
    success: (result)=> {
      callback(result)
    },
    error: (result)=> {
      callback(-1,result)
    }
  })
}

let _initParams = (url,params) => {
  if (!params) {
    return url
  }

  url = url + "?"

  for (let item in params) {
    url = url + item + "=" + params[item] + "&"
  }
  return url
}

export  default  ajaxUtils
