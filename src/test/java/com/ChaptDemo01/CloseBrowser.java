package com.ChaptDemo01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/5/25 0025.
 */
public class CloseBrowser {
    WebDriver driver;

    @BeforeMethod
    public void openBrower(){
        //配置Chrome 驱动
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
    }

    @Test
    //启动谷歌浏览器  并退出
    public void openC01() throws InterruptedException {

        driver = new ChromeDriver();
        //延时5秒
        Thread.sleep(5000);
        //关闭当前窗口
        //driver.close();
        //关闭浏览器完全退出  关闭进程
        driver.quit();
    }

    @Test
    //启动谷歌浏览器  进入百度
    public void openC02() throws InterruptedException {

        driver = new ChromeDriver();
        //打开百度
        driver.get("http:www.baidu.com");

        //延时5秒s
        Thread.sleep(5000);
        //关闭浏览器完全退出  关闭进程
        driver.quit();
    }

    @Test
    //启动谷歌浏览器  进入百度  进行前进后退操作
    public void openC03() throws InterruptedException {

        driver = new ChromeDriver();
        //打开百度
        driver.get("http:www.baidu.com");
        //延时2秒s
        Thread.sleep(2000);

        //浏览器后退
        driver.navigate().back();

        //延时2秒s
        Thread.sleep(2000);
        //关闭浏览器完全退出  关闭进程
        driver.quit();
    }

    @Test
    //启动谷歌浏览器  进入百度  进行后退操作
    public void openC04() throws InterruptedException {

        driver = new ChromeDriver();
        //打开百度
        driver.get("http:www.baidu.com");
        //延时2秒s
        Thread.sleep(2000);

        //浏览器后退
        driver.navigate().back();
        //延时2秒s
        Thread.sleep(2000);
        //浏览器前进
        driver.navigate().forward();
        //延时2秒s
        Thread.sleep(2000);
        //关闭浏览器完全退出  关闭进程
        driver.quit();
    }

    @Test
    //刷新浏览器
    public void RefreshenopenC05() throws InterruptedException {

        driver = new ChromeDriver();
        //打开百度
        driver.get("http:www.baidu.com");
        //延时2秒s
        Thread.sleep(2000);

        //刷新
        driver.navigate().refresh();
        //延时2秒s
        Thread.sleep(2000);

        //关闭浏览器完全退出  关闭进程
        driver.quit();
    }


    @Test
    //设置浏览器窗口的大小  和 最大化浏览器
    public void WinMaxC06() throws InterruptedException {

        driver = new ChromeDriver();

        //打开百度
        driver.get("http:www.baidu.com");
        //实例化Dimension
        Dimension dim = new Dimension(300,500);
        driver.manage().window().setSize(dim);

        //延时2秒s
        Thread.sleep(2000);
        //设置窗口最大化
        driver.manage().window().maximize();

        //延时1秒s
        Thread.sleep(1000);
        //刷新
        driver.navigate().refresh();
        //延时2秒s
        Thread.sleep(2000);
        //关闭浏览器完全退出  关闭进程
        driver.quit();
    }


    @Test

    //获取当前页的url地址
    public void GetUrlC07() throws InterruptedException {
        driver = new ChromeDriver();
        //打开百度
        driver.get("http:www.baidu.com/");
       //获取当前的页面地址
        String url=driver.getCurrentUrl();
        System.out.println("获取的地址是"+url);

        //校验当前页面是否是百度
        Assert.assertEquals(url,"http://www.baidu.com/");
        //
        Thread.sleep(2000);
        //关闭浏览器完全退出  关闭进程
        driver.quit();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
