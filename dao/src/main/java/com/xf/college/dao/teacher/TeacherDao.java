package com.xf.college.dao.teacher;

import com.xf.college.model.teacher.Teacher;

import java.util.List;

/**
 * Created by xufeng on 2017/3/27.
 */
public interface TeacherDao {

    void add (Teacher teacher);
    void delete(String id);
    void update(Teacher teacher);
    Teacher select(String id);
    List<Teacher> selectAll();
    List<Teacher> selectByName(String name);

}
