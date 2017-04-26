package com.xf.college.service.teacher;

import com.xf.college.model.teacher.ClassHistory;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by xufeng on 2017/4/23.
 */
public interface ClassHistoryService {

    List<ClassHistory> getClassHistoryByTeacherId(String teacherId);

    Map<String,List<ClassHistory>> sortClassByTime(String teacherId);

    Map<ClassHistory,List<LocalDate>> sortClassByType(String teacherId);

    String addClassHistory(ClassHistory classHistory);

}
