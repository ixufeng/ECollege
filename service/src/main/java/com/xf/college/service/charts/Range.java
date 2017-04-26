package com.xf.college.service.charts;

import java.time.LocalDate;

/**
 * Created by xufeng on 2017/4/26.
 */
public class Range {

    private LocalDate from;
    private LocalDate to;

    public Range (){
       this.from = LocalDate.now();
       this.to = LocalDate.of(this.from.getYear(),1,1);
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
     * @param from
     * @return
     */
   public boolean isInYearRange(LocalDate from) {
        if ( from == null ) {
            return false;
        }
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
