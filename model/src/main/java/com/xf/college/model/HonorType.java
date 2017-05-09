package com.xf.college.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xufeng on 2017/3/27.
 */
public class HonorType {

    private  int id;
    private String name;
    private String des;
    private String img;

    public static final Map<Integer,String> typeMap = new HashMap();

    static {
        typeMap.put(1,"竞赛类");
        typeMap.put(2,"书法类");
        typeMap.put(3,"计算机科学与技术");
        typeMap.put(4,"体育类");
        typeMap.put(5,"音乐类");
    }

    public  static String getTypeName(int code ){
        return typeMap.get(code);
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public HonorType() {

    }
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
