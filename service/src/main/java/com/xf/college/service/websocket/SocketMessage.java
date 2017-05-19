package com.xf.college.service.websocket;

import java.util.Date;

/**
 * socket 消息实体
 * Created by xufeng on 2017/5/18.
 */
public class SocketMessage {

    private String fromUserId;
    private String toUserId;
    private String msg;
    private Date date;


    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
