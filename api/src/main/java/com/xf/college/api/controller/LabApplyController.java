package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.dao.laboratory.LabRoomApplyDao;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.model.laboratory.LabApply;
import com.xf.college.service.lab.LabApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufeng on 2017/5/7.
 */
@RestController
@RequestMapping("lab_apply")
public class LabApplyController extends BaseController {

    @Autowired
    private LabApplyService labApplyService;

    @Autowired
    private LabRoomApplyDao labRoomApplyDao;


    /**
     * 教师申请实验室列表
     * @param userId
     * @return
     */
    @RequestMapping("/list")
    public APIResult userLabApplied(
            @RequestParam("userId") String userId,
            @RequestParam(value = "state",required = false,defaultValue = "-1") int state
            ) {

        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {
            return  asSuccess(labApplyService.getLabApply(userId,state));
        }
        return handleNoAuth(auth);
    }

    /**
     * 管理员接口
     * @return
     */
    @RequestMapping("/all")
    public APIResult getAllLabApply () {
        int auth = getAuth();
      /*  if (auth != Auth.ADMIN) {
            return asUnAuthError("没有权限");
        }*/
        return asSuccess(labApplyService.selectAll());
    }

    /**
     * 管理员接口
     * @return
     */
    @RequestMapping("/handle")
    public APIResult checkLabApply(
            @RequestParam("labApplyId") int labApplyId,
            @RequestParam("state") int state,  //审核结果
            @RequestParam(value = "result",required = false) String result
    ) {
        LabApply labApply = labRoomApplyDao.select(labApplyId);
        if (labApply == null) {
            return asError("参数错误");
        }
        labApply.setState(state);
        if (state == 3) {
            labApply.setResult(result);
        }
        int f = labRoomApplyDao.update(labApply);
        if (f  > 0) {
            return asSuccess(null);
        }
        return asError("操作失败");
    }
}
