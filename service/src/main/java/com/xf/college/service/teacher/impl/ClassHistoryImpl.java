package com.xf.college.service.teacher.impl;

import com.xf.college.common.CommonResult;
import com.xf.college.dao.teacher.ClassHistoryDao;
import com.xf.college.model.teacher.ClassHistory;
import com.xf.college.service.teacher.ClassHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by xufeng on 2017/4/23.
 */
@Service
public class ClassHistoryImpl implements ClassHistoryService {

    @Autowired
    private ClassHistoryDao classHistoryDao;

    @Override
    public List<ClassHistory> getClassHistoryByTeacherId(String teacherId) {
        if (Objects.equals(teacherId,null)) {
            return Collections.emptyList();
        }
        return classHistoryDao.selectByTeacherId(teacherId);
    }

    @Override
    public String addClassHistory(ClassHistory classHistory) {
        if (classHistory==null || classHistory.getTeacherId()==null || classHistory.getCourseId() == null ||
                classHistory.getBeginTime()==null || classHistory.getEndTime()==null) {
            return "请补全信息!";
        }
        if (classHistory.getBeginTime().getTime() >= classHistory.getEndTime().getTime()) {
            return "时间范围不合法!";
        }
        int num = classHistoryDao.add(classHistory);
        if (num>0) {
            return CommonResult.SUCCESS;
        } else {
            return CommonResult.INSERT_ERROR;
        }
    }

    /**
     * 按照年份分类
     * @param teacherId
     * @return
     */
    @Override
    public Map<String, List<ClassHistory>> sortClassByTime(String teacherId) {
        List<ClassHistory> list = getClassHistoryByTeacherId(teacherId);
        if (Objects.equals(list,null) || list.size()==0) {
            return null;
        }
        Map<String,List<ClassHistory>> map = new HashMap();
        list.stream().forEach(item->{
            String key = item.getBeginTime().getYear() + "";
            List<ClassHistory> tempList = map.get(key);
            if (Objects.equals(tempList,null)) {
                List<ClassHistory> li = new ArrayList<>();
                li.add(item);
                map.put(key,li);
            } else {
                tempList.add(item);
            }
        });
        return map;
    }

    /**
     * 按照课程类别
     * @param teacherId
     * @return
     */
    @Override
    public Map<ClassHistory, List<Date>> sortClassByType(String teacherId) {
        List<ClassHistory> list = getClassHistoryByTeacherId(teacherId);
        if (Objects.equals(list,null) || list.size()==0) {
            return null;
        }
        Map<ClassHistory,List<Date>> map = new HashMap<>();
        list.stream().forEach(item-> {
            List<Date> li = map.get(item);
            if (Objects.equals(li,null)) {
                List<Date> list1 = new ArrayList<>();
                list1.add(item.getBeginTime());
                map.put(item,list1);
            }else {
                li.add(item.getBeginTime());
            }
        });
        return map;
    }
}
