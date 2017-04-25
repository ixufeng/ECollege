package com.xf.college.service;

import com.xf.college.dao.CourseDao;
import com.xf.college.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by xufeng on 2017/4/24.
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> getCourseList() {

        return courseDao.selectAll();
    }

    @Override
    public Course getCourseById(String id) {
        if (Objects.equals(id,null)) {
            return null;
        }
        return courseDao.select(id);
    }

    @Override
    public List<Course> getCourseByName(String name) {
        if (Objects.equals(name,null)) {
            return Collections.emptyList();
        }
        return courseDao.selectByName(name);
    }
}
