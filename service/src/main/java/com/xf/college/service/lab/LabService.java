package com.xf.college.service.lab;

import com.xf.college.model.laboratory.LabApply;
import com.xf.college.model.laboratory.LabRoom;

import java.util.List;
import java.util.Map;

/**
 * Created by xufeng on 2017/5/1.
 */
public interface LabService {

    /**
     *
     * @param labApply
     * @return
     */
    String labApointment(LabApply labApply);

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
