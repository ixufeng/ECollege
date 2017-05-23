package com.xf.college.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xufeng on 2017/5/10.
 */
public class CommonUtils {

    public static boolean checkMail(String mail) {
        if (mail == null || "".equals(mail)) {
            return  false;
        }
        Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
        Matcher m = p.matcher(mail);
        boolean b = m.matches();
        return b;
    }

    /**
     * 检查手机号码
     * @return
     */
    public static boolean checkPhone(String phone) {
       String reg = "^[1][3,4,5,8,7,6][0-9]{9}$";
       Pattern p = Pattern.compile(reg);
       Matcher m = p.matcher(phone);
       return m.matches();
    }
}
