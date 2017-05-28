package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.dao.teacher.TeacherStudyDao;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.model.teacher.TeacherStudy;
import com.xf.college.service.study.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by xufeng on 2017/5/8.
 */
@RequestMapping("/study")
@RestController
public class StudyController extends BaseController{

    @Autowired
    private StudyService studyService;

    @Autowired
    private TeacherStudyDao teacherStudyDao;

    @RequestMapping("/list")
    public APIResult getUserStudy(
            @RequestParam("userId") String userId
    ) {
        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {
            return asSuccess(studyService.getStudentByUser(userId));
        }
        return handleNoAuth(auth);
    }
    @RequestMapping("/add")
    public APIResult addStudy(
            @RequestParam("userId") String userId,
            @RequestParam("studyName") String studyName,
            @RequestParam("intro") String intro,
            @RequestParam("studyType") String studyType,
            @RequestParam("beginTime") Date beginTime

    ) {
        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {
            TeacherStudy teacherStudy = new TeacherStudy();
            teacherStudy.setStudyName(studyName);
            teacherStudy.setTeacherId(userId);
            teacherStudy.setStudyIntro(intro);
            teacherStudy.setStudyType(studyType);
            teacherStudy.setBeginTime(beginTime);
            int result = teacherStudyDao.add(teacherStudy);
            if (result > 0) {
                return asSuccess("添加成功");
            }
        }
        return asUnLogin("请先登录");
    }

    @RequestMapping(value = "/delete1",method = RequestMethod.POST)
    public APIResult delelteStudy(
            @RequestParam("studyId") int studyId
    ) {
        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {
            int result = teacherStudyDao.delete(studyId);
            if (result > 0) {
                return asSuccess("删除成功");
            }
            return asError("删除失败");
        }else {
            return asUnLogin("请先登录");
        }
    }

    @RequestMapping("/histogram")
    public APIResult getStudyHistogram(@RequestParam("userId") String userId) {
        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {
            return asSuccess(studyService.getStudyGroup(userId));
        }
        return handleNoAuth(auth);
    }


}
