package com.xf.college.model.laboratory;

import java.util.Date;

/**
 * Created by xufeng on 2017/3/25.
 * used to record
 */
public class UseRecord {
    private int id;
    private int state;
    private String userId;
    private String equipmentId;  //使用物品的编号
    private Date beginTime;
    private Date endTime;

    public UseRecord() {
    }


    public UseRecord(int state, String userId, String equipmentId, Date beginTime, Date endTime) {
        this.state = state;
        this.userId = userId;
        this.equipmentId = equipmentId;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
