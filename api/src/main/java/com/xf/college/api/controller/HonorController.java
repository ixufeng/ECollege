package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.honor.HonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufeng on 2017/4/18.
 */
@RequestMapping
@RestController
public class HonorController extends BaseController {

    @Autowired
    private HonorService honorService;

    /**
     * 管理员接口
     * @return
     */
    @RequestMapping(value = "/honorType/list")
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
        if (auth==Auth.TEACHER||auth==Auth.STUDENT||auth==Auth.ADMIN) {
            return asSuccess(honorService.getHonorsByUserId(userId));
        }
        return handleNoAuth(auth);
    }

}
