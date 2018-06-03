package com.ChaptDemo01;

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

/**
 * Created by Administrator on 2018/5/31 0031.
 */
public class day05sendEmail {
    WebDriver driver;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }

    @Test
    public void sendEmail() throws InterruptedException {
        //调用一个类的静态方法，实现登录操作
        day05LoginTest.login(driver,"cai_zeyuan","931013.");
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

        //延时
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        //验证是否跳转到 登录成功的界面
        String st  = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(st,"退出");

        /*很多时候 浏览器给出的xpatch 并不标准 需要手动匹配
         xpath:  . 	选取当前节点; //  	从匹配选择的当前节点选择文档中的节点，而不考虑它们的位置;
                 //*  	选取文档中的所有元素;     */
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("2368665405@qq.com");
        //xpath 通过元素的属性值 进行定位  因为这些属性值内容唯一  容易定位
        driver.findElement(By.xpath(".//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("主题");
        //上传文件
        driver.findElement(By.xpath(".//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("D:\\test.png");

        WebElement frame =driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("/html/body")).sendKeys("这是文本");

        //把控制权 从 ifram 转交给 主页面
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[text()='发送']")).click();

    }



    @AfterMethod
    public void closeBrowser () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
