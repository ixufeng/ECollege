package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.common.CommonResult;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.model.teacher.ClassHistory;
import com.xf.college.service.charts.ChartsService;
import com.xf.college.service.charts.Range;
import com.xf.college.service.teacher.ClassHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by xufeng on 2017/4/23.
 */
@RequestMapping("/course")
@RestController
public class ClassHistoryController extends BaseController {

    @Autowired
    private ClassHistoryService classHistoryService;

    @Autowired
    private ChartsService chartsService;

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
           @RequestParam("beginTime") LocalDate beginTime,
           @RequestParam("endTime") LocalDate endTime,
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
    @RequestMapping("/histogram")
    public APIResult getHistogram(
            @RequestParam("teacherId") String teacherId,
            @RequestParam(value = "from",required = false) Long from,
            @RequestParam(value = "to" ,required = false) Long to
    ) {
        if (Objects.equals(from,null) || Objects.equals(to,null)) {
            return asSuccess(chartsService.getClassHistoryHistogram(new Range(),teacherId));
        }
        return asSuccess(chartsService.getClassHistoryHistogram(new Range(from,to),teacherId));
    }
}
