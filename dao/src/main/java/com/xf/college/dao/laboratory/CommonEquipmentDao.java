package com.xf.college.dao.laboratory;

import com.xf.college.model.laboratory.CommonEquipment;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface CommonEquipmentDao {

    void add(CommonEquipment commonEquipment);
    void delete(String id);
    void update(CommonEquipment commonEquipment);
    CommonEquipment select(String id);
    List<CommonEquipment> selectAll();
    List<CommonEquipment> selectByName(String name);

}
