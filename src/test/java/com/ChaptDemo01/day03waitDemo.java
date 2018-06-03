package com.ChaptDemo01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/5/28 0028.
 */



@Test
public class day03waitDemo {
    WebDriver driver;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void waitTest() throws InterruptedException {

        driver.get("E:/BaiduNetdiskDownload/80块/selenium+java自动化（最新）/源码/webdriver_demo/新建文件夹/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();

        //需要等待 才能获取到文本
        //不建议使用sleep  不确定的因素太多

        //方法一  ：调用全局（隐示）等待  10秒钟没有找到元素 就执行下一步
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*****************************************************************/
        //方法二  ：显示等待
        //1.实例化一个类
        WebDriverWait wait =new WebDriverWait(driver,20);
        //2.调用方法 ExpectedConditions（类）下的presenceOfElementLocated
        //只要需要的元素一出现 就直接进行下一步 而不会继续等待；如果一直没有获取元素则会报超时错误
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));


        String str =driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(str,"wait for display");


    }


    @AfterMethod
    public void Close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
