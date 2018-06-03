package com.ChaptDemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
public class day04avtionTest {



    WebDriver driver;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    //1  将某个元素拖拽到 另外一个指定元素里边
    @Test
    public void dragElement() throws InterruptedException {
        driver.get("file:///E:/BaiduNetdiskDownload/80%E5%9D%97/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
        //获取元素(要拖动的元素)
        WebElement element01 = driver.findElement(By.id("drag"));
        //获取元素 （要放置的元素）
        WebElement element02 = driver.findElement(By.xpath("/html/body/h1"));
        //实例化类
        Actions action = new Actions(driver);

        Thread.sleep(2000);

        action.clickAndHold(element01)//鼠标一直选中 01 元素
                .moveToElement(element02)//将01 元素 移动到 02 元素
                .release(element01)//释放01 鼠标
                .perform();//执行

    }


    //2  下拉框多选    按着 ctrl(CONTROL)  进行 点击的操作
    //模拟某个元素一直被按下
    @Test
    public void test02() throws InterruptedException {
        driver.get("file:///E:/BaiduNetdiskDownload/80%E5%9D%97/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89/%E6%BA%90%E7%A0%81/webdriver_demo/%E6%96%B0%E5%BB%BA%E6%96%87%E4%BB%B6%E5%A4%B9/selenium_html/index.html");
        //获取元素(整个下拉框)
        WebElement element01 = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        //获取下拉框里所有元素  存入一个集合
        List<WebElement> elements= driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Thread.sleep(1000);
        //实例化Actions
        Actions action =new Actions(driver);
        //按下shift不放  点击第一个元素 点击第二个元素 松开Ctrl 键  执行
        action.keyDown(Keys.SHIFT)//按下shift 键
                .click(elements.get(0))//点击第一
                .click(elements.get(2))//点击第二
                .keyUp(Keys.SHIFT)//松开shift
                .perform();//执行

    }

    //3  Action类中 的keys 中 没有提供 字母按键的使用
    //使用java 提供的 Robot
    //页面中弹出的保存框是Windows的  selenium无法进行操作  只能使用键盘快捷键
    //keyPress（）按下某个按键    keyRelease()松开某个按键
    @Test
    public void test03saveHtml() throws InterruptedException, AWTException {
        driver.get("file:///E:/BaiduNetdiskDownload/80%E5%9D%97/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89/%E6%BA%90%E7%A0%81/webdriver_demo/%E6%96%B0%E5%BB%BA%E6%96%87%E4%BB%B6%E5%A4%B9/selenium_html/index.html");
       //实例化robot
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }


    //4 文件上传
    //使用sendkeys  直接选择要上传文件的地址  即可
    @Test
    public void test04upFile() throws InterruptedException, AWTException {
        driver.get("file:///E:/BaiduNetdiskDownload/80%E5%9D%97/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89/%E6%BA%90%E7%A0%81/webdriver_demo/%E6%96%B0%E5%BB%BA%E6%96%87%E4%BB%B6%E5%A4%B9/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("D:\\vcredist.bmp");

    }

    @AfterMethod
    public void closeBrowser () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
