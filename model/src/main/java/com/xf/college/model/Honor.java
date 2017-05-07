package com.xf.college.model;

import java.util.Date;

/**
 * Created by xufeng on 2017/3/27.
 */
public class Honor {
    private int id;
    private String teacherId;
    private int honorType;
    private Date achieveTime;
    private String des; //描述
    private String img;

    public Honor(String teacherId, int honorType, Date achieveTime, String des) {
        this.teacherId = teacherId;
        this.honorType = honorType;
        this.achieveTime = achieveTime;
        this.des = des;
    }

    public Honor(int honorType,String des, Date achieveTime) {
        this.honorType = honorType;
        this.des = des;
        this.achieveTime = achieveTime;
    }
    public Honor() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getHonorType() {
        return honorType;
    }

    public void setHonorType(int honorType) {
        this.honorType = honorType;
    }

    public Date getAchieveTime() {
        return achieveTime;
    }

    public void setAchieveTime(Date achieveTime) {
        this.achieveTime = achieveTime;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String imgs) {
        this.img = imgs;
    }
}
