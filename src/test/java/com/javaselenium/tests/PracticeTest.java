package com.javaselenium.tests;

import com.aventstack.extentreports.Status;
import com.javaselenium.base.BaseTest;
import com.javaselenium.pages.PracticePage;
import com.javaselenium.utilities.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTest extends BaseTest {

    PracticePage practicePage;

    @Test(groups = {"sanity"}, description = "Verify details on Practice Page")
    public void verifyPractice() {
        ExtentTestManager.getTest().log(Status.INFO, "Navigating to Practice Page");

        practicePage = new PracticePage(driver);
        practicePage.clickPracticelink();
        Assert.assertEquals(practicePage.getPracticelinkText(),"PRACTICE");
        Assert.assertEquals(practicePage.getPracticelbl(),"Practice");

        ExtentTestManager.getTest().log(Status.PASS, "Practice Page validations completed!");
    }

    @Test
    public void verifytestloginPage(){
        ExtentTestManager.getTest().log(Status.INFO, "Navigating to Practice Page");

        practicePage = new PracticePage(driver);
        practicePage.clickPracticelink();
        Assert.assertTrue(practicePage.gettestloginpagelink());

        ExtentTestManager.getTest().log(Status.PASS, "Verified Test Login Page Link");
    }

    @Test
    public void verifytestexceptionslink(){
        ExtentTestManager.getTest().log(Status.INFO, "Navigating to Practice Page");

        practicePage = new PracticePage(driver);
        practicePage.clickPracticelink();
        Assert.assertTrue(practicePage.gettestexecptionslink());

        ExtentTestManager.getTest().log(Status.INFO, "Verified Test Login Page Link");

    }
}
