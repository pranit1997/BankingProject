package com.inetbanking.testcases;

import com.inetbanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;


public class BaseClass {
    ReadConfig readConfig = new ReadConfig(); // Create object for Readconfig and import package
    //change variable name with methods readconfig.variable
    public String baseurl = readConfig.ApplicationURL();
    public String username = readConfig.Username();
    public String password = readConfig.Password();
    public static WebDriver driver;

    //public static Logger logger;
    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {
        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.Chromepath());
            driver = new ChromeDriver();
        }
       // else if (br.equals("firefox"));
        //System.setProperty("webdriver.firefox.marionette", readConfig.Firefox());
        //driver = new FirefoxDriver();
        // Logger logger = Logger.getLogger(BaseClass.class);
        //  PropertyConfigurator.configure("Log4j.properties");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
public void captureScreen(WebDriver driver , String tname) throws IOException{
    TakesScreenshot ts = (TakesScreenshot) driver;
    File Source = ts.getScreenshotAs(OutputType.FILE);
    File target = new File(System.getProperty("src/test/resources/Screenshot/" + tname  + ".png"));
    FileUtils.copyFile(Source , target);
    System.out.println("Screenshot taken");
}

}
