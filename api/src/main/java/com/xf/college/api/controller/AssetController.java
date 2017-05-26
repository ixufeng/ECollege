package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.dao.laboratory.AssetApplyDao;
import com.xf.college.dao.laboratory.AssetChangeDao;
import com.xf.college.dao.laboratory.AssetDao;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.model.laboratory.Asset;
import com.xf.college.model.laboratory.AssetApply;
import com.xf.college.service.assets.AssetService;
import com.xf.college.service.assets.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @Autowired
    private AssetApplyDao assetApplyDao;


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

    /**
     * 返回系统所有的资产申请
     * @return
     */
    @RequestMapping("/apply/all")
    public APIResult getAllAssetApply() {
        int auth = getAuth();
       /* if (Auth.ADMIN == auth) {
            return asSuccess(assetApplyDao.selectAll());
        }*/
        return asSuccess(assetApplyDao.selectAll());
    }

    /**
     * 申请新的资产
     * @param userId
     * @param des
     * @param assetName
     * @return
     */
    @RequestMapping(value = "/apply_asset")
    public APIResult addAssetApply(
            @RequestParam("userId") String userId,
            @RequestParam("des") String des,
            @RequestParam("assetName") String assetName
    ) {
        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {
            AssetApply assetApply = new AssetApply(userId,assetName,des);
            int result = assetApplyDao.add(assetApply);
            if (result > 0) {
                return asSuccess("申请成功");
            }
            return asError("申请失败");
        }
        return asUnLogin("请先登录");
    }

    /**
     * 管理员接口
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public APIResult addNewAsset(
            @RequestParam("name") String name,
            @RequestParam("model") String model,
            @RequestParam("type") String type,
            @RequestParam("id") String id,
            @RequestParam("des") String des,
            @RequestParam("factoryName") String factoryName,
            @RequestParam("buyTime") Date buyTime,
            @RequestParam("nation") String nation,
            @RequestParam("price") double price

    ) {
        Asset asset = new Asset(id,name,model,type,des,factoryName,buyTime,nation,price);
        int result = assetService.add(asset);
        if (result > 0 ) {
            return asSuccess("添加成功");
        }
        return asError("添加失败");
    }
}
