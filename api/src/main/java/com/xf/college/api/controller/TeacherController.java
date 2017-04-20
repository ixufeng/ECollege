package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.honor.HonorService;
import com.xf.college.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Created by xufeng on 2017/4/14.
 */
@RequestMapping("/teacher")
@RestController
public class TeacherController extends BaseController{

    @Autowired
    private HonorService honorService;

    @Autowired
     private TeacherService teacherService;

    @RequestMapping("/info/{teacherId}")
    public APIResult getTeacherInfo(
            @PathVariable("teacherId") String  teacherId
    ) {
        Integer auth = getAuth();
        if (Objects.equals(auth,Auth.TEACHER)||Objects.equals(auth,Auth.ADMIN)) {
            return asSuccess(teacherService.select(teacherId));
        }
        return handleNoAuth(auth);
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
