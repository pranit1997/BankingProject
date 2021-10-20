package com.inetbanking.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public String baseurl = "http://demo.guru99.com/V1/index.php";
    public String username = "mngr360344";
    public String password = "zApurYt";
    public static WebDriver driver;

    @BeforeClass
    public void setup()
    {
        System.setProperty("Webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    }
@AfterClass
    public void teardown()
{
    driver.quit();
}


}
