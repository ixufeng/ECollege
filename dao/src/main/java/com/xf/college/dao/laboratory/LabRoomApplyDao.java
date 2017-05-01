package com.xf.college.dao.laboratory;

import com.xf.college.dao.BaseDao;
import com.xf.college.model.laboratory.LabApply;

import java.util.List;

/**
 * Created by xufeng on 2017/4/29.
 */
public interface LabRoomApplyDao extends BaseDao<LabApply,Integer> {

    List<LabApply> selectByUserId(String userId);

    List<LabApply> selectByLabId(String labId);

    List<LabApply> selectByLabType(String labType);
}
