package com.ChaptDemo01;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/5/27 0027.
 */
public class day03ActionDemo {
    WebDriver driver;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    // click   点击操作
    //打开百度页面的 新闻
    public void click() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //获取新闻标签
        WebElement newslink = driver.findElement(By.name("tj_trnews"));
        //点击新闻链接
        newslink.click();
        Thread.sleep(3000);
        String url =driver.getCurrentUrl();
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    @Test
    //在文本框中输入文字  sendKeys   并进行搜索
    //校验 title 中是否 有要搜索的内容的文字
    //
    public void sendkeysTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //获取搜索框
        WebElement input =driver.findElement(By.id("kw"));
        //搜索框输入 selenium
        input.sendKeys("selenium");
        //获取搜索按钮
        WebElement button =driver.findElement(By.id("su"));
        //点击按钮
        button.click();
        //延时  否则点后的页面  还没有加载
        Thread.sleep(5000);
        //获取网页标题
        String  title =driver.getTitle();
        //对预期的title 进行校验
        Assert.assertEquals(title,"selenium_百度搜索");
}

    @Test
    //获取标签属性值

    public void getAttribute() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //获取搜索框
        //获取搜索按钮
        WebElement button =driver.findElement(By.id("su"));
        //搜索框输入 selenium
        String Att = button.getAttribute("value");
        System.out.println(Att);
        Assert.assertEquals(Att,"百度一下");
    }


    @Test
    //获取文本标签 tagName

    public void getTagname() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //获取搜索框
        WebElement input =driver.findElement(By.id("kw"));
        //搜索框输入 selenium
        String Tag = input.getTagName();
        System.out.println(Tag);
        Assert.assertEquals(Tag,"input");
    }


    @Test
    //clear操作  对输入的文本进行清空
    //在搜索框中输入文本后  进行清空
    //
    public void clearkeysTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //获取搜索框
        WebElement input =driver.findElement(By.id("kw"));
        //搜索框输入 selenium
        input.sendKeys("selenium");
        //延时
        Thread.sleep(2000);
        //清空文本
        input.clear();
        //延时
        Thread.sleep(2000);

    }

    @Test
    //本来打算在搜索框中输入文本后  输入文本 selenium  获取输入的文本 进行校验
    //特别注意
    //获取搜索框的文本    用 gettext是错误的 因为gettest获取的是标签中间的值

    //获取百度页面新闻的标签  并获取文本
    //对文本进行校验


    public void gettextTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //获取新闻标签
        WebElement input =driver.findElement(By.xpath("//*[@id=\"u1\"]/a[1]"));
        //延时
        Thread.sleep(2000);
        //获得文本
        String text = input.getText();
        //对文本进行校验
        Assert.assertEquals(text,"新闻");
        //获取搜索框的文本内容
        System.out.println(text);
    }

    @Test
    //判断一个元素是否展示

    public void display() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //获取按钮
        WebElement input =driver.findElement(By.id("su"));
        Boolean bl = input.isDisplayed();
        Assert.assertTrue(bl);
    }

    @Test
    //判断一个元素是否被选中 例如选择框 输入框
    //这里实验百度的 输入框是不对的 因为自动被选中了  值介绍一个思路会用即可

    public void isSelected() throws InterruptedException {
        //driver.get("https://www.baidu.com/");
        driver.get("E:/BaiduNetdiskDownload/80块/selenium+java自动化（最新）/源码/webdriver_demo/新建文件夹/selenium_html/index.html");
        //获取 单选框按钮
        WebElement input =driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));

        input.click();
        Thread.sleep(1000);
        //判断单选框是否被选中
        Boolean in = input.isSelected();
        Assert.assertTrue(in);
    }

    @Test
    //判断一个元素是否被激活
    public void isEnabled() throws InterruptedException {
        //driver.get("https://www.baidu.com/");
        driver.get("E:/BaiduNetdiskDownload/80块/selenium+java自动化（最新）/源码/webdriver_demo/新建文件夹/selenium_html/index.html");
        //获取 单选框按钮
        WebElement input =driver.findElement(By.name("buttonhtml"));
        //判元素是否被激活
        Boolean in = input.isEnabled();
        //判断是图通过的  因为 这个按钮没有被激活
        Assert.assertTrue(in);
    }

    @Test
    //截图  为了判断出哪里出错 可以在错误的页面添加截图
    //FileUtils   这个jar我导入了 好像没用

    public void screen() {
        driver.get("https://www.baidu.com/");
        //将driver 的类型 强制转换成这个类型
        File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void Close(){
        driver.quit();
    }
}
