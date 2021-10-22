package com.inetbanking.testcases;

import com.inetbanking.utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;


public class BaseClass {
    ReadConfig readConfig = new ReadConfig(); // Create object for Readconfig and import package
    //change variable name with methods readconfig.variable
    public String baseurl = readConfig.ApplicationURL();
    public String username = readConfig.Username();
    public String password = readConfig.Password();
    public static WebDriver driver;

    //public static Logger logger;
    @BeforeClass
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", readConfig.Chromepath());
        driver = new ChromeDriver();


        // Logger logger = Logger.getLogger(BaseClass.class);
        //  PropertyConfigurator.configure("Log4j.properties");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }


}
