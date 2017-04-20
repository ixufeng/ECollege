package com.xf.college.service.honor;

import com.xf.college.model.Honor;
import com.xf.college.model.HonorType;

import java.util.List;

/**
 * Created by xufeng on 2017/4/20.
 */
public interface HonorService {
    List<Honor>getHonorList();
    Honor getHonorById(String id);
    Honor getHonorByName(String name);
    List<Honor> getHonorsByUserId(String id);
    List<HonorType> getHonorTypeList();
}
