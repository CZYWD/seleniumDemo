package vidoDay04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/6/3 0003.
 */
public class DataDriver {

    //学习数据驱动

    //创建数据  这里创建 用户名 和密码
    //返回值object类型
    @DataProvider(name = "login")
    public Object[][]data01(){
        return new Object[][]{
                {"user1","pwd01"},
                {"user2","pwd02"}
        };
    }

    @Test(dataProvider = "login")
    public void loginTest(String user,String pwd){
        System.out.println("user:"+user);
        System.out.println("pwd:"+pwd);
    }



}
