package com.javaselenium.pages;

import com.javaselenium.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public PracticePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private By practicelink = By.xpath("//*[@id='menu-item-20']/a");
    private By practicelbl = By.xpath("//*[@id='loop-container']/div/article/div[1]/h1");

    private By testloginpagelink = By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a");

    private By testexecptionslink = By.xpath("//*[@id='loop-container']/div/article/div[2]/div[2]/div[1]/p/a");

    public void clickPracticelink() {
        waitUtils.waitForClickable(practicelink).click();
    }

    public String getPracticelinkText() {
        WebElement practiceText = waitUtils.waitForVisibility(practicelink);
        return practiceText.getText();
    }

    public String getPracticelbl() {
        WebElement practiceText = waitUtils.waitForVisibility(practicelbl);
        return practiceText.getText();
    }

    public boolean gettestloginpagelink() {
        WebElement elementtestloginpagelink = waitUtils.waitForVisibility(testloginpagelink);
        return elementtestloginpagelink.isDisplayed();
    }

    public boolean gettestexecptionslink() {
        WebElement elementtestexecptionslink = waitUtils.waitForVisibility(testexecptionslink);
        return elementtestexecptionslink.isDisplayed();
    }

}
