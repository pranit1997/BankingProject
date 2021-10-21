package com.inetbanking.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public class BaseClass {
    public String baseurl = "http://demo.guru99.com/V1/index.php";
    public String username = "mngr360344";
    public String password = "zApurYt";
    public static WebDriver driver;
    public static Logger logger;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();

        Logger logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");
    }
@AfterClass
    public void teardown()
{
    driver.quit();
}


}
