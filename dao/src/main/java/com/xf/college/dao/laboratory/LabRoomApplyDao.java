package com.xf.college.dao.laboratory;

import com.xf.college.dao.BaseDao;
import com.xf.college.model.laboratory.LabRoom;

import java.util.List;

/**
 * Created by xufeng on 2017/4/29.
 */
public interface LabRoomApplyDao extends BaseDao<LabRoom,Integer> {

    List<LabRoom> selectByUserId();
}
