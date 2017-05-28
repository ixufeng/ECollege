package com.xf.college.service.lab.impl;

import com.xf.college.common.CommonResult;
import com.xf.college.dao.laboratory.LabRoomApplyDao;
import com.xf.college.model.laboratory.LabApply;
import com.xf.college.service.lab.LabApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by xufeng on 2017/5/7.
 */
@Service
public class LabApplyServiceImpl implements LabApplyService{
    @Autowired
    private LabRoomApplyDao labRoomApplyDao;


    @Override
    public String labApointment(LabApply labApply) {

        if (labApply == null || labApply.getLabId() == null || labApply.getClassValue().length == 0) {
            System.out.println(labApply.getClassValue());
            return CommonResult.IMCOMPLETE_MESSAGE;
        }
        if (labApply.getCurrentDay() == null || labApply.getCurrentDay().length()!=10) {
            return  CommonResult.IMCOMPLETE_MESSAGE;
        }
        int result = labRoomApplyDao.add(labApply);
        if ( result > 0 ) {
            return CommonResult.SUCCESS;
        }
        return CommonResult.ERROR;
    }

    @Override
    public List<LabApply> getLabApply(String userId, int state) {
        if (Objects.equals(userId,null) || userId.trim().equals("")) {
            return Collections.emptyList();
        }
        List<LabApply> list = labRoomApplyDao.selectByUserId(userId);
        if (list == null) {
            return Collections.emptyList();
        }
        if (state == -1) {
            return list;
        }
        return list.stream().filter(item-> item.getState() == state).collect(Collectors.toList());
    }

    /**
     * @return
     */
    @Override
    public List<LabApply> selectAll() {
        List<LabApply> list = labRoomApplyDao.selectAll();
        return list.stream().filter(item->item.getState()!=-1).collect(Collectors.toList());
    }

    @Override
    public String checkLabApply(int labApplyId) {
        return null;
    }
}
