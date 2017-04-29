package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.dao.laboratory.AssetChangeDao;
import com.xf.college.dao.laboratory.AssetDao;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.model.laboratory.Asset;
import com.xf.college.service.assets.AssetService;
import com.xf.college.service.assets.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * Created by xufeng on 2017/4/25.
 */
@RequestMapping("/asset")
@RestController
public class AssetController extends BaseController{

    @Autowired
    private AssetService assetService;
    @Autowired
    private RoomService roomService;

    @Autowired
    private AssetChangeDao assetChangeDao;


    @Autowired
    private AssetDao assetDao;
    /**
     * 获取所有资产接口 对管理员可见
     * @return
     */
    @RequestMapping("/all")
    public APIResult getAllAssets() {
        int auth = getAuth();
       /* if (auth != Auth.ADMIN) {
            return asUnAuthError("仅管理员可见！");
        }*/
        return asSuccess(assetService.selectAll());
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public APIResult getUserAsset(
            @RequestParam("userId") String userId
    ) {
        int auth = getAuth();

        return asSuccess(assetService.selectByUserId(userId));
    }

    @RequestMapping("/room/all")
    public APIResult getAllRooms() {
        return asSuccess(roomService.getAllRooms());
    }

    @RequestMapping(value = "/recycle",method = RequestMethod.POST)
    public APIResult recycleAsset(
            @RequestParam("teacherId") String teacherId,
            @RequestParam(value = "list[]") List<String> list
    ) {
        List<String> result = assetService.recycle(teacherId,list);
        return  asSuccess(result);
    }

    @RequestMapping("/name")
    public List<Asset> getAsset(
            @RequestParam("id") String name
    ) {
        return assetDao.selectByName(name);
    }

    /**
     * 管理员接口
     * @return
     */
    public APIResult getAssetChange() {
        int auth = getAuth();
        if (!Objects.equals(auth, Auth.ADMIN)) {
            return asUnAuthError("没有权限！");
        }
        return asSuccess(assetService.selectAllAssetChange());
    }
    @RequestMapping("/apply")
    public APIResult getAssetChangeByUserId(
            @RequestParam("userId") String userId
    ) {
        int auth = getAuth();
        return asSuccess(assetChangeDao.selectByUserId(userId));
    }
}
