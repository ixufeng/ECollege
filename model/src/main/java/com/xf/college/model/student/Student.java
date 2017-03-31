package com.xf.college.model.student;


import java.util.Date;

/**
 * Created by xufeng on 2017/3/25.
 */
public class Student {

    private final String id;
    private String name;
    private String password;
    private String avatars;
    private String profession;
    private final Date admissionTime;


    public Student(String id, String name, String profession, Date admissionTime) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.admissionTime = admissionTime;
    }

    public Student(String id, String name, Date admissionTime) {
        this.id = id;
        this.name = name;
        this.admissionTime = admissionTime;
    }

    public Student(String id, String name, String password, String avatars, String profession, Date admissionTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.avatars = avatars;
        this.profession = profession;
        this.admissionTime = admissionTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

}
