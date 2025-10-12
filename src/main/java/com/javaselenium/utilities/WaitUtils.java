package com.javaselenium.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitUtils {

    private WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 10; // seconds
    private static final int DEFAULT_POLLING = 500; // milliseconds

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Generic FluentWait setup
     */
    private FluentWait<WebDriver> getWait(int timeoutInSeconds) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(DEFAULT_POLLING))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class);
    }

    /**
     * Wait until element is visible
     */
    public WebElement waitForVisibility(By locator) {
        return getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait until element is clickable
     */
    public WebElement waitForClickable(By locator) {
        return getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Wait until element is present in the DOM
     */
    public WebElement waitForPresence(By locator) {
        return getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Wait until element is invisible (useful for loaders/spinners)
     */
    public boolean waitForInvisibility(By locator) {
        return getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Wait until custom condition returns true
     */
    public <T> T waitUntil(Function<WebDriver, T> condition, int timeoutInSeconds) {
        return getWait(timeoutInSeconds).until(condition);
    }

    /**
     * Example of dynamic wait for custom text to appear
     */
    public boolean waitForTextToBePresent(By locator, String text) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
}
