package com.xf.college.api.controller;

import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.AuthResult;
import com.xf.college.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by xufeng on 2017/4/15.
 */
@RestController
@RequestMapping
public class AuthController extends BaseController{

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public APIResult login(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password,
            @RequestParam(value = "redirect",required = false) String redirect,
            HttpSession session) {
        AuthResult result = authService.auth(userName,password);
        result.setRedirect(redirect);

        if (result.isLogin()) {
            session.setAttribute("user",result.getUser());
            return asSuccess(result);
        }else {
            return asUnLogin(result.getMessage());
        }
    }
    public APIResult<String> unLogin(
            @RequestParam("redirect") String redirect
    ) {

        return asSuccess(redirect);
    }
}
