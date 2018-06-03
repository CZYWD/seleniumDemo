package com.ChaptDemo01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/5/28 0028.
 */
public class day03AlertDemo {
    WebDriver driver;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //一下弹框处理 只适用于js 弹框 因为这种弹框无法获取页面元素
    @Test
    //test01  alter警告框
    //
    //
    public void AlterTest() throws InterruptedException {

        driver.get("E:/BaiduNetdiskDownload/80块/selenium+java自动化（最新）/源码/webdriver_demo/新建文件夹/selenium_html/index.html");
        //获取 弹框元素
        WebElement input =driver.findElement(By.className("alert"));
        input.click();
        //js执行需要一点时间 所以要演示一会儿
        Thread.sleep(2000);
        //将页面的控制权限交给小窗
        Alert alt = driver.switchTo().alert();

        //获取弹框的文本值
        String  a =alt.getText();
        System.out.println(a);
        //调用 Alerrt 里边的确定操作
        alt.accept();
    }


    @Test
    //test02    Confirm 确认框
    //
    //
    public void Confirm() throws InterruptedException {

        driver.get("E:/BaiduNetdiskDownload/80块/selenium+java自动化（最新）/源码/webdriver_demo/新建文件夹/selenium_html/index.html");
        //获取 弹框元素
        WebElement input =driver.findElement(By.className("confirm"));
        input.click();
        //js执行需要一点时间 所以要演示一会儿
        Thread.sleep(2000);
        //将页面的控制权限交给小窗
        Alert alt = driver.switchTo().alert();
        //调用 Alerrt 里边的取消操作
        alt.dismiss();

        Thread.sleep(2000);
        //点击确定
        alt.accept();
    }

    @Test
    //test03    Prompt提示框  可以输入文本
    //
    //
    public void Prompt() throws InterruptedException {

        driver.get("E:/BaiduNetdiskDownload/80块/selenium+java自动化（最新）/源码/webdriver_demo/新建文件夹/selenium_html/index.html");
        //获取 弹框元素
        WebElement input =driver.findElement(By.className("prompt"));
        input.click();
        //js执行需要一点时间 所以要演示一会儿
        Thread.sleep(2000);
        //将页面的控制权限交给小窗
        Alert alt = driver.switchTo().alert();
        //向弹框里边输入文本   在谷歌浏览器中好像不能再文本中输入文本  火狐浏览器 可以
        alt.sendKeys("study");
        Thread.sleep(1000);
        alt.accept();

        Thread.sleep(2000);
        //点击确定
        alt.accept();
    }

    //**************************************************************************************************//
    @Test
    //关于iframe 框体
    //如果一个页面中 包含了 iframe 需要把页面的控制权 转交给 iframe界面
    //通过  driver.switchTo().frame("aa");使窗体获得权限
    //通过
    public void iframe() throws InterruptedException {
        driver.get("E:/BaiduNetdiskDownload/80块/selenium+java自动化（最新）/源码/webdriver_demo/新建文件夹/selenium_html/index.html");
        //将控制权转交给iframe   里边要填入参数  name 或者 id   或者 页面元素
        driver.switchTo().frame("aa");
        //获取元素
        WebElement click01 =driver.findElement(By.linkText("baidu"));
        //
        click01.click();

        //点击页面 外部的元素 需要把权限重新交还给 外部
        driver.switchTo().defaultContent();
        WebElement click02 =driver.findElement(By.linkText("登录界面"));
        click02.click();

    }


    //**************************************************************************************************//
    @Test
    //关于下拉框的操作
    //如果一个页面中 包含了 iframe 需要把页面的控制权 转交给 iframe界面
    //通过  driver.switchTo().frame("aa");使窗体获得权限
    //通过
    public void selectTest() throws InterruptedException {
        driver.get("E:/BaiduNetdiskDownload/80块/selenium+java自动化（最新）/源码/webdriver_demo/新建文件夹/selenium_html/index.html");

        WebElement selcetEl = driver.findElement(By.id("moreSelect"));
        //实例化select 类  并传入获取到的 下拉框
        Select select = new Select(selcetEl);
        //通过索引角标
        select.selectByIndex(2);
        Thread.sleep(1000);
        //通过vlue
        select.selectByValue("huawei");
        Thread.sleep(1000);
        //通过下拉框的文本信息
        select.selectByVisibleText("iphone");

    }

    @AfterMethod
    public void Close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
