package com.xf.college.service.lab;

import com.xf.college.model.laboratory.LabApply;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xufeng on 2017/5/1.
 * for bo
 */
public class LabStateBo {

    private String labId;
    private Map<Long, List<LabApply>> applyMap = new HashMap<>();


    public void addApply(LabApply labApply) {
        if (labApply!=null) {
            Date date = labApply.getBeginTime();

        }
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

}
