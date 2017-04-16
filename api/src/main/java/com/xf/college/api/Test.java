package com.xf.college.api;

import com.xf.college.dao.Demo.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xufeng on 2017/3/7.
 */
public class Test {
    @Autowired
    private DemoDao demoDao;




   public void init() {
       System.out.println("初始化！！");
        // Demo demo = new Demo("testts");
       //demoDao.add(demo);
       System.out.println(0);
   }
}
