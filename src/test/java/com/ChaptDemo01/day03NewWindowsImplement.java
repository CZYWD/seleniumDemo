package com.ChaptDemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/5/28 0028.
 */
public class day03NewWindowsImplement {
    WebDriver driver;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
    }

//对页面中跳转的新页面进行操作
//为新页面赋予权限  driver.switchTo().window(句柄值);

//打开新窗口  点击新窗口与中的 百度链接
    @Test
public void testWindow() throws InterruptedException {
    driver.get("E:/BaiduNetdiskDownload/80块/selenium+java自动化（最新）/源码/webdriver_demo/新建文件夹/selenium_html/index.html");
    WebElement oldWindow =driver.findElement(By.linkText("Open new window"));
    oldWindow.click();
    Thread.sleep(2000);

    //获取当前页面的句柄
    String handle = driver.getWindowHandle();
    //foreach语法
    //for(元素类型t 元素变量x : 遍历对象obj){
    // 引用了x的java语句;}
    // for 循环判断 获取到的handles是否等于当前页面  如果不等于就将权限赋予给跳转的页面
    for(String handles:driver.getWindowHandles()){
        //与第一个页面内的句柄比较  当句柄不予第一个相等时 就把权限赋予给了新窗口 只适用于两个窗口的情况
        if(handles.equals(handle)){
            continue;
        }else{
            //给要跳转的新界面进行权限赋予  要传入新页面的句柄
            driver.switchTo().window(handles);
        }
    }

    WebElement freshWindow = driver.findElement(By.linkText("baidu"));
    freshWindow.click();


}


    @AfterMethod
    public void Close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
