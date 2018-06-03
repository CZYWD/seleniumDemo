package com.po.page;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2018/6/3 0003.
 */

//163登录界面的 元素对象
//将定位元素进行抽取 如果页面有变更 直接更改po 里边的元素定位方式
public class LoginPage {
    //定义 email文本框的定位方式
    public static By emailInput = By.name("email");
    //定义 密码输入框定位方式
    public static By pwdInput = By.name("password");
    //定义 登录按钮定位方式
    public static By loginButton = By.id("dologin");
    //定义 注册按钮定位方式
    public static By zhuceButton = By.id("changepage");

}
