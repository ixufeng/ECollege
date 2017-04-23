package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.teacher.ClassHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufeng on 2017/4/23.
 */
@RequestMapping("/course")
@RestController
public class ClassHistoryController extends BaseController {

    @Autowired
    private ClassHistoryService classHistoryService;

    @RequestMapping("/list")
    public APIResult getTeacherClass(@RequestParam("teacherId") String teacherId) {
        int auth = getAuth();
        if (auth== Auth.TEACHER || auth==Auth.ADMIN) {
            return asSuccess(classHistoryService.getClassHistoryByTeacherId(teacherId));
        }
        return handleNoAuth(auth);
    }
}
