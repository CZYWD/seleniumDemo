package com.ChaptDemo01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2018/6/2 0002.
 */
public class day06GridTest {
    WebDriver driver;
    @Test
    public void GridTest() throws MalformedURLException, InterruptedException {

        //创建一个DesiredCapabilities类型
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化driver  指定hub 的地址
        driver = new RemoteWebDriver(new URL("http://192.168.0.109:4444/wd/hub"),dc);
        driver.get("http://www.baidu.com");

        Thread.sleep(2000);
        driver.quit();
    }

    //数据驱动 让case 在两个浏览器测试
        @DataProvider(name = "data4")
            public Object[][] test1(){
                return new Object[][]{
                    {"firefox"},
                    {"chrome"}};
    }
        @Test(dataProvider = "data4")
        public void testGrid2(String browser) throws MalformedURLException, InterruptedException {
                DesiredCapabilities dc =null;
                if(browser.contentEquals("firefox")){
                    dc = DesiredCapabilities.firefox();
                }else if (browser.equals("chrome")){
                    dc=DesiredCapabilities.chrome();
            }else{
                System.out.println("error");
            }
            driver = new RemoteWebDriver(new URL("http://192.168.0.109:4444/wd/hub"),dc);
            driver.get("http://www.baidu.com");

            Thread.sleep(2000);
            driver.quit();
        }

}
