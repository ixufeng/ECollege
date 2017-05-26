package com.xf.college.model.laboratory;

import java.util.Date;

/**
 * Created by xufeng on 2017/4/26.
 */
public class LabRoom {
    private String roomNumber;
    private String des;
    private String roomType;
    private String admin;  //
    private String adminName; //for vo
    private int valid;
    private Date beginTime;
    private long useCount;


    public LabRoom () {

    }

    public LabRoom (String roomNumber,String des,String roomType,Date beginTime,long useCount) {
        this.roomNumber = roomNumber;
        this.des = des;
        this.roomType = roomType;
        this.beginTime = beginTime;
        this.useCount = useCount;
        this.valid = 0;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public long getUseCount() {
        return useCount;
    }

    public void setUseCount(long useCount) {
        this.useCount = useCount;
    }
}
