package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.common.CommonResult;
import com.xf.college.dao.laboratory.LabRoomApplyDao;
import com.xf.college.dao.laboratory.LabRoomDao;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.model.laboratory.LabApply;
import com.xf.college.model.laboratory.LabRoom;
import com.xf.college.service.lab.LabApplyService;
import com.xf.college.service.lab.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
    private LabRoomApplyDao labRoomApplyDao;

    @Autowired
    private LabService labService;

    @Autowired
    private LabApplyService labApplyService;

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
            String result = labApplyService.labApointment(labApply);
            if (Objects.equals(result, CommonResult.SUCCESS)) {
                return asSuccess(null);
            }
            return asError(result);
        }
        return asUnLogin("请先登录!");
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public APIResult addLab(
            @RequestParam("roomNumber") String roomNumber,
            @RequestParam("roomType") String roomType,
            @RequestParam("des") String des,
            @RequestParam("useCount") long useCount,
            @RequestParam("beginTime") Date beginTime
    ) {
        int auth = getAuth();
        LabRoom labRoom = new LabRoom(roomNumber,des,roomType,beginTime,useCount);
        int result = labRoomDao.add(labRoom);
        if (result > 0 ) {
            return asSuccess("添加成功");
        }
        return asError("该实验室已经存在");
    }
    @RequestMapping(value = "/mark",method = RequestMethod.POST)
    public APIResult markAs(
            @RequestParam("labId") String labId,
            @RequestParam("state") int state
    ) {
        LabRoom labRoom = labRoomDao.select(labId);
        if (labRoom == null) {
            return asError("参数错误");
        }
        labRoom.setValid(state);
        int result = labRoomDao.update(labRoom);
        if (result > 0) {
            return asSuccess(null);
        }
        return asError("更新失败");
    }
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public APIResult modifyLab(
            @RequestParam("roomNumber") String labId,
            @RequestParam("useCount") long useCount,
            @RequestParam("roomType") String labType,
            @RequestParam("des") String des
    ) {
            LabRoom labRoom = labRoomDao.select(labId);
            if (labRoom == null) {
                return asError("参数错误");
            }
            labRoom.setDes(des);
            labRoom.setUseCount(useCount);
            labRoom.setRoomType(labType);
            if (labRoomDao.update(labRoom) > 0) {
                return asSuccess(null);
            }
            return asError("修改失败");
    }

}
