package com.inetbanking.testcases;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class TC_AddcustomerPage_3 extends BaseClass
{
    @Test
public void AddCustomer() throws InterruptedException {
    LoginPage lp = new LoginPage(driver);
lp.setUsername(username);
lp.setPassword(password);
lp.Clicksubmit();

Thread.sleep(3000);
        AddCustomerPage addCust = new AddCustomerPage(driver);
addCust.ClickAddCustomer();
addCust.Customername("Pranit");
addCust.Gender("male");
addCust.Dob("03","08" ,"1997");
addCust.Address("Home");
addCust.City("Nagpur");
addCust.State("Maharashtra");
addCust.Telnumber("123456789");
        String email = RandomString()+"@gmail.com";
        addCust.Emailid(email);
        Thread.sleep(5000);
addCust.Submit();
System.out.println("Sucess");
    }
public String RandomString()
{
    String generatedString = RandomStringUtils.randomAlphabetic(5);
       return(generatedString);
}
}
