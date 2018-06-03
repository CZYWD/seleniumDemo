package com.ChaptDemo01;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
public class Equals {

    @Test
    //判断相等
    public void equals(){
        String a="abc";
        String b="ab";
        //Assert.assertEquals(a,b,message:"a不等于b");
        Assert.assertEquals(a,b);
    }

    @Test
    //判断不等
    public void noEquals(){
        int a=1;
        int b=2;
        Assert.assertNotEquals(a,b);
    }
    @Test
    public void assertNull(){
        String a =null;
        Assert.assertNull(a);
    }

    @Test
    public void assertNotNull(){
        String a ="1";
        Assert.assertNotNull(a);
    }
}
