package com.xf.college.service.lab.impl;

import com.xf.college.dao.laboratory.LabRoomApplyDao;
import com.xf.college.dao.laboratory.LabRoomDao;
import com.xf.college.model.laboratory.LabApply;
import com.xf.college.model.laboratory.LabRoom;
import com.xf.college.service.lab.LabService;
import com.xf.college.service.lab.LabStateBo;
import com.xf.college.service.lab.LabTypeGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xufeng on 2017/5/1.
 */
@Service
public class LabServiceImpl implements LabService {
    @Autowired
    private LabRoomDao labRoomDao;

    @Autowired
    private LabRoomApplyDao labRoomApplyDao;


    @Override
    public Map<String, List<LabRoom>> groupByName() {
        Map<String,List<LabRoom>> labRoomMap = new HashMap<>();
        List<LabRoom> labRoomList = labRoomDao.selectAll();
        if (labRoomList==null) {
            return null;
        }
        labRoomList.forEach((LabRoom labRoom)-> {
            String key = labRoom.getRoomType();
            List list = labRoomMap.get(key);
            if (list == null) {
                list = new ArrayList();
            }
            list.add(labRoom);
            labRoomMap.put(key,list);
        });

        return labRoomMap;
    }

    @Override
    public Map<String,LabTypeGroup> extractPieCharts() {
       Map<String,List<LabRoom>> map = groupByName();
       if (map==null) {
           return null;
       }
       Map<String,LabTypeGroup> resultMap = new HashMap<>(3);
       for (Map.Entry<String,List<LabRoom>> entry : map.entrySet()) {
           LabTypeGroup labTypeGroup = new LabTypeGroup();
           entry.getValue().forEach(labRoom-> {
               labTypeGroup.addUseCount(labRoom.getUseCount());
           });
           labTypeGroup.setNumber(entry.getValue().size());
           String key = entry.getKey();
           resultMap.put(key,labTypeGroup);
       }
       return resultMap;
    }

    @Override
    public Map<String,LabStateBo> getLabStateOneWeek(String labType) {

        Map<String,LabStateBo> map = new HashMap<>();

        List<LabApply> labApplyList = labRoomApplyDao.selectByLabType(labType);
        if (labApplyList==null) {
            return  map;
        }
        labApplyList.forEach(labApply -> {
            String key = labApply.getLabId();
            LabStateBo labStateBo = map.get(key);
            if (labStateBo == null) {
                labStateBo = new LabStateBo();
            }
            labStateBo.setLabId(key);
            labStateBo.addApply(labApply);
            map.put(key,labStateBo);
        });
        return map;
    }
}
