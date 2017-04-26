package com.xf.college.service.charts;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xufeng on 2017/4/26.
 */
public interface ChartsService {

    Map<Integer,List> getClassHistoryHistogram(Range range,String userId);
    Map<Date,List> getStudyHistogram(Range range,String userId);
}
