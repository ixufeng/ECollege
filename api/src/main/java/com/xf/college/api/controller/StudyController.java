package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.study.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufeng on 2017/5/8.
 */
@RequestMapping("/study")
@RestController
public class StudyController extends BaseController{

    @Autowired
    private StudyService studyService;

    @RequestMapping("/list")
    public APIResult getUserStudy(
            @RequestParam("userId") String userId
    ) {
        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {

        }
        return handleNoAuth(auth);
    }
    @RequestMapping("/add")
    public APIResult addStudy(
            @RequestParam("userId") String userId

    ) {
        return null;
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
