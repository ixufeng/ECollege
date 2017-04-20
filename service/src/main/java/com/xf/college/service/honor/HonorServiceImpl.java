package com.xf.college.service.honor;

import com.xf.college.dao.HonorDao;
import com.xf.college.dao.HonorTypeDao;
import com.xf.college.model.Honor;
import com.xf.college.model.HonorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xufeng on 2017/4/20.
 */
@Service
public class HonorServiceImpl implements HonorService {

    @Autowired
    private HonorTypeDao honorTypeDao;
    @Autowired
    private HonorDao honorDao;
    @Override
    public List<Honor> getHonorList() {
        return honorDao.selectAll();
    }

    @Override
    public Honor getHonorById(String id) {
        return null;
    }

    @Override
    public Honor getHonorByName(String name) {
        return null;
    }

    @Override
    public List<Honor> getHonorsByUserId(String id) {
        return null;
    }

    @Override
    public List<HonorType> getHonorTypeList() {
        return honorTypeDao.selectAll();
    }
}
