package com.xf.college.model.laboratory;

import java.util.Date;

/**
 * Created by xufeng on 2017/5/23.
 */
public class AssetApply {
    private int id;
    private String userId;
    private String userName; // for vo
    private String assetName;
    private Date createTime;
    private String handlerId;
    private String handlerUserName; //for vo
    private String des;

    public AssetApply () {
        this.createTime = new Date();
    }
    public AssetApply(String userId,String assetName,String des) {
        this.userId = userId;
        this.assetName = assetName;
        this.des = des;
        this.createTime = new Date();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    public String getHandlerUserName() {
        return handlerUserName;
    }

    public void setHandlerUserName(String handlerUserName) {
        this.handlerUserName = handlerUserName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
