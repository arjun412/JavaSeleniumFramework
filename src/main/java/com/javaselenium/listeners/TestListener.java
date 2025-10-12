package com.javaselenium.listeners;

import com.aventstack.extentreports.Status;
import com.javaselenium.utilities.DriverFactory;
import com.javaselenium.utilities.ExtentTestManager;
import com.javaselenium.utilities.ScreenshotUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed ❌");
        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());

        Object testClass = result.getInstance();
        try {
            WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(testClass);
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // other methods can be left empty or used for logging/reporting
    @Override public void onStart(ITestContext context) {
        System.out.println("🚀 Test Suite started: " + context.getName());
    }
    @Override public void onFinish(ITestContext context) {
        ExtentTestManager.getExtent().flush();
        System.out.println("✅ Test Suite finished: " + context.getName());
    }
    @Override public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        ExtentTestManager.getTest().log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }
    @Override public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed ✅");
    }
    @Override public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped ⚠️");
    }
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

}
