package com.ChaptDemo01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/5/24 0024.
 */
public class OpenBrowers {

    @Test
    //默认安装在c盘
    public void openF01(){
        //实例化火狐Driver
        WebDriver webDriver = new FirefoxDriver();

    }
    @Test
    //装在其他盘
    public void openF02(){
        //实例化火狐Driver
        //selenium 48以下自带driver驱动  大于48 需要下载driver文件
        System.setProperty("webdriver.firefox.bin","D:\\Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver","E:\\browser\\geckodriver.exe");
        //初始化一个火狐浏览器实例，实例名称叫driver
        WebDriver driver = new FirefoxDriver();
//        //最大化窗口
//        driver.manage().window().maximize();
//        //设置隐性等待时间
//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//
//        // get()打开一个站点
//        driver.get("https://www.baidu.com");
//        //getTitle()获取当前页面title的值
//        System.out.println("当前打开页面的标题是： "+ driver.getTitle());
//
//        //关闭并退出浏览器
//        driver.quit();
    }
    @Test
    //启动谷歌浏览器
    public void openC01(){
    //配置Chrome 驱动
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }

    @Test
    //启动IE浏览器
    public void openIe01(){
        //配置Chrome 驱动
        System.setProperty("webdriver.ie.driver","E:\\browser\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }


}
