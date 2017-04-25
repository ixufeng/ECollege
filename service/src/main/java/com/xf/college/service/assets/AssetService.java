package com.xf.college.service.assets;

import com.xf.college.model.laboratory.Asset;

import java.util.List;

/**
 * Created by xufeng on 2017/4/25.
 */
public interface AssetService {
    List<Asset> selectAll();
    int update(Asset asset);
    int add(Asset asset);
    /**
     * 查询用户的所有在使用的设备
     * @param userId
     * @return
     */
    List<Asset> selectByUserId(String userId);
}
