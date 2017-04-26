package com.xf.college.service.charts;

import com.xf.college.dao.teacher.ClassHistoryDao;
import com.xf.college.model.teacher.ClassHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by xufeng on 2017/4/26.
 */
@Service
public class ChartsServiceImpl implements ChartsService {

    @Autowired
    private ClassHistoryDao classHistoryDao;
    @Override
    public Map<Integer, List> getClassHistoryHistogram(Range range, String userId) {
        List<ClassHistory> list = classHistoryDao.selectByTeacherId(userId);
        Map<Integer,List> map = new HashMap<>();
        if (list == null) {
            return map;
        }
        for (ClassHistory classHistory:list) {
            if ( range.isInYearRange(classHistory.getBeginTime())) {
                int year = classHistory.getBeginTime().getYear();
                List<ClassHistory> li = map.get(year);
                if (li==null) {
                    List<ClassHistory> l = new ArrayList();
                    l.add(classHistory);
                    map.put(year,l);
                }else {
                    li.add(classHistory);
                    map.put(year,li);
                }
            }
         }
        return map;
    }

    @Override
    public Map<Date, List> getStudyHistogram(Range range, String userId) {
        return null;
    }
}
