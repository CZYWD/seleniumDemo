package com.ChaptDemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/5/31 0031.
 */
//关于163邮箱的注册实战
public class day05Register {
    WebDriver driver;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }

    @Test
    public void register() throws InterruptedException {
        //登录框在iframe里边  所以要把页面权限先移交给 iframe
        driver.switchTo().frame("x-URS-iframe");
        //获取点击元素
        driver.findElement(By.id("changepage")).click();
        Thread.sleep(1000);
        //获取当前页面   WindowHandle通过一个页面的句柄值
        String handle1 = driver.getWindowHandle();
        //把控制权转交个跳转到的页面
        for(String handles:driver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;
            }
            else {
                driver.switchTo().window(handles);
            }
        }
        //每一次运行数据都不一样  所以创建一个时间戳  因为每个时刻都不一样
        //这个时间戳是毫秒级别  除100换成秒
        String time = String.valueOf(System.currentTimeMillis()/100);

        //对跳转的注册页面 进行操作
        //获取输入框元素
        driver.findElement(By.id("nameIpt")).sendKeys("a"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("123456789");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123456789");
        driver.findElement(By.id("mainMobileIpt")).sendKeys("15733333333");
        //验证码的输入   1让开发提供万能验证码
        driver.findElement(By.id("vcodeIpt")).sendKeys("33333");
        //输入短信验证码 1开发提供万能验证码
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("33333");
        driver.findElement(By.id("mainRegA")).click();

       //显示等待
        //1.实例化一个类
        WebDriverWait wait =new WebDriverWait(driver,20);
        //2.调用方法 ExpectedConditions（类）下的presenceOfElementLocated
        //只要需要的元素一出现 就直接进行下一步 而不会继续等待；如果一直没有获取元素则会报超时错误
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainAcode\"]/span")));

        //第一次运行时这里报错 找不到元素 因为页面加载没有跟上  所以添加了显示等待
        String st =driver.findElement(By.xpath("//*[@id=\"m_mainAcode\"]/span")).getText();
        Assert.assertEquals(st,"  手机验证码不正确，请重新填写");
    }

    @AfterMethod
    public void closeBrowser () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
