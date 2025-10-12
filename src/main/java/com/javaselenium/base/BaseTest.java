package com.javaselenium.base;

import com.aventstack.extentreports.Status;
import com.javaselenium.utilities.ConfigReader;
import com.javaselenium.utilities.DriverFactory;
import com.javaselenium.utilities.ExtentManager;
import com.javaselenium.utilities.ExtentTestManager;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional String browser, Method method) {
        if (browser == null) browser = ConfigReader.get("defaultBrowser");
        driver = DriverFactory.initDriver(browser);
        driver.get(ConfigReader.get("baseUrl"));
//        String testName = method.getName();
//        String description = "";
//        if (method.getAnnotation(Test.class) != null) {
//            description = method.getAnnotation(Test.class).description();
//        }
//
//        ExtentTestManager.startTest(testName, description);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        DriverFactory.quitDriver();
        // Log result in Extent report
//        if (result.getStatus() == ITestResult.FAILURE) {
//            ExtentTestManager.getTest().log(Status.FAIL, "❌ Test Failed: " + result.getThrowable());
//        } else if (result.getStatus() == ITestResult.SKIP) {
//            ExtentTestManager.getTest().log(Status.SKIP, "⚠️ Test Skipped");
//        } else {
//            ExtentTestManager.getTest().log(Status.PASS, "✅ Test Passed");
//        }
        ExtentTestManager.endTest();
    }
}

