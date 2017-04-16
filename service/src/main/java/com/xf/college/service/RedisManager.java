package com.xf.college.service;

import com.xf.college.model.student.Student;
import com.xf.college.model.teacher.Teacher;

import java.util.List;

/**
 * Created by xufeng on 2017/3/27.
 */
public interface RedisManager {

    List<Teacher> getAllTeacherFromDB();
    List<Student> getAllStudentFromDB();

    Teacher getTeacher(String key);
    Student getStudent(String key);

}
