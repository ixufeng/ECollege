package com.xf.college.model;

/**
 * Created by xufeng on 2017/3/15.
 */
public class Demo {
    public Demo() {

    }
    public Demo(String name){
        this.name = name;
    }
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
