package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.common.CommonResult;
import com.xf.college.dao.laboratory.LabRoomDao;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.model.laboratory.LabApply;
import com.xf.college.service.lab.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by xufeng on 2017/5/1.
 */
@RestController
@RequestMapping("/lab")
public class LabController extends BaseController{

    @Autowired
    private LabRoomDao labRoomDao;

    @Autowired
    private LabService labService;

    /**
     * 共有接口
     * @return
     */
    @RequestMapping("/list")
    public APIResult getAllLabRoom(
            @RequestParam("typeName") String typeName
    ) {
        return asSuccess(labRoomDao.selectByName(typeName));
    }


    /**
     * 共有接口
     * @return
     */
    @RequestMapping("/all")
    public APIResult getAllLabRoom() {
        return asSuccess(labRoomDao.selectAll());
    }

    @RequestMapping("/group_type")
    public APIResult getLabGroupByType() {
        return asSuccess(labService.groupByName());
    }

    @RequestMapping("/group_chart")
    public APIResult getLabGroupChartsByType() {
        return asSuccess(labService.extractPieCharts());
    }

    @RequestMapping("/apply/list")
    public APIResult getLabApplyState(
            @RequestParam("labType") String type
    ) {
        return asSuccess(labService.getLabStateOneWeek(type));
    }

    @RequestMapping("/apply")
    public APIResult applyLab(
            @RequestParam("userId") String userId,
            @RequestParam("classes") String classes,
            @RequestParam("labId") String labId,
            @RequestParam("dayTime") String dayTime,
            @RequestParam("labType") String labType
    ) {
        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {
            LabApply  labApply = new LabApply(labId,labType,userId,dayTime,classes);
            String result = labService.labApointment(labApply);
            if (Objects.equals(result, CommonResult.SUCCESS)) {
                return asSuccess(null);
            }
            return asError(result);
        }
        return asUnLogin("请先登录!");
    }
}
