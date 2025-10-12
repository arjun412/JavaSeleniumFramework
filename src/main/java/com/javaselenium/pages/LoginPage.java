package com.javaselenium.pages;

import com.javaselenium.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    WaitUtils waitUtils = new WaitUtils(driver);

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginBtn = By.id("submit");

    private By loginerrorMsg = By.id("error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getIncorrectPasswordmsg() {
        WebElement passwordMsg = driver.findElement(loginerrorMsg);
        return passwordMsg.getText();
    }

    public String getIncorrectUsernamemsg() {
        WebElement usernameMsg = driver.findElement(loginerrorMsg);
        return usernameMsg.getText();
    }
}
