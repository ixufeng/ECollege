package com.xf.college.service.teacher;

import com.xf.college.model.teacher.ClassHistory;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xufeng on 2017/4/23.
 */
public interface ClassHistoryService {

    List<ClassHistory> getClassHistoryByTeacherId();

    Map<String,List<ClassHistory>> sortClassByTime();

    Map<ClassHistory,List<Date>> sortClassByType();

}
