package com.xf.college.dao.laboratory;

import com.xf.college.dao.BaseDao;
import com.xf.college.model.AssetChange;

import java.util.List;

/**
 * Created by xufeng on 2017/4/29.
 */
public interface AssetChangeDao extends BaseDao<AssetChange,String>{

    List<AssetChange> selectByUserId(String userId);
}
