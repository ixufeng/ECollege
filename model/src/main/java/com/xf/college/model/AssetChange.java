package com.xf.college.model;

import java.util.Date;

/**
 * Created by xufeng on 2017/4/29.
 */
public class AssetChange {
    private String assetNumber;
    private String assetName;
    private String sourceUserId;
    private String sourceUserName; //for vo
    private String destUserId;
    private String destUserName; //for vo
    private Date createTime;
    private Date completeTime;
    private int state;
    private String handlerId;

    public AssetChange() {

    }
    public AssetChange(String assetNumber,String assetName,String sourceUserId) {
        this.assetNumber = assetNumber;
        this.assetName = assetName;
        this.sourceUserId = sourceUserId;
        this.createTime = new Date();
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(String sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public String getDestUserId() {
        return destUserId;
    }

    public void setDestUserId(String destUserId) {
        this.destUserId = destUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    public String getSourceUserName() {
        return sourceUserName;
    }

    public void setSourceUserName(String sourceUserName) {
        this.sourceUserName = sourceUserName;
    }

    public String getDestUserName() {
        return destUserName;
    }

    public void setDestUserName(String destUserName) {
        this.destUserName = destUserName;
    }
}
