package com.xf.college.api.controller;

import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.service.assets.AssetService;
import com.xf.college.service.assets.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
