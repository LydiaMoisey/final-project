package by.itacademy.moiseenkolydia.breezy.ui.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {
    public static void waitForPresenceElementByXPath(WebDriver driver, String xPath, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }
    public static void waitForPresenceElementByClass(WebDriver driver, String className, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
    }
    public static void waitForTextPresence(WebDriver driver, int seconds, WebElement value, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.textToBePresentInElement(value, text));
    }
    public static void waitForElementToBeClickableByClass(WebDriver driver, String className, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(By.className(className)));
    }
    public static void waitForElementToBeVisibleByXPath(WebDriver driver, String xpath, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public static void waitForElementToBeVisibleByClass(WebDriver driver, String className, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }


}
