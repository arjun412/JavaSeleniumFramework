package com.javaselenium.pages;

import com.javaselenium.constants.Home;
import com.javaselenium.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    public WaitUtils waitUtils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }


    private By successTitle = By.xpath(Home.xpathsuccessTitle);
    private By successMessage = By.xpath(Home.xpathsuccessMessage);
    private By logoutBtn = By.xpath(Home.xpathlogoutBtn);
    private By homeLink = By.xpath(Home.xpathhomeLink);

   public String verifysuccessTitle(){
        return driver.findElement(successTitle).getText();
   }

   public String verifysuccessMessage(){
        return driver.findElement(successMessage).getText();
   }

   public boolean verifylogoutBtn(){
        return driver.findElement(logoutBtn).isDisplayed();
    }

    public String getHomeLink(){
        WebElement homelink = waitUtils.waitForClickable(homeLink);
        return homelink.getText();
    }
}
