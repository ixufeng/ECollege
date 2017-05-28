let commonUtils = {}

{
    commonUtils.getRandomNum = function() {
        return Math.round(Math.random() * 10000)
    }
    commonUtils.formatDate = (timeStamp, fmt) => {
        if(fmt==null){
            fmt = "yyyy-MM-dd"
        }
        let date = new Date(timeStamp)
        var o = {
            "M+": date.getMonth() + 1, //月份
            "d+": date.getDate(), //日
            "h+": date.getHours(), //小时
            "m+": date.getMinutes(), //分
            "s+": date.getSeconds(), //秒
            "q+": Math.floor((date.getMonth() + 3) / 3), //季度
            "S": date.getMilliseconds() //毫秒
        }
        if (/(y+)/.test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
        }
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            }
        }
        return fmt
    }
    commonUtils.random = function(start, end) {
        return Math.floor(Math.random() * (end - start + 1)) + start
    }

    commonUtils.getTimeStamp = (date)=>{
        if(date==null){
            return (new Date()).getTime()
        }
        return date.getTime()
    }

    commonUtils.clone = (obj)=> {
        if(typeof obj !== 'object'){
            return null
        }

        return JSON.parse(JSON.stringify(obj))
    }
    commonUtils.getDayEndTimeStamp = (timeStamp) => {
        let str = commonUtils.formatDate(timeStamp,"yyyy/MM/dd")
        let strFull = str + " " + "23:59:59"
        return   new Date(Date.parse(strFull));
    }
    commonUtils.createIndexByTime = ( from ,to )=> {
        let max = commonUtils.getDayEndTimeStamp(to)
        let index = []
        do{
            index.push('span_event-' + commonUtils.formatDate(from, 'yyyy-MM-dd'))
            from = from + 24 * 60 * 60 * 1000
        }while (from <= max)
        return index
    }
    commonUtils.toFixed = (val,num)=> {
        if(val==null || typeof num !='number') {
            return val
        }
        return val.toFixed(num)
    }
}

export default commonUtils
