package com.xf.college.api.controller;

import com.xf.college.dao.student.StudentDao;
import com.xf.college.dao.teacher.TeacherDao;
import com.xf.college.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/30.
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;
    @RequestMapping("/hello")
    public Student hello(){

        return studentDao.select("1");
    }
}
