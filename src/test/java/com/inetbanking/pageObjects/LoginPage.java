package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
                 WebDriver ldriver;
                 public LoginPage(WebDriver rdriver)
                 {ldriver=rdriver;
                     PageFactory.initElements(rdriver ,this);
                 }//without this driver will not awake
    @FindBy(name ="uid")
    @CacheLookup
    WebElement txtUsername;
    @FindBy(name = "password")
    @CacheLookup
    WebElement txtpassword;
    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement btnLogin;

    public void setUsername(String uname)
    {
        txtUsername.sendKeys(uname);
    }
    public void setPassword(String pwd)
    {
        txtpassword.sendKeys(pwd);
    }
    public void Clicksubmit()
    {
        btnLogin.click();
    }






}
