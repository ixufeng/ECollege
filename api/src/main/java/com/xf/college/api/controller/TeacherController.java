package com.xf.college.api.controller;

import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xufeng on 2017/4/14.
 */
@RequestMapping("/teacher")
public class TeacherController extends BaseController{

    @Autowired
     private TeacherService teacherService;

    @RequestMapping("/info/{teacherId}")
    public APIResult getTeacherInfo(
            @PathVariable("teacherId") String  teacherId
    ) {
        return asSuccess(teacherService.select(teacherId));
    }

}
