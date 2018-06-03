package com.ChaptDemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2018/5/25 0025.
 */

//定位一个 元素  一般使用  ID  name   xpath
public class FindElements {
//打开百度 定位 搜索文本框
    WebDriver driver;

    @BeforeMethod
    public void openBrower(){
        //配置Chrome 驱动
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    //第一通过元素的ID
    public void byID(){
            driver.get("http:www.baidu.com");
            WebElement keyfile =driver.findElement(By.id("kw"));
        }
    @Test
    //第二通过 name 属性
    public void byName(){
        driver.get("http:www.baidu.com");
        WebElement keyfile =driver.findElement(By.name("wd"));
    }
    @Test
    //第三通过 class属性值 注意有的class样式是在hover时候出现的
    public void byClassName(){
        driver.get("http:www.baidu.com");
        WebElement keyfile =driver.findElement(By.className("s-user-name-top"));
    }
    @Test
    //第四通过 linkText属性值  只适用于a标签
    public void byLinkText(){
        driver.get("http:www.baidu.com");
        WebElement keyfile =driver.findElement(By.linkText("新闻"));
    }
    @Test
    //第五通过 部分PartlinkText属性值  只适用于a标签
    public void byPartiaLinkText(){
        driver.get("http:www.baidu.com");
        WebElement keyfile =driver.findElement(By.partialLinkText("新"));
    }
    @Test
    //第六通过   标签名  不经常用 因为页面内相同的元素有很多
    public void bytagname(){
        driver.get("http:www.baidu.com");
        List<WebElement> list =  driver.findElements(By.tagName("input"));
        System.out.print(list.size());
    }

    @Test
    //第7通过   xpath  直接在页面里复制
    public void byxpath01() throws InterruptedException {
        driver.get("http:www.baidu.com");
        //这里发现一个问题  我在本地直接打开的百度首页 获取的最上边一栏（新闻...）xpath
        //获取的第一个元素 新闻  是 //*[@id="u_sp"]/a[1]  但是一直不能获取到元素
        //后来 在selenium 自己打开的界面中获得 新闻  的 xpath 是//*[@id="u1"]/a 才成功
        Thread.sleep(2000);

        WebElement list =  driver.findElement(By.xpath("//*[@id=\"u1\"]/a[1]"));
        //xpath 语法里面 第一个 元素下标就是  1
        //如果xpath  是一个集合那么只返回第一个
        String s = list.getText();
        System.out.print(s);
    }

    @Test
    //第7通过   xpath  获取多个元素 //*[@id="u1"]/a[1] 获取的是第一个 这里去掉后边的序号就能获得所有
    public void byxpath02() throws InterruptedException {
        driver.get("http:www.baidu.com");
        Thread.sleep(2000);
        //获取一个list   list集合 从0开始
        List<WebElement> list =  driver.findElements(By.xpath("//*[@id='u1']/a"));
        String st =list.get(0).getText();
          int t =list.size();
        System.out.println("第一个标签是："+st+"     同级标签共有"+t+"个");
        System.out.println("显示出同级下所有的标签内容");
        for(int i=0;i<t;i++){
            String maxSt =list.get(i).getText();
            System.out.println(maxSt);
        }

    }

    @Test
    //第8通过   css  此处获取“百度一下”按钮
    public void bycss(){
        driver.get("http:www.baidu.com");
        WebElement list =  driver.findElement(By.cssSelector("#su"));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        }
   }


