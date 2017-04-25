package com.xf.college.service.assets.impl;

import com.xf.college.dao.laboratory.AssetDao;
import com.xf.college.model.laboratory.Asset;
import com.xf.college.service.assets.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by xufeng on 2017/4/25.
 */
@Service
public class AssetServiceImpl implements AssetService{

    @Autowired
    private AssetDao assetDao;

    @Override
    public List<Asset> selectAll() {
        List list = assetDao.selectAll();
        return list==null? Collections.emptyList():list;
    }

    @Override
    public int update(Asset asset) {

        return 0;
    }

    @Override
    public int add(Asset asset) {
        return 0;
    }

    @Override
    public List<Asset> selectByUserId(String userId) {
        if (Objects.equals(userId,null) || userId.trim().equals("")) {
            return Collections.emptyList();
        }
        return assetDao.selectByUserId(userId);
    }
}
