package com.xf.college.api.controller;

import com.xf.college.dao.laboratory.AssetApplyDao;
import com.xf.college.dao.laboratory.AssetDao;
import com.xf.college.dao.teacher.TeacherDao;
import com.xf.college.model.apiwrapper.APIResult;
import com.xf.college.model.laboratory.Asset;
import com.xf.college.model.laboratory.AssetApply;
import com.xf.college.model.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by xufeng on 2017/5/26.
 */
@RestController
@RequestMapping("/asset_apply")
public class AssetApplyController extends BaseController {
    @Autowired
    private AssetApplyDao assetApplyDao;

    @Autowired
    private AssetDao assetDao;

    @Autowired
    TeacherDao teacherDao;

    @RequestMapping("/refuse")
    public APIResult refuseApply(
            @RequestParam("id") int id,
            @RequestParam("result") String result
    ) {
        if (Objects.equals(result,null) || result.trim().equals("")) {
            return asError("请填写驳回理由");
        }
        if (id < 0) {
            asError("参数错误");
        }
        AssetApply assetApply = assetApplyDao.select(id);
        if (assetApply == null) {
            return asError("参数错误");
        }
        assetApply.setResult(result);
        assetApply.setState(2);
        int num = assetApplyDao.update(assetApply);
        if (num > 0) {
            return asSuccess(null);
        }
        return asError("更新失败");
     }

     @RequestMapping("/allocation")
     public APIResult allocation(
             @RequestParam("assetId") String assetId,
             @RequestParam("userId") String userId
     ) {
        if (Objects.equals(assetId,null) || Objects.equals(userId,null)) {
            return asError("参数错误");
        }
         Asset asset = assetDao.select(assetId);
         if (asset == null ) {
             return asError("参数错误");
         }
         Teacher teacher = teacherDao.select(userId);
         if (teacher == null) {
             return asError("分配的用户不存在");
         }
         asset.setUsedCount(asset.getUsedCount() + 1);
         asset.setUserId(userId);
         int result = assetDao.update(asset);
         if (result > 0) {
             return asSuccess(null);
         }
         return asError("删除失败");
     }
}
