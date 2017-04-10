package com.xf.college.model;

/**
 * Created by xufeng on 2017/3/27.
 */
public class HonorType {
    private  int id;
    private String name;
    private String des;

    public HonorType(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
