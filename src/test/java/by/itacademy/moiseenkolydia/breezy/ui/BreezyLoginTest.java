package by.itacademy.moiseenkolydia.breezy.ui;

import by.itacademy.moiseenkolydia.breezy.BreezyLoginPage;
import by.itacademy.moiseenkolydia.breezy.ui.util.Util;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BreezyLoginTest {
    WebDriver driver;
    Faker faker = new Faker();

    @BeforeEach
    public void warmUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BreezyLoginPage.URL);
    }

    @Test
    @Order(1)
    public void testBreezyLogin() {

        driver.findElement(By.className(BreezyLoginPage.ICON_PROFILE)).click();
        driver.findElement(By.xpath(BreezyLoginPage.INPUT_EMAIL)).sendKeys("99camomile99@gmail.com");
        driver.findElement(By.xpath(BreezyLoginPage.INPUT_PASSWORD)).sendKeys("Qwerty!1");
        driver.findElement(By.xpath(BreezyLoginPage.BUTTON_LOGIN)).click();
        Util.waitForPresenceElementByClass(driver, BreezyLoginPage.LABEL_EMAIL_IN_PROFILE, 2);

        Assertions.assertEquals("99camomile99@gmail.com",
                driver.findElement(By.className(BreezyLoginPage.LABEL_EMAIL_IN_PROFILE)).getText());
    }

    @Test
    public void testBreezyInvalidEmail() {

        driver.findElement(By.className(BreezyLoginPage.ICON_PROFILE)).click();
        driver.findElement(By.xpath(BreezyLoginPage.INPUT_EMAIL)).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath(BreezyLoginPage.INPUT_PASSWORD)).sendKeys("Qwerty!1");
        driver.findElement(By.xpath(BreezyLoginPage.BUTTON_LOGIN)).click();
        Util.waitForElementToBeVisibleByXPath(driver, BreezyLoginPage.ERROR_BLOCK, 3);

        Assertions.assertEquals("Неправильный логин или пароль",
                driver.findElement(By.xpath(BreezyLoginPage.ERROR_BLOCK)).getText());
    }
    @Test
    public void testBreezyInvalidPassword() {

        driver.findElement(By.className(BreezyLoginPage.ICON_PROFILE)).click();
        driver.findElement(By.xpath(BreezyLoginPage.INPUT_EMAIL)).sendKeys("99camomile99@gmail.com");
        driver.findElement(By.xpath(BreezyLoginPage.INPUT_PASSWORD)).sendKeys(faker.internet().password());
        driver.findElement(By.xpath(BreezyLoginPage.BUTTON_LOGIN)).click();
        Util.waitForElementToBeVisibleByXPath(driver, BreezyLoginPage.ERROR_BLOCK, 3);

        Assertions.assertEquals("Неправильный логин или пароль",
                driver.findElement(By.xpath(BreezyLoginPage.ERROR_BLOCK)).getText());
    }

    @Test
    public void testBreezyWithoutEmail() {

        driver.findElement(By.className(BreezyLoginPage.ICON_PROFILE)).click();
        driver.findElement(By.xpath(BreezyLoginPage.INPUT_PASSWORD)).sendKeys("Qwerty!1");
        driver.findElement(By.xpath(BreezyLoginPage.BUTTON_LOGIN)).click();
        Util.waitForElementToBeVisibleByXPath(driver, BreezyLoginPage.ERROR_BLOCK, 3);

        Assertions.assertEquals("Форма содержит ошибки:\n" +
                "- Email -- Обязательное поле", driver.findElement(By.xpath(BreezyLoginPage.ERROR_BLOCK)).getText());
    }
    @Test
    public void testBreezyWithoutPassword() {

        driver.findElement(By.className(BreezyLoginPage.ICON_PROFILE)).click();
        driver.findElement(By.xpath(BreezyLoginPage.INPUT_EMAIL)).sendKeys("99camomile99@gmail.com");
        driver.findElement(By.xpath(BreezyLoginPage.BUTTON_LOGIN)).click();
        Util.waitForElementToBeVisibleByXPath(driver, BreezyLoginPage.ERROR_BLOCK, 3);

        Assertions.assertEquals("Форма содержит ошибки:\n" +
                "- Пароль -- Обязательное поле", driver.findElement(By.xpath(BreezyLoginPage.ERROR_BLOCK)).getText());
    }

    @Test
    public void testBreezyLogout() {

        driver.findElement(By.className(BreezyLoginPage.ICON_PROFILE)).click();
        driver.findElement(By.xpath(BreezyLoginPage.INPUT_EMAIL)).sendKeys("99camomile99@gmail.com");
        driver.findElement(By.xpath(BreezyLoginPage.INPUT_PASSWORD)).sendKeys("Qwerty!1");
        driver.findElement(By.xpath(BreezyLoginPage.BUTTON_LOGIN)).click();
        Util.waitForPresenceElementByXPath(driver, BreezyLoginPage.BUTTON_LOGOUT, 3);
        driver.findElement(By.xpath(BreezyLoginPage.BUTTON_LOGOUT)).click();
        driver.findElement(By.className(BreezyLoginPage.ICON_PROFILE)).click();

        Assertions.assertEquals("Вход в личный кабинет",
                driver.findElement(By.xpath(BreezyLoginPage.LABEL_LOGIN_FORM)).getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}