package com.xf.college.service;

import com.xf.college.common.utils.StringUtil;
import com.xf.college.model.teacher.Teacher;
import com.xf.college.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by xufeng on 2017/4/15.
 */
@Service
public class AuthService {

    /*@Value("${e_student_key_num}")*/
    private  int teacherKeyNum = 8;

   /* @Value("${e_student_key_num}")*/
    private   int studentKeyNum=10;


    @Autowired
    private TeacherService teacherService;

    /**
     * 验证老师或学生的登陆
     * @param key
     * @param password
     * @return
     */
    public AuthResult auth(String key,String password) {
        AuthResult result = new AuthResult();
        if (Objects.equals(key,null) || Objects.equals(password,null)) {
             result.setMessage("用户名或密码不能为空");
             return result;
        }
        if (!StringUtil.checkPassword(password)) {
            result.setMessage("用户名或密码不正确");
            return result;
        }

        if (Objects.equals(key.length(),teacherKeyNum)) {
               return checkTeacher(key,password,result);
        }
        if (Objects.equals(key.length(),studentKeyNum)) {
            return checkStudent(key,password,result);
        }
        return  result;
    }

    private AuthResult checkTeacher(String key,String password,AuthResult result) {

        Teacher teacher = teacherService.select(key);
        if (teacher==null) {
            result.setMessage("用户名不存在");
            return  result;
        }
        if (Objects.equals(teacher.getPassword(),password)) {
            result.setLogin(true);
            result.setMessage("登陆成功");
            result.setUser(teacher);
            return result;
        }
        return result;
    }

    private AuthResult checkStudent(String key,String password,AuthResult result) {
        return result;
    }






}
