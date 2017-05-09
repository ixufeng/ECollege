package com.xf.college.dao.teacher;

import com.xf.college.dao.BaseDao;
import com.xf.college.model.teacher.TeacherStudy;

import java.util.List;

/**
 * Created by xufeng on 2017/4/9.
 */
public interface TeacherStudyDao extends BaseDao<TeacherStudy,Integer> {

    List<TeacherStudy> selectByUserId(String userId);
}
