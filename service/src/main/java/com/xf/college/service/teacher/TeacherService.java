package com.xf.college.service.teacher;

import com.xf.college.model.teacher.Teacher;

import java.util.List;

/**
 * Created by xufeng on 2017/3/27.
 */
public interface TeacherService {

    Teacher select(String teacherId);
    List<Teacher> selectAll();
    List<Teacher> findByName(String name);
}
