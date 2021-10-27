package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver ldriver; //Webdriver variable
    public AddCustomerPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
    WebElement addcustomerlink;
    @FindBy(name = "name")
    WebElement Name;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
    WebElement Gender;
    @FindBy(id = "dob" )
     WebElement Dob;
    @FindBy(name = "addr")
    WebElement Adress;
    @FindBy(name = "city")
    WebElement City;
    @FindBy(name = "state")
    WebElement State;
    @FindBy(name = "telephoneno")
    WebElement Telnumber;
    @FindBy(name = "emailid")
    WebElement Emailid;
    @FindBy(name = "sub")
    WebElement Submit;
public void ClickAddCustomer()
    {
        addcustomerlink.click();
    }
public void Customername(String cname)
{
    Name.sendKeys(cname);
}
public void Gender(String cgender)
{
    Gender.click();
}
public void Dob(String mm ,String dd , String yyyy)
{
    Dob.sendKeys(mm);
    Dob.sendKeys(dd);
    Dob.sendKeys(yyyy);
}
public void Address(String cadd)
{
    Adress.sendKeys(cadd);
}
public void City(String ccity)
{
City.sendKeys(ccity);
}
public void State(String cstate)
{
    State.sendKeys(cstate);
}
public void Telnumber(String number)
{
    Telnumber.sendKeys(String.valueOf(number));
}
public void Emailid(String cmailid)
{
    Emailid.sendKeys(cmailid);
}
public void Submit()
{
    Submit.click();
}

}



