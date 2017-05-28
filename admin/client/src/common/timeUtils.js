/**
 * Created by xufeng on 2017/4/23.
 */

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
timeUtils.format = (date,fmt)=> {
  let o = {
    "M+": date.getMonth() + 1, //月份
    "d+": date.getDate(), //日
    "h+": date.getHours(), //小时
    "m+": date.getMinutes(), //分
    "s+": date.getSeconds(), //秒
    "q+": Math.floor((date.getMonth() + 3) / 3), //季度
    "S": date.getMilliseconds() //毫秒
  };
  if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
  for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
  return fmt;
}

export default timeUtils




