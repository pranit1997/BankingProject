package com.inetbanking.testcases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass {

@Test(dataProvider = "Credentials")
    public void loginDDT(String uname, String pwd) throws InterruptedException
{
        LoginPage lp = new LoginPage(driver);
        lp.setUsername(uname);
        lp.setPassword(pwd);
        lp.Clicksubmit();
        Thread.sleep(3000);

        if (isAlertpresent() == true) {
            driver.switchTo().alert().accept();//Close alert
        driver.switchTo().defaultContent();
        Assert.assertTrue(false);
    }
    else
        {
            Assert.assertTrue(true);
            lp.clicklogout();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
    }

public boolean isAlertpresent()//userdefined method to check alert is present or not
{
    try {

    driver.switchTo().alert();
return true;
    }
catch (NoAlertPresentException e)
{
return false;
}
}


    @DataProvider(name = "Credentials")
    public Object[][] getData() throws IOException {
        String path = System.getProperty("C://Credentials.xlsx");
        int rownumber = XLUtils.getrowcount(path, "Sheet1"); // this will return rowcount
        int cocount = XLUtils.getcellcount(path, "Sheet1", 1);// this will return cellcount
        String Logindata[][] = new String[rownumber][cocount];//2 D array

        for (int i = 1; i <= rownumber; i++)//no of rows
        {
            for (int j = 0; j < cocount; j++) // no of coloumn
            {
                Logindata[i - 1][j] = XLUtils.getcelldata(path, "xlsheet", i, j); // 1, 0
            }
        }
        return Logindata;
    }
}
