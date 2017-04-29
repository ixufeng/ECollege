package com.xf.college.service.assets.impl;

import com.xf.college.dao.laboratory.AssetChangeDao;
import com.xf.college.dao.laboratory.AssetDao;
import com.xf.college.model.AssetChange;
import com.xf.college.model.laboratory.Asset;
import com.xf.college.service.assets.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private AssetChangeDao assetChangeDao;

    @Override
    public List<Asset> selectAll() {
        List list = assetDao.selectAll();
        return list==null? Collections.emptyList():list;
    }

    /**
     * 返回回收成功资产的id
     * @param teacherId
     * @param list
     * @return
     */
    @Override
    public List<String> recycle(String teacherId,List<String> list) {
        List<String> resultList = new ArrayList<>();
        if (Objects.equals(teacherId,null) || list == null || list.size()==0) {
            return Collections.emptyList();
        }
        for (String id :list) {
            Asset asset = assetDao.select(id);
            if ( asset==null ) continue;
            AssetChange assetChange = new AssetChange(asset.getId(),asset.getName(),teacherId);
            assetChange.setDestUserId("0"); //库存
            int add = assetChangeDao.add(assetChange);
            if (add > 0) {
                resultList.add(asset.getId());
            }
        }
        return resultList;
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

    @Override
    public List<AssetChange> selectAllAssetChange() {
        return assetChangeDao.selectAll();
    }
}
