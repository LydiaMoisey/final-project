package by.itacademy.moiseenkolydia.breezy.ui;

import by.itacademy.moiseenkolydia.breezy.BreezyCartPage;
import by.itacademy.moiseenkolydia.breezy.ui.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class BreezyCartTest {
    WebDriver driver;

    @BeforeEach
    public void warmUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BreezyCartPage.URL);
    }

    @Test
    public void testEmptyCart() {

        driver.findElement(By.className(BreezyCartPage.BUTTON_CART)).click();

        Assertions.assertEquals(BreezyCartPage.emptyCart,
                driver.findElement(By.xpath(BreezyCartPage.LABEl_EMPTY_CART)).getText());

    }

    @Test
    public void testBreezyAddToCartOneItem() {

        driver.findElement(By.xpath(BreezyCartPage.LINK_ACCESSORS)).click();
        driver.findElement(By.xpath(BreezyCartPage.LINK_ADAPTORS)).click();
        driver.findElement(By.className(BreezyCartPage.LINK_TO_PRODUCT)).click();
        Util.waitForPresenceElementByClass(driver, BreezyCartPage.LABEL_PRODUCT_TITLE_IN_CARD, 5);
        String productName = driver.findElement(By.className(BreezyCartPage.LABEL_PRODUCT_TITLE_IN_CARD)).getText();
        driver.findElement(By.xpath(BreezyCartPage.BUTTON_BUY)).click();

        Assertions.assertTrue(driver.findElement(By.xpath(BreezyCartPage.LABEL_CART)).isDisplayed());
        Assertions.assertEquals(productName,
                driver.findElement(By.className(BreezyCartPage.LABEL_PRODUCT_NAME_IN_CART)).getText());
    }

    @Test
    public void testBreezyAddToCartSeveralItems() {

        driver.findElement(By.xpath(BreezyCartPage.LINK_ACCESSORS)).click();
        driver.findElement(By.xpath(BreezyCartPage.LINK_ADAPTORS)).click();
        driver.findElement(By.className(BreezyCartPage.LINK_TO_PRODUCT)).click();
        Util.waitForPresenceElementByClass(driver, BreezyCartPage.LABEL_PRODUCT_TITLE_IN_CARD, 5);
        String firstItem = driver.findElement(By.className(BreezyCartPage.LABEL_PRODUCT_TITLE_IN_CARD)).getText();
        String[] firstPrice = driver.findElement(By.xpath(BreezyCartPage.PRODUCT_PRISE)).getText().split(" ");
        int newPrice = Integer.parseInt(firstPrice[0]);
        driver.findElement(By.xpath(BreezyCartPage.BUTTON_BUY)).click();
        driver.findElement(By.className(BreezyCartPage.BUTTON_CLOSE_CART)).click();
        driver.findElement(By.xpath(BreezyCartPage.LINK_SCREEN_PROTECTOR)).click();
        driver.findElement(By.xpath(BreezyCartPage.LINK_SCREEN_PROTECTOR_FOR_WATCH)).click();
        driver.findElement(By.className(BreezyCartPage.LINK_TO_PRODUCT)).click();
        Util.waitForPresenceElementByClass(driver, BreezyCartPage.LABEL_PRODUCT_TITLE_IN_CARD, 5);
        String secondItem = driver.findElement(By.className(BreezyCartPage.LABEL_PRODUCT_TITLE_IN_CARD)).getText();
        String[] secondPrice = driver.findElement(By.xpath(BreezyCartPage.PRODUCT_PRISE)).getText().split(" ");
        int newPrice2 = Integer.parseInt(secondPrice[0]);
        driver.findElement(By.xpath(BreezyCartPage.BUTTON_BUY)).click();
        List<WebElement> productsInCart = driver.findElements(By.className(BreezyCartPage.LABEL_PRODUCT_NAME_IN_CART));
        int sum = newPrice + newPrice2;
        String[] fullPrice = driver.findElement(By.xpath(BreezyCartPage.TOTAL_PRICE)).getText().split(" ");
        int totalSum = Integer.parseInt(fullPrice[0]);

        Assertions.assertTrue(driver.findElement(By.xpath(BreezyCartPage.LABEL_CART)).isDisplayed());
        Assertions.assertEquals(sum, totalSum);
        Assertions.assertEquals(firstItem, productsInCart.get(0).getText());
        Assertions.assertEquals(secondItem, productsInCart.get(1).getText());
    }

    @Test
    public void testBreezyCleanCart() {

        driver.findElement(By.xpath(BreezyCartPage.LINK_ACCESSORS)).click();
        driver.findElement(By.xpath(BreezyCartPage.LINK_ADAPTORS)).click();
        driver.findElement(By.className(BreezyCartPage.LINK_TO_PRODUCT)).click();
        Util.waitForPresenceElementByClass(driver, BreezyCartPage.LABEL_PRODUCT_TITLE_IN_CARD, 5);
        driver.findElement(By.xpath(BreezyCartPage.BUTTON_BUY)).click();
        driver.findElement(BreezyCartPage.BUTTON_REMOVE_ITEM).click();
        driver.findElement(By.className(BreezyCartPage.BUTTON_CART)).click();

        Assertions.assertEquals(BreezyCartPage.emptyCart,
                driver.findElement(By.xpath(BreezyCartPage.LABEl_EMPTY_CART)).getText());
    }

    @Test
    public void testBreezyIncreaseAmountOfProduct() {

        driver.findElement(By.xpath(BreezyCartPage.LINK_ACCESSORS)).click();
        driver.findElement(By.xpath(BreezyCartPage.LINK_ADAPTORS)).click();
        driver.findElement(By.className(BreezyCartPage.LINK_TO_PRODUCT)).click();
        Util.waitForPresenceElementByClass(driver, BreezyCartPage.LABEL_PRODUCT_TITLE_IN_CARD, 5);
        String[] firstPrice = driver.findElement(By.xpath(BreezyCartPage.PRODUCT_PRISE)).getText().split(" ");
        int newPrice = Integer.parseInt(firstPrice[0]);
        driver.findElement(By.xpath(BreezyCartPage.BUTTON_BUY)).click();
        driver.findElement(By.className(BreezyCartPage.BUTTON_INCREASE_PRODUCT_COUNTER)).click();
        driver.findElement(By.className(BreezyCartPage.BUTTON_INCREASE_PRODUCT_COUNTER)).click();
        driver.findElement(By.className(BreezyCartPage.BUTTON_DECREASE_PRODUCT_COUNTER)).click();
        int number = Integer.parseInt(driver.findElement(By.className(BreezyCartPage.NUMBER_OF_PRODUCTS)).getAttribute("value"));
        int sum = newPrice * number;
        String[] fullPrice = driver.findElement(By.xpath(BreezyCartPage.TOTAL_PRICE)).getText().split(" ");
        int totalSum = Integer.parseInt(fullPrice[0]);

        Assertions.assertEquals(sum, totalSum);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
