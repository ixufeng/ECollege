package com.xf.college.common.mail;

import com.sendcloud.sdk.builder.SendCloudBuilder;
import com.sendcloud.sdk.core.SendCloud;
import com.sendcloud.sdk.model.MailAddressReceiver;
import com.sendcloud.sdk.model.MailBody;
import com.sendcloud.sdk.model.SendCloudMail;
import com.sendcloud.sdk.model.TextContent;
import com.sendcloud.sdk.util.ResponseData;

/**
 * Created by xufeng on 2017/5/4.
 */
public class CloudMail implements Mail {

    private static CloudMail mail = new CloudMail();


    private CloudMail() {

    }

    public static  CloudMail getInstance(){
        return mail;
    }



    @Override
    public boolean send(MailContext mailContext) {
        MailAddressReceiver receiver = new MailAddressReceiver();
        receiver.addTo(mailContext.getReceivedUserMail());  //添加接收人
        // 添加抄送
        //receiver.addCc("JobComing@qq.com");
        // 添加密送
        //receiver.addBcc("1054993687@qq.com");

        MailBody body = new MailBody();
        // 设置 From
        body.setFrom("ECollege@e.college.com");
        // 设置 FromName
        body.setFromName("ECollege");
        // 设置 ReplyTo
        body.setReplyTo("18151587180@163.com");
        // 设置标题
        body.setSubject(mailContext.getTheme());
        // 创建文件附件
        //body.addAttachments(new File("D:/1.png"));
        //body.addAttachments(new File("D:/2.png"));
        //// 创建流附件
        // body.addAttachments(new FileInputStream(new File("D:/ff.png")));

        TextContent content = new TextContent();
        content.setContent_type(TextContent.ScContentType.html);
        content.setText(mailContext.getHtml());

        SendCloudMail mail = new SendCloudMail();
        mail.setTo(receiver);
        mail.setBody(body);
        mail.setContent(content);

        SendCloud sc = SendCloudBuilder.build();

        ResponseData res = null;
        try {
            res = sc.sendMail(mail);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if(res.getResult()){
            System.out.printf("发送成功");
            return true;
        }
        System.out.println("发送失败");
        return false;
    }

    public static void main(String[] args) {
        MailContext mailContext = new MailContext("862363337@qq.com","江苏科技大学 电信学院实验室");
        mailContext.setContent("你好，我们是江苏科技大学张家港校区");
        mailContext.setHtml("<h1>hello world<h1>");
        CloudMail.getInstance().send(mailContext);
    }
}
