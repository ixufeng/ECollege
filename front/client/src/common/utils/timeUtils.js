/**
 * Created by xufeng on 2017/4/23.
 */
Date.prototype.Format = function (fmt) { //author: meizz
  var o = {
    "M+": this.getMonth() + 1, //月份
    "d+": this.getDate(), //日
    "h+": this.getHours(), //小时
    "m+": this.getMinutes(), //分
    "s+": this.getSeconds(), //秒
    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
    "S": this.getMilliseconds() //毫秒
  };
  if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
  return fmt;
}

let timeUtils = {}
/**
 * 获取未来的几天
 * @param dayNum
 * @returns {[*]}
 */
timeUtils.getNextDays =(dayNum)=> {
  var oDate = new Date();   //获取当前时间
  var dayArr = [];     //定义一个数组存储所以时间
  for(var i=0;i<dayNum;i++){
    dayArr.push(new Date(oDate.getFullYear(),oDate.getMonth(),oDate.getDate() + i));   //把未来几天的时间放到数组里
  }
  return dayArr;   //返回一个数组。
}

export default timeUtils




