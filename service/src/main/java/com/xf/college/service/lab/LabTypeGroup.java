package com.xf.college.service.lab;

/**
 * Created by xufeng on 2017/5/1.
 * 实验室按类型聚合的一些参数
 */
public class LabTypeGroup {
    private int number;
    private long useCount;





    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getUseCount() {
        return useCount;
    }
    public void addUseCount(long useCount) {
        this.useCount += useCount;
    }

    public void setUseCount(int useCount) {
        this.useCount = useCount;
    }
}
