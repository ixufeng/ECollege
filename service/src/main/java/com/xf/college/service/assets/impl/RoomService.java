package com.xf.college.service.assets.impl;

import com.xf.college.dao.laboratory.LaboratoryRoomDao;
import com.xf.college.model.laboratory.LaboratoryRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xufeng on 2017/4/26.
 */
@Service
public class RoomService {
    @Autowired
    private LaboratoryRoomDao laboratoryRoomDao;

    /**
     *获取所有实验室
     * @return
     */
    public List<LaboratoryRoom> getAllRooms() {

        return laboratoryRoomDao.selectAll();
    }
}
