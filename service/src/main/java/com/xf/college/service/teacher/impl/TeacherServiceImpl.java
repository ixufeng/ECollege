package com.xf.college.service.teacher.impl;

import com.xf.college.common.CommonResult;
import com.xf.college.common.utils.CommonUtils;
import com.xf.college.dao.teacher.TeacherDao;
import com.xf.college.model.teacher.Teacher;
import com.xf.college.service.RedisManager;
import com.xf.college.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * Created by xufeng on 2017/4/15.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private RedisManager redisManager;

    @Override
    public String updateTeacher(Teacher teacher) {
        //name || mail
        if (teacher != null && teacher.getId() != null) {
            String userId = teacher.getId();
            Teacher oldTeacher = teacherDao.select(userId);
            if (oldTeacher == null) {
                return CommonResult.QUERY_ERROR;
            }
            if (teacher.getMail() != null && !"".equals(teacher.getMail())) {
                boolean b = CommonUtils.checkMail(teacher.getMail());
                if (!b) {
                    return "邮箱格式不合法";
                }
                oldTeacher.setMail(teacher.getMail());
            }
            if (teacher.getPhone() != null && !"".equals(teacher.getPhone())) {
                boolean b = CommonUtils.checkPhone(teacher.getPhone());
                if (!b) {
                    return "手机号码不合法";
                }
                oldTeacher.setPhone(teacher.getPhone());
            }
            int result = teacherDao.update(oldTeacher);
            if ( result > 0 ) {
                return CommonResult.SUCCESS;
            }
        }
        return CommonResult.INSERT_ERROR;
    }

    @Override
    public Teacher select(String teacherId) {
        if (Objects.equals(teacherId,null)||Objects.equals(teacherId.trim(),""))
            return null;
        Teacher teacher =  redisManager.getTeacher(teacherId);
        return  teacher==null?teacherDao.select(teacherId):null;
    }

    @Override
    public List<Teacher> selectAll() {
        return  teacherDao.selectAll();
    }

    @Override
    public List<Teacher> findByName(String name) {
        if (Objects.equals(name,null)) {
            return Collections.EMPTY_LIST;
        }
        return teacherDao.selectByName(name);
    }

}
