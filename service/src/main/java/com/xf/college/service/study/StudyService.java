package com.xf.college.service.study;

import com.xf.college.model.teacher.TeacherStudy;

import java.util.List;
import java.util.Map;

/**
 * Created by xufeng on 2017/5/8.
 */
public interface  StudyService {

    /**
     * @param userId
     * @return
     * 将用户的科研按照类型分组
     */
    Map<String,List<TeacherStudy>> getStudyGroup(String userId);

    /**
     * @param teacherStudy
     * @return
     * 添加研究
     */
    int addStudy(TeacherStudy teacherStudy);

    public List<TeacherStudy> getStudentByUser(String userId);


}
