package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.common.CommonResult;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.model.teacher.ClassHistory;
import com.xf.college.service.teacher.ClassHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

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
    @RequestMapping("/history/add")
    public APIResult addTeacherClass(
           @RequestParam("courseId") String courseId,
           @RequestParam("teacherId") String teacherId,
           @RequestParam("beginTime") Date beginTime,
           @RequestParam("endTime") Date endTime,
           @RequestParam("majorId") String majorId
            ) {
        int auth = getAuth();
        if (auth==Auth.TEACHER || auth == Auth.ADMIN) {
            ClassHistory classHistory = new ClassHistory(teacherId,courseId,majorId,beginTime,endTime);
            String res = classHistoryService.addClassHistory(classHistory);
            if (Objects.equals(res, CommonResult.SUCCESS)) {
                return asSuccess("添加成功！");
            } else {
                return asError(res);
            }
        } else {
            return handleNoAuth(auth);
        }
    }
}
