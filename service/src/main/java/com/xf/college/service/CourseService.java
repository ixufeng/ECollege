package com.xf.college.service;

import com.xf.college.model.Course;

import java.util.List;

/**
 * Created by xufeng on 2017/4/24.
 */
public interface CourseService {
    List<Course> getCourseList();
    Course getCourseById(String id);
    List<Course> getCourseByName(String name);
}
