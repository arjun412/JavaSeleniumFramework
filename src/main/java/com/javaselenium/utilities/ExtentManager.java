package com.javaselenium.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        // 📅 Generate dynamic timestamp for each report
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/" + "TestExecutionReport_" + timestamp + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        // 🖤 Report configuration
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Test Execution Report");
        sparkReporter.config().setReportName("Java Selenium Framework Report");

        // 📘 Create and configure ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // ℹ️ Add system/environment info
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Arjunkumar Shah");

        return extent;
    }
}
