package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.model.Honor;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.honor.HonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 管理员接口,获取全部类型
     * @return
     */
    @RequestMapping(value = "/honorType/list",method = RequestMethod.GET)
    public APIResult getHonorTypeList(){
        int auth = getAuth();
        if (auth != 0) {
           return handleNoAuth(Auth.NO_AUTH);
        }
        return asSuccess(honorService.getHonorTypeList());
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

    @RequestMapping(value = "/honor/add",method = RequestMethod.PUT)
    public APIResult addHonor(@RequestParam("honor")Honor honor) {
        int auth = getAuth();
        if (Objects.equals(auth,Auth.TEACHER)||Objects.equals(auth,Auth.STUDENT)||Objects.equals(auth,Auth.ADMIN)) {
            return asSuccess(honorService.addHonor(honor));
        }
        return  handleNoAuth(auth);
    }

}
