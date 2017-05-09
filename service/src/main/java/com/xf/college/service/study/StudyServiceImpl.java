package com.xf.college.service.study;

import com.xf.college.dao.teacher.TeacherStudyDao;
import com.xf.college.model.teacher.TeacherStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by xufeng on 2017/5/8.
 */
@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    private TeacherStudyDao teacherStudyDao;

    @Override
    public Map<String, List<TeacherStudy>> getStudyGroup(String userId) {
        Map<String,List<TeacherStudy>> map = new HashMap<>();
        if (Objects.equals(userId,null) || "".equals(userId.trim())) {
            return map;
        }
        List<TeacherStudy> list = teacherStudyDao.selectByUserId(userId);
        if (list == null) { return map; }
        list.forEach((TeacherStudy teacherStudy)-> {
            String key = teacherStudy.getStudyType();
            List<TeacherStudy> li = map.get(key);
            if (li == null) li = new ArrayList<TeacherStudy>();
            li.add(teacherStudy);
            map.put(key,li);
        });
        return map;
    }

    @Override
    public int addStudy(TeacherStudy teacherStudy) {
        if (teacherStudy != null) {
            return teacherStudyDao.add(teacherStudy);
        }

        return 0;
    }
}
