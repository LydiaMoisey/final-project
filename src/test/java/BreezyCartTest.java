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
        driver.get(BreezyProductsPage.URL);
    }

    @Test
    public void testEmptyCart() {

        driver.findElement(By.className(BreezyProductsPage.CART)).click();

        Assertions.assertEquals(BreezyProductsPage.emptyCart,
                driver.findElement(By.xpath(BreezyProductsPage.LABEl_EMPTY_CART)).getText());

    }

    @Test
    public void testBreezyAddToCartOneItem() {

        driver.findElement(By.xpath(BreezyProductsPage.LINK_ACCESSORS)).click();
        driver.findElement(By.xpath(BreezyProductsPage.LINK_ADAPTORS)).click();
        driver.findElement(By.className(BreezyProductsPage.LINK_TO_PRODUCT)).click();
        Driver.waitForPresenceElementByClass(driver, BreezyProductsPage.LABEL_PRODUCT_NAME_IN_CARD, 5);
        String productName = driver.findElement(By.className(BreezyProductsPage.LABEL_PRODUCT_NAME_IN_CARD)).getText();
        driver.findElement(By.xpath(BreezyProductsPage.BUTTON_BUY)).click();

        Assertions.assertTrue(driver.findElement(By.xpath(BreezyProductsPage.LABEL_CART)).isDisplayed());
        Assertions.assertEquals(productName,
                driver.findElement(By.className(BreezyProductsPage.LABEL_PRODUCT_NAME_IN_CART)).getText());
    }

    @Test
    public void testBreezyAddToCartSeveralItems() {

        driver.findElement(By.xpath(BreezyProductsPage.LINK_ACCESSORS)).click();
        driver.findElement(By.xpath(BreezyProductsPage.LINK_ADAPTORS)).click();
        driver.findElement(By.className(BreezyProductsPage.LINK_TO_PRODUCT)).click();
        Driver.waitForPresenceElementByClass(driver, BreezyProductsPage.LABEL_PRODUCT_NAME_IN_CARD, 5);
        String firstItem = driver.findElement(By.className(BreezyProductsPage.LABEL_PRODUCT_NAME_IN_CARD)).getText();
        driver.findElement(By.xpath(BreezyProductsPage.BUTTON_BUY)).click();
        driver.findElement(By.className(BreezyProductsPage.BUTTON_CLOSE_CART)).click();
        driver.findElement(By.xpath(BreezyProductsPage.LINK_SCREEN_PROTECTOR)).click();
        driver.findElement(By.xpath(BreezyProductsPage.LINK_SCREEN_PROTECTOR_FOR_WATCH)).click();
        driver.findElement(By.className(BreezyProductsPage.LINK_TO_PRODUCT)).click();
        Driver.waitForPresenceElementByClass(driver, BreezyProductsPage.LABEL_PRODUCT_NAME_IN_CARD, 5);
        String secondItem = driver.findElement(By.className(BreezyProductsPage.LABEL_PRODUCT_NAME_IN_CARD)).getText();
        driver.findElement(By.xpath(BreezyProductsPage.BUTTON_BUY)).click();
        List<WebElement> productsInCart = driver.findElements(By.className(BreezyProductsPage.LABEL_PRODUCT_NAME_IN_CART));
        driver.findElement(By.xpath(BreezyProductsPage.LABEL_CART)).isDisplayed();

        Assertions.assertEquals(firstItem, productsInCart.get(0).getText());
        Assertions.assertEquals(secondItem, productsInCart.get(1).getText());

        //рассчитать цену и сумму покупок
    }

    // тест на увеличение и уменьшение товаров в корзинечерез + и -

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
