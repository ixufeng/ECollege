package com.xf.college.service.lab;

import com.xf.college.model.laboratory.LabApply;

import java.util.List;

/**
 * Created by xufeng on 2017/5/7.
 */
public interface LabApplyService {

    /**
     *
     * @param labApply
     * @return
     */
    String labApointment(LabApply labApply);


    /**
     * 获取自己申请过的实验室
     * @param userId
     * @param state
     * @return
     */
    List<LabApply> getLabApply(String userId, int state);

    /**
     * 管理员审核申请 返回String 结果
     * @param labApplyId
     * @return
     */
    String checkLabApply(int labApplyId);


    List<LabApply> selectAll();


}
