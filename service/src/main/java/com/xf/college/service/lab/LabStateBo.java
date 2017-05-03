package com.xf.college.service.lab;

import com.xf.college.model.laboratory.LabApply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xufeng on 2017/5/1.
 * for bo
 */
public class LabStateBo {

    private String labId;
    private Map<String, List<LabApply>> applyMap = new HashMap<>();


    public void addApply(LabApply labApply) {
        if (labApply!=null) {
            String key = labApply.getCurrentDay();  //get current day
            List<LabApply> list = this.applyMap.get(key);
            if (list==null) {
                list = new ArrayList<>();
            }
            list.add(labApply);
            applyMap.put(key,list);
        }
    }


    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public Map<String, List<LabApply>> getApplyMap() {
        return applyMap;
    }

    public void setApplyMap(Map<String, List<LabApply>> applyMap) {
        this.applyMap = applyMap;
    }
}
