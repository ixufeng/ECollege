package com.xf.college.service.lab;

import com.xf.college.model.laboratory.LabRoom;
import com.xf.college.service.charts.Range;

import java.util.List;
import java.util.Map;

/**
 * Created by xufeng on 2017/5/1.
 */
public interface LabService {

    /**
     * 实验室预约
     * @param userId
     * @param labId
     * @param range
     * @return
     */
    int LabApointment(String userId, String labId, Range range);

    /**
     * 按照实验室类别分类
     * @return
     */
    Map<String,List<LabRoom>> groupByName();

    /**
     * for lab pie charts
     * @return
     */
     Map<String,LabTypeGroup> extractPieCharts();

     Map<String,LabStateBo> getLabStateOneWeek(String labType);
}
