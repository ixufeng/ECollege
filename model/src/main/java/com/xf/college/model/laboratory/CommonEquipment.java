package com.xf.college.model.laboratory;

import java.util.Date;

/**
 * Created by xufeng on 2017/3/25.
 */
public class CommonEquipment {
    private String id;  //
    private String name;
    private String type;
    private Date beginTime;
    private int valid;
    private int usedCount;  //使用次数
    private String des;  //描述
    private String remark;  //备注
    private String imgs;

    public String getImgs() {
        return imgs;
    }
    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public int getUsedCount () {
        return usedCount;
    }

    public void setUsedCount(int usedCount) {
        this.usedCount = usedCount;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
