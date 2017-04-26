package com.xf.college.model.teacher;

import java.time.LocalDate;

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
    private LocalDate beginTime;
    private LocalDate endTime;
    private LocalDate createTime;

    public ClassHistory() {

    }
    public ClassHistory(String teacherId,String courseId,String majorNumber,LocalDate beginTime,LocalDate endTime) {
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.majorNumber = majorNumber;
        this.beginTime =beginTime;
        this.endTime = endTime;
        this.createTime = LocalDate.now();
    }


    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
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

    public LocalDate getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDate beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
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

    @Override
    public String toString() {
        return "ClassHistory{" +
                "id=" + id +
                ", teacherId='" + teacherId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", majorNumber='" + majorNumber + '\'' +
                ", majorName='" + majorName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                '}';
    }
}
