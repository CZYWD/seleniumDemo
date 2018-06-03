package com.ChaptDemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/5/28 0028.
 */
public class day03actionTest {
//介绍Action类
    WebDriver driver;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
    }

        // 1  鼠标右击  引入action类
        @Test
        public void rightClick () {
            driver.get("http://www.baidu.com");
            WebElement button = driver.findElement(By.id("su"));
            //实例化actions
            Actions action = new Actions(driver);
            //在 百度一下 按钮上 进行右击
            action.contextClick(button).perform();

        }
    @Test
        //2  鼠标双击
        public void doubleClick () {
            driver.get("http://www.baidu.com");
            //定位按钮元素
            WebElement button = driver.findElement(By.id("su"));
            //实例化actions
            Actions action = new Actions(driver);
            //在 百度一下 按钮上 进行右击
            action.contextClick(button).perform();
            //双击百度一下按钮            (不传参数会在鼠标当前界面进行点击)
            action.doubleClick(button);

        }

    @Test
    //3 鼠标移动当某元素上
    //测试页面数遍移动到按钮上下方会出现文字
    //  获取hover 之后显示的文本
    public void move () throws InterruptedException {
        driver.get("E:/BaiduNetdiskDownload/80块/selenium+java自动化（最新）/源码/webdriver_demo/新建文件夹/selenium_html/index.html");
        //定位按钮元素
        WebElement el = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        //实例化actions
        Actions action = new Actions(driver);
        //鼠标移动到指定元素上边
        action.moveToElement(el).perform();
        Thread.sleep(2000);
        //获取hover之后的文本
        String hello = driver.findElement(By.xpath(".//[text()='Hello World!']")).getText();
        Assert.assertEquals(hello,"Hello World!");
    }


    @Test
    //4  鼠标拖拽
    public void drag () {
        driver.get("file:///E:/BaiduNetdiskDownload/80%E5%9D%97/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");

        //获取元素
        WebElement element = driver.findElement(By.id("drag"));
        //实例化类
        Actions action = new Actions(driver);
        //执行拖拽到 x500  y500
        action.dragAndDropBy(element,500,500).perform();

    }

        @AfterMethod
        public void closeBrowser () throws InterruptedException {
            Thread.sleep(2000);
            driver.quit();
        }
    }
