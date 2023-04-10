package by.itacademy.moiseenkolydia.breezy.ui.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Util {

    public static void waitForTextPresence(WebDriver driver, int seconds, WebElement value, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.textToBePresentInElement(value, text));
    }

    public static void waitForElementToBeVisible(WebDriver driver, int seconds, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForPresenceOfElement(WebDriver driver, int seconds, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void waitForElementWithTextInvisibility(WebDriver driver, int seconds, By element, List<WebElement> webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.invisibilityOfElementWithText
                        (element, webElement.get(0).getText()));
    }
}
