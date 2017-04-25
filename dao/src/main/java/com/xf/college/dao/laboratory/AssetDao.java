package com.xf.college.dao.laboratory;

import com.xf.college.dao.BaseDao;
import com.xf.college.model.laboratory.Asset;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface AssetDao extends BaseDao<AssetDao,String>{
    /**
     * 查询使用人的所有设备
     * @param userId
     * @return
     */
    List<Asset> selectByUserId(String userId);

}
