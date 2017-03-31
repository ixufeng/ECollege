package com.xf.college.model.common;


import com.xf.college.common.utils.DateUtils;

import java.util.Date;

public final class Range {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_TIME_FORMAT1 = "yyyy-MM-dd'T'HH:mm:ss";

    private final long from;
    private final long to;

    public Range(Date from, Date to) {
        this(from.getTime(), to.getTime());
    }

    public Range(long from, long to) {
        this.from = from;
        this.to = to;
        validate();
    }

    public Range(long from, long to, boolean check) {
        this.from = from;
        this.to = to;
        if (check) {
            validate();
        }
    }

    public static Range createUncheckedRange(long from, long to) {
        return new Range(from, to, false);
    }

    public long getFrom() {
        return from;
    }

    public String getFromDateTime() {
        return DateUtils.longToDateStr(from, DATE_TIME_FORMAT);
    }
    public String getFromDateTime1() {
        return DateUtils.longToDateStr(from, DATE_TIME_FORMAT1) + ".000+08:00";
    }

    public long getTo() {
        return to;
    }

    public String getToDateTime() {
        return DateUtils.longToDateStr(to, DATE_TIME_FORMAT);
    }

    public String getToDateTime1() {
        return DateUtils.longToDateStr(to, DATE_TIME_FORMAT1) + ".000+08:00";
    }

    public long getRange() {
        return to - from;
    }

    public void validate() {
        if (this.to < this.from) {
            throw new IllegalArgumentException("invalid range:" + this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Range range = (Range) o;
        return this.from == range.from && this.to == range.to;
    }

    @Override
    public int hashCode() {
        int result = (int) (from ^ (from >>> 32));
        result = 31 * result + (int) (to ^ (to >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Range{" +
                "from=" + from +
                ", to=" + to +
                ", range=" + getRange() +
                '}';
    }
}
