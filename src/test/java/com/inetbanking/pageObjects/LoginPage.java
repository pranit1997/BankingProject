package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;//web driver object l= local

    public LoginPage(WebDriver rdriver) //webdriver as a parameter r = remote
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }//without this driver will not awake

    @FindBy(name = "uid")
    @CacheLookup
    WebElement txtUsername;
    @FindBy(name = "password")
    @CacheLookup
    WebElement txtpassword;
    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement btnlogout;

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
public void  clicklogout()
{
    btnlogout.click();
}


}



