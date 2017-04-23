package com.xf.college.model.teacher;

import java.util.Date;

/**
 * Created by xufeng on 2017/3/25.
 */
public class ClassHistory {
    private int id;
    private  String teacherId;
    private String courseId;
    private String courseName; //for vo
    private String majorNumber;
    private String majorName;// for vo
    private Date beginTime;
    private Date endTime;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getMajorNumber() {
        return majorNumber;
    }

    public void setMajorNumber(String classNumber) {
        this.majorNumber = classNumber;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String className) {
        this.majorName = className;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) {
            return  this ==obj;
        }
        if (obj.getClass() ==this.getClass()) {
            ClassHistory that = (ClassHistory) obj;
            if (that.getId() == this.id) {
                return true;
            }
        }
        return  false;
    }

    @Override
    public int hashCode() {
        return this.id * this.teacherId.hashCode();
    }
}
