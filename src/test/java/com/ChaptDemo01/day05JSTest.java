package com.ChaptDemo01;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/5/30 0030.
 */
public class day05JSTest {

    WebDriver driver;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    // 1  操作js  可以修改前端js里的内容    使用 JavascriptExecutor（类）
    @Test
    public void jsTest() throws InterruptedException {
        //将driver 强制转换成JavascriptException
        driver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")");
        Thread.sleep(2000);

    }
    // 2 phantomjs  不打开浏览器界面  跑脚本 加快执行速度




    @AfterMethod
    public void closeBrowser () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
