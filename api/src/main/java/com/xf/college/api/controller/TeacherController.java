package com.xf.college.api.controller;

import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

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

    /**
     * 获取所有老师信息
     * @return
     */
    public APIResult getAllTeachers() {
        return asSuccess(teacherService.selectAll());
    }

    public APIResult getTeachers(
            @RequestParam("name") String name
    ) {
        if (Objects.equals(name,null)) {
            return asBadRequest("姓名不能为空");
        }
        return asSuccess(teacherService.findByName( name ));
    }



}
