package com.xf.college.dao;

import com.xf.college.model.Honor;

import java.util.List;

/**
 * Created by xufeng on 2017/4/9.
 */
public interface HonorDao extends BaseDao<Honor,Integer>{

    List<Honor> getHonorListByUserId(String userId);
}
