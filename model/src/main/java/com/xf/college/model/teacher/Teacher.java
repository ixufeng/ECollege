package com.xf.college.model.teacher;

import java.util.Date;

/**
 * Created by xufeng on 2017/3/25.
 */
public class Teacher {
    private String id;
    private String name;
    private String password;
    private String avatars; //头像
    private String sex;
    private String identity;
    private String phone;
    private Date birthday;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getAvatars1() {
        if(this.avatars!=null) {
            return this.avatars.split(",");
        }
        return new String[0];
    }

    public String getAvatars() {
        return this.avatars;
    }

    public void setAvatars(String avatar) {
        this.avatars = avatar;
    }

    /**
     * 添加头像
     * @param avatar
     */
    public void addAvatars(String avatar) {
        if (this.avatars!=null) {
            this.avatars +="," + avatar;
            return;
        }
        this.avatars = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
