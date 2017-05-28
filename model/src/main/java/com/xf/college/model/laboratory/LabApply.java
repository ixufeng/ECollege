package com.xf.college.model.laboratory;

import java.util.Date;

/**
 * Created by xufeng on 2017/4/29.
 */
public class LabApply {

    public final static int FIRST_CLASS = 1;
    public final static int SECOND_CLASS = 2;
    public final static int THIRD_CLASS = 3;
    public final static int FORTH_CLASS = 4;
    public final static int FIFTH_CLASS = 5;

    private int id;
    private String labId;
    private String labType;
    private String userId;
    private String userName;//for vo
    private String handlerId;
    private String handlerName; //for vo
    private final Date createTime;
    private String currentDay; //yyyy-MM-dd
    private String classes;   //申请的课时
    private int state;   //申请状态  1 等待 2 通过完成 3 未通过
    private String des;
    private String result;   //结果的描述信息 如管理员 拒绝，可以给出理由


    public LabApply() {
        this.createTime = new Date();
        this.state = 0;
        this.des = "无";
    }

    public LabApply(String labId,String labType,String userId,String currentDay,String classes){
        this.labId = labId;
        this.classes = classes;
        this.userId = userId;
        this.currentDay = currentDay;
        this.labType = labType;
        this.createTime = new Date();
        this.des = "无";
        this.state = 0;
    }

    public String getLabType() {
        return labType;
    }

    public void setLabType(String labType) {
        this.labType = labType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getClasses() {
        return classes;
    }
    public String[] getClassValue() {
        if (this.classes == null || this.classes.trim().equals("")) {
            return new String[0];
        }
        return this.classes.split(",");
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(String currentDay) {
        this.currentDay = currentDay;
    }
}
