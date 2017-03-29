package com.xf.college.model.teacher;

import java.util.Date;

/**
 * Created by xufeng on 2017/3/25.
 */
public class TeacherStudy {
    private  int id;
    private String teacherId;
    private String studyName;
    private String studyIntro;
    private String studyType;
    private String studyLink;
    private String studyImg;
    private Date beginTime;

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

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getStudyIntro() {
        return studyIntro;
    }

    public void setStudyIntro(String studyIntro) {
        this.studyIntro = studyIntro;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getStudyLink() {
        return studyLink;
    }

    public void setStudyLink(String studyLink) {
        this.studyLink = studyLink;
    }

    public String getStudyImg() {
        return studyImg;
    }

    public void setStudyImg(String studyImg) {
        this.studyImg = studyImg;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
}
