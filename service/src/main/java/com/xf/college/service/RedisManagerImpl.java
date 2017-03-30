package com.xf.college.service;

import com.xf.college.dao.teacher.TeacherDao;
import com.xf.college.model.student.Student;
import com.xf.college.model.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xufeng on 2017/3/27.
 */
public class RedisManagerImpl implements RedisManager {

    private Map<String,Teacher> teacherMap = new HashMap<>();
    private Map<String,Student> studentMap = new HashMap<>();

    @Autowired
    private TeacherDao teacherDao;

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public List<Teacher> getAllTeacherFromDB() {
        List<Teacher> list = teacherDao.selectAll();
        list.stream().forEach(teacher -> {
            if (teacher!=null) {
                teacherMap.put(teacher.getId(),teacher);
            }
        });
        return null;
    }

    @Override
    public List<Student> getAllStudentFromDB() {
        return null;
    }

    private void  freshMap() {

        executorService.scheduleAtFixedRate(()->getAllTeacherFromDB(),0L,300L, TimeUnit.SECONDS);

    }

    /**
     * 初始化入口
     */
    public void init() {
        freshMap();
    }
}
