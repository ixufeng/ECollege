package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.dao.HonorDao;
import com.xf.college.model.Honor;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.honor.HonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by xufeng on 2017/4/18.
 */
@RequestMapping
@RestController
public class HonorController extends BaseController {

    @Autowired
    private HonorService honorService;

    @Autowired
    private HonorDao honorDao;

    /**
     * @return
     */
    @RequestMapping(value = "/honorType/list",method = RequestMethod.GET)
    public APIResult getHonorTypeList(){
        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {
            return asSuccess(honorService.getHonorTypeList());
        }
        return handleNoAuth(Auth.NO_AUTH);
    }


    @RequestMapping(value = "/honor/list",method = RequestMethod.GET)
    public APIResult getTeacherHonor(
            @RequestParam("userId") String userId
    ) {
        int auth = getAuth();
        if (Objects.equals(auth,Auth.TEACHER)||Objects.equals(auth,Auth.STUDENT)||Objects.equals(auth,Auth.ADMIN)) {
            return asSuccess(honorService.getHonorsByUserId(userId));
        }
        return handleNoAuth(auth);
    }
    @RequestMapping(value = "/honor/item")
    public APIResult getHonorListByIds(
            @RequestParam(value = "list[]") List<Integer> list
            ){
        return asSuccess(honorService.getHonorTypeItem(list));
    }

    @RequestMapping(value = "/honor/add",method = RequestMethod.POST)
    public APIResult addHonor(
            @RequestParam("honorType") int honorType,
            @RequestParam("achieveTime")Date achieveTime,
            @RequestParam("des") String des,
            @RequestParam("userId") String userId
            ) {
        int auth = getAuth();
        Honor honor = new Honor(honorType,des,achieveTime);
        honor.setTeacherId(userId);
        if (Objects.equals(auth,Auth.TEACHER)||Objects.equals(auth,Auth.STUDENT)||Objects.equals(auth,Auth.ADMIN)) {
            return asSuccess(honorService.addHonor(honor));
        }
        return  handleNoAuth(auth);
    }

    @RequestMapping(value = "/honor/delete",method = RequestMethod.POST)
    public APIResult deleteHonor(
            @RequestParam("id") int id
    ){
            int auth = getAuth();
            if (Auth.IS_LOGIN(auth)) {
                int result =  honorDao.delete(id);
                if (result > 0) {
                    return asSuccess("删除成功！");
                }
                return asError("删除失败");
            }
            return asUnLogin("请先登录");
    }

    @RequestMapping(value = "/honor/histogram",method = RequestMethod.GET)
    public APIResult getHonorGroup(
            @RequestParam("userId") String userId
    ) {
        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {
            return asSuccess(honorService.getHonorMap(userId));
        }
        return handleNoAuth(auth);
    }

}
