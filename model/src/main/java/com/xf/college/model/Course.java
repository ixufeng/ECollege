package com.xf.college.model;

import java.util.Date;

/**
 * Created by xufeng on 2017/4/23.
 */
public class Course {
    private String courseId;
    private String courseName;
    private Date createTime;


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
