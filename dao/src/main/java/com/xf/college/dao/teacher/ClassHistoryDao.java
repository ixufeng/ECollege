package com.xf.college.dao.teacher;

import com.xf.college.dao.BaseDao;
import com.xf.college.model.teacher.ClassHistory;

import java.util.List;

/**
 * Created by xufeng on 2017/4/9.
 */
public interface ClassHistoryDao extends BaseDao<ClassHistory,Integer> {
    List<ClassHistory> selectByTeacherId(String teacherId);
}
