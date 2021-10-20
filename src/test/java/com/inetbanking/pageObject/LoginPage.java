package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;
    LoginPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(name ="uid")
            @CacheLookup
    WebElement txtUsername;
    @FindBy(name = "password")
    @CacheLookup
    WebElement txtpassword;
    @FindBy(name = "btnLogin")
            @CacheLookup
    WebElement btnLogin;
    public void Setusername (String uname)
    {
        txtUsername.sendKeys(uname);
    }

    }

