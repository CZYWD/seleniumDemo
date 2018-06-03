package vidoDay04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.po.page.LoginPage.emailInput;
import static com.po.page.LoginPage.loginButton;
import static com.po.page.LoginPage.pwdInput;

/**
 * Created by Administrator on 2018/5/31 0031.
 */
//关于163邮箱的注册实战
public class LoginPoTest {
    WebDriver driver;
    @BeforeMethod
    public void opendriver(){
        System.setProperty("webdriver.chrome.driver","E:\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }

    @Test
    public void loginTest() throws InterruptedException {

        LoginPoTest.login(driver,"cai_zeyuan","931013.");
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
        //2.调用方法 ExpectedConditions（类）下的presenceOfElementLocated
        //只要需要的元素一出现 就直接进行下一步 而不会继续等待；如果一直没有获取元素则会报超时错误
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        //验证是否跳转到 登录成功的界面
        String st  = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(st,"退出");


    }
    public static void login(WebDriver driver,String email,String pwd) throws InterruptedException {
        //登录框在iframe里边  所以要把页面权限先移交给 iframe
        driver.switchTo().frame("x-URS-iframe");
        Thread.sleep(1000);
        //输入账户
        driver.findElement(emailInput).sendKeys(email);
        //输入密码
        driver.findElement(pwdInput).sendKeys(pwd);
        //点击确定
        driver.findElement(loginButton).click();

        Thread.sleep(1000);
    }

    @AfterMethod
    public void closeBrowser () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}

