package com.xf.college.common.mail;

/**
 * Created by xufeng on 2017/5/4.
 */
public class MailContext {
    public static final  String LAB_THEME = "江苏科技大学-电信学院实验室";
    public static final String DEFAULT_THEME = "江苏科技大学";


    private final String receivedUserMail; //接受人邮箱
    private final String theme;  //发送主题
    private String content;
    private String html;   //html 格式
    private String sendUserName;

    public MailContext (String mailAddr ,String theme) {
        this.receivedUserMail = mailAddr;
        this.theme = theme;
    }

    public String getReceivedUserMail() {
        return receivedUserMail;
    }

    public String getTheme() {
        return theme;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
