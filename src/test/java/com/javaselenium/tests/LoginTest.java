package com.javaselenium.tests;

import com.aventstack.extentreports.Status;
import com.javaselenium.base.BaseTest;
import com.javaselenium.pages.LoginPage;
import com.javaselenium.utilities.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"sanity"},
            description = "Verify Successful Login")
    public void verifyLoginFunctionality() {

        LoginPage loginPage = new LoginPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Navigating to Login Page");

        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        ExtentTestManager.getTest().log(Status.INFO, "Clicked on Login button");

        Assert.assertTrue(driver.getTitle().contains("Logged In Successfully"), "Login failed!");

        ExtentTestManager.getTest().log(Status.PASS, "Login is successful");
    }

    @Test(description = "Verify Invalid Password error message")
    public void verifyLoginFunctionalityincorrectpassword() {
        LoginPage loginPage = new LoginPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Navigating to Login Page");

        loginPage.enterUsername("student");
        loginPage.enterPassword("test");
        loginPage.clickLogin();

        ExtentTestManager.getTest().log(Status.INFO, "Clicked on Login button");

        Assert.assertEquals(loginPage.getIncorrectPasswordmsg(), "Your password is invalid!");

        ExtentTestManager.getTest().log(Status.PASS, "Verified invalid password error message");
    }

    @Test(description = "Verify Invalid Userid error message")
    public void verifyLoginFunctionalityincorrectusername() {
        LoginPage loginPage = new LoginPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Navigating to Login Page");

        loginPage.enterUsername("incorrectUser");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        ExtentTestManager.getTest().log(Status.INFO, "Clicked on Login button");

        Assert.assertEquals(loginPage.getIncorrectUsernamemsg(), "Your username is invalid!");

        ExtentTestManager.getTest().log(Status.PASS, "Verified invalid username error message");
    }
}
