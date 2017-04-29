package com.xf.college.service.charts;

import com.xf.college.common.utils.DateUtils;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by xufeng on 2017/4/26.
 */
public class Range {

    private LocalDate from;
    private LocalDate to;

    public Range (){
       this.to = LocalDate.now();
       this.from = LocalDate.of(this.to.getYear()-5,1,1);
    }
    public Range(long from,long to) {
        if ( from > to ) { //keep from less than to
            this.from = LocalDate.ofEpochDay(to);
            this.to = LocalDate.ofEpochDay(from);
        }else {
            this.from = LocalDate.ofEpochDay(from);
            this.to = LocalDate.ofEpochDay(to);
        }
    }
    public Range(LocalDate from,LocalDate to) {
        if (from==null || to==null) {
            throw new NumberFormatException("时间范围不能为空！");
        }
        if (from.compareTo(to) > 0) { //keep from less than to
            this.to = from;
            this.from = to;
        }else {
            this.from = from;
            this.to = to;
        }
    }
    /**
     * 比较年份的区间，以from 为基准
     * @param date
     * @return
     */
   public boolean isInYearRange(Date date) {
       LocalDate from = DateUtils.ofLocalDte(date);
        if ( from == null ) {
            return false;
        }
        int y = from.getYear();
        if (from.getYear() >= this.from.getYear() && from.getYear()<=this.to.getYear()) {
            return  true;
        }
        return false;
   }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public  LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }
}
