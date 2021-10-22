package com.inetbanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter
{
    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext testContext) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Time stamp
        String repName = "Test-Report" + timestamp + ".html";
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/"+repName);
        htmlReporter.config().setDocumentTitle("Banking Project 1.0 Report");//Title of the report
        htmlReporter.config().setReportName("Functional Banking Project Report");//Name of the report
        htmlReporter.config().setTheme(Theme.STANDARD);}
    public void onTestSucess(ITestResult tr)
    {
        test = extent.createTest(tr.getName()); // Create new entry in the report
        test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); //Send pass information
    }
public void onTestFailure(ITestResult tr) {
    test = extent.createTest(tr.getName()); //Create new entry in the report
    test.log(Status.FAIL , MarkupHelper.createLabel(tr.getName(), ExtentColor.BLACK )); //Send pass information

    String ScreenShotpath = System.getProperty("user.dir") + "/Screenshots/" +tr.getName()  + ".png";
File f = new File(ScreenShotpath);
if (f.exists())
{
    test.fail("Screenshot is below:" + test.addScreenCaptureFromBase64String(ScreenShotpath));
}
    }

    public void onTestSkipped(ITestResult tr)
    {
        test = extent.createTest(tr.getName());  //Create new entry in the report
        test.log(Status.SKIP , MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }
}
