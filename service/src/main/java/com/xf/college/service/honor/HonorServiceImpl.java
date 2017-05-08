package com.xf.college.service.honor;

import com.xf.college.dao.HonorDao;
import com.xf.college.dao.HonorTypeDao;
import com.xf.college.model.Honor;
import com.xf.college.model.HonorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        if (Objects.equals(id,null)||Objects.equals(id.trim(),"")) {
            return Collections.emptyList();
        }
        return honorDao.getHonorListByUserId(id);
    }

    @Override
    public List<HonorType> getHonorTypeList() {
        return honorTypeDao.selectAll();
    }

    @Override
    public List<HonorType> getHonorTypeItem(List<Integer> list) {
        if (list==null || list.size()==0) {
            return Collections.emptyList();
        }
        List<HonorType> items = new ArrayList<>();
        if (list.size()==1) {
            items.add(honorTypeDao.select(list.get(0)));
            return items;
        }
        items = honorTypeDao.selectAll();
        return  items.stream().filter(item->list.contains(item.getId())).collect(Collectors.toList());
    }

    @Override
    public int addHonor(Honor honor) {

        if (Objects.equals(honor,null) || honor.getTeacherId()==null) {
            return 0;
        }
        if (honor.getHonorType() <= 0 ) {
            return 0;
        }
        return honorDao.add(honor);
    }

    /**
     * 按照类型获取教师的获奖
     * @param userId
     * @return
     */
    @Override
    public Map<String, List<Honor>> getHonorMap(String userId) {
        Map<String,List<Honor>> map = new HashMap<>();
        List<Honor> list = honorDao.selectAll();
        list.forEach((Honor item) -> {
            String key = HonorType.getTypeName(item.getHonorType());
            List li = map.get(key);
            if (li == null) li = new ArrayList();
            li.add(item);
            map.put(key,li);
        });
        return map;
    }
}
