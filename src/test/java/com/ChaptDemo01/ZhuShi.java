package com.ChaptDemo01;

import org.testng.annotations.*;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
public class ZhuShi {
    @BeforeTest
    public void beforTest(){
        System.out.println("测试beforTest注解");
    }

    @BeforeMethod
    public void beformethod(){
        System.out.println("测试beformethod注解");
    }
    @Test
    public void case01(){
        System.out.println("测试Test01注解");
    }
    @Test
    public void case02(){
        System.out.println("测试Test02注解");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("测试afterTest注解");
    }
    @AfterMethod
    public void aftermethod(){
        System.out.println("测试aftermethod注解");
    }
}
