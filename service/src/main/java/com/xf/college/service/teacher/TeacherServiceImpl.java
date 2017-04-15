package com.xf.college.service.teacher;

import com.xf.college.dao.teacher.TeacherDao;
import com.xf.college.model.teacher.Teacher;
import com.xf.college.service.RedisManager;
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
