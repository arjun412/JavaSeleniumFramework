package com.javaselenium.tests;

import com.aventstack.extentreports.Status;
import com.javaselenium.base.BaseTest;
import com.javaselenium.constants.Home;
import com.javaselenium.pages.HomePage;
import com.javaselenium.pages.LoginPage;
import com.javaselenium.utilities.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class HomeTest extends BaseTest {

    @Test(groups = {"sanity"},
        description = "Verify details on Home Page")
    public void homePageDetails() {

            LoginPage loginPage = new LoginPage(driver);

            ExtentTestManager.getTest().log(Status.INFO, "Navigating to Login Page");

            loginPage.enterUsername("student");
            loginPage.enterPassword("Password123");
            loginPage.clickLogin();

            ExtentTestManager.getTest().log(Status.INFO, "Clicked on Login button");

            Assert.assertTrue(driver.getTitle().contains("Logged In Successfully"), "Login failed!");

            ExtentTestManager.getTest().log(Status.PASS, "Login is successful");

            HomePage homePage = new HomePage(driver);

            ExtentTestManager.getTest().log(Status.INFO, "Navigating to Home Page");

            String successMessage = homePage.verifysuccessMessage();
            String successTitle = homePage.verifysuccessTitle();
            Assert.assertEquals("Congratulations student. You successfully logged in!", successMessage, "Issue with Success message!");
            Assert.assertEquals("Logged In Successfully",successTitle);
            Assert.assertTrue(homePage.verifylogoutBtn());

            Assert.assertEquals(homePage.getHomeLink(),"HOME");

            ExtentTestManager.getTest().log(Status.PASS, "Home page validations successful");
    }
}
