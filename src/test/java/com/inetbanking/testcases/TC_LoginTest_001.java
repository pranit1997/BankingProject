package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {
@Test
    public void loginTest()
    {
driver.get(baseurl);
        LoginPage  lp= new LoginPage(driver);
        lp.setUsername(username);
        lp.setPassword(password);
        lp.Clicksubmit();
        if (driver.getTitle().equals("GTPL Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
        }
        else
        {Assert.assertTrue(false);}
    }
}
