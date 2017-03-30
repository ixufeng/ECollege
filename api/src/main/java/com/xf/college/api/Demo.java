package com.xf.college.api;

import com.xf.college.dao.student.StudentDao;
import com.xf.college.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/30.
 */
@RestController
@RequestMapping("/test")
public class Demo {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/hello")
    public Student hello(){
        return studentDao.select("1");
    }
}
