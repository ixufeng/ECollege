package com.xf.college.dao.laboratory;

import com.xf.college.dao.BaseDao;
import com.xf.college.model.laboratory.AssetApply;

import java.util.List;

/**
 * Created by xufeng on 2017/5/23.
 */
public interface AssetApplyDao extends BaseDao<AssetApply,Integer> {

    List<AssetApply> selectByUserId(String userId);
}
