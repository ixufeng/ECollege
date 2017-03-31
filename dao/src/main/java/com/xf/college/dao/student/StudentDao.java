package com.xf.college.dao.student;

import com.xf.college.model.student.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
public interface StudentDao {

    void add(Student student);
    void delete(String id);
    void update(Student student);
    Student select(String id);
    List<Student> selectAll();
    List<Student> selectByName(String name);

}
