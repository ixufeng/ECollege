package com.xf.college.service.assets.impl;

import com.xf.college.dao.laboratory.LabRoomDao;
import com.xf.college.model.laboratory.LabRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xufeng on 2017/4/26.
 */
@Service
public class RoomService {
    @Autowired
    private LabRoomDao laboratoryRoomDao;

    /**
     *获取所有实验室
     * @return
     */
    public List<LabRoom> getAllRooms() {

        return laboratoryRoomDao.selectAll();
    }
}
