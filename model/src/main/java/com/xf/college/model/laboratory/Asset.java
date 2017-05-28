package com.xf.college.model.laboratory;

import java.util.Date;

/**
 * Created by xufeng on 2017/3/25.
 */
public class Asset {
    private String id;  //编号
    private String name;
    private String typeId; //分类号
    private Date beginTime;
    private int valid;    //现状 0 在库中，1 在使用中 ，2 处理中/申请转移中 ，仍在使用者手中 -1 损坏
    private int usedCount;  //使用次数
    private String des;  //描述
    private String remark;  //备注
    private String imgs;  //

    //新增
    private String model; //型号
    private String specification; //规格
    private double price;  //单价
    private String nationality; //国别
    private String factoryName;
    private Date buyTime;
    private String userId;  //领用人编号
    private String userName;//for vo
    private String handleUserId;//经手人
    private String handleUserName;// for vo
    private Date incoming;//入库时间
    private Date lastUseTime; //最后一次使用时间

    public Asset () {

    }

    public Asset(String id,String name,String model,String type,String des,String factoryName,Date buyTime,String nation,double price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.typeId = type;
        this.des = des;
        this.factoryName = factoryName;
        this.buyTime = buyTime;
        this.nationality = nation;
        this.price = price;
        this.incoming = new Date();
    }



    public String getImgs() {
        return imgs;
    }
    public String[] getImgs1() {
        return imgs==null?new String[0]:imgs.split(",");
    }
    public void addImg(String img) {
        if (img==null) return;
        if (this.imgs==null) this.imgs = img;
        else this.imgs += "," + img;
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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
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

    public String getHandleUserId() {
        return handleUserId;
    }

    public void setHandleUserId(String handleUserId) {
        this.handleUserId = handleUserId;
    }

    public String getHandleUserName() {
        return handleUserName;
    }

    public void setHandleUserName(String handleUserName) {
        this.handleUserName = handleUserName;
    }

    public Date getIncoming() {
        return incoming;
    }

    public void setIncoming(Date incoming) {
        this.incoming = incoming;
    }

    public Date getLastUseTime() {
        return lastUseTime;
    }

    public void setLastUseTime(Date lastUseTime) {
        this.lastUseTime = lastUseTime;
    }


}
