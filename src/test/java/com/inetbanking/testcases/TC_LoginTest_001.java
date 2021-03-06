package com.inetbanking.testcases;

import com.inetbanking.pageObjects.LoginPage;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends com.inetbanking.testcases.BaseClass {
    @Test
    public void loginTest() throws IOException {
        driver.get(baseurl);

//logger.info("url is opened");
        LoginPage lp = new LoginPage(driver);
        lp.setUsername(username);
        //  logger.info("Entered username");
        lp.setPassword(password);
        // logger.info("Entered password");
        lp.Clicksubmit();
        if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {
            Assert.assertTrue(true);
            //   logger.info("Login Test Passed");
        } else {
            captureScreen(driver, "login test");
            Assert.assertTrue(false);
            //logger.info("Login Test Failed");}
            lp.clicklogout();

        }
    }
}