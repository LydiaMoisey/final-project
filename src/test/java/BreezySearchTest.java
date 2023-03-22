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

public class BreezySearchTest {
    WebDriver driver;
    @BeforeEach
    public void warmUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BreezySearchPage.URL);
    }

    @Test
    public void testBreezySearch() {

        driver.findElement(By.className(BreezySearchPage.SEARCH_BAR)).sendKeys(BreezySearchPage.textForSearchWithResults);
        Driver.waitForPresenceElementByClass(driver, BreezySearchPage.BUTTON_SEARCH, 2);
        driver.findElement(By.className(BreezySearchPage.BUTTON_SEARCH)).click();
        driver.findElement(By.xpath(BreezySearchPage.CHECKBOX_WIRELESS_CHARGER)).click();
        driver.findElement(By.xpath(BreezySearchPage.CHECKBOX_POWERBANK)).click();
        Driver.waitForTextPresence(driver,4,driver.findElement(By.className(BreezySearchPage.LABEL_PRODUCT_NAME)), BreezySearchPage.textForSearchWithResults);

        List<WebElement> products = driver.findElements(By.className(BreezySearchPage.LABEL_PRODUCT_NAME));
        for (WebElement product : products) {
            System.out.println(product.getText());
            Assertions.assertTrue(product.getText().toLowerCase().contains(BreezySearchPage.textForSearchWithResults),
                    "Error. No " + BreezySearchPage.textForSearchWithResults + " found.");
        }
        WebElement pagination = driver.findElement(By.xpath(BreezySearchPage.BUTTON_PAGINATION_NEXT));
        while(pagination.isDisplayed()) {
            pagination.click();

            List<WebElement> productsOnTheNextPage = driver.findElements(By.className(BreezySearchPage.LABEL_PRODUCT_NAME));
            for (WebElement product : productsOnTheNextPage) {
                Assertions.assertTrue(product.getText().toLowerCase().
                                contains(BreezySearchPage.textForSearchWithResults.toLowerCase()),
                        "Error. No " + BreezySearchPage.textForSearchWithResults + " found.");
            }
        }
    }
    @Test
    public void testBreezySearchWithoutResults() {

        driver.findElement(By.className(BreezySearchPage.SEARCH_BAR)).sendKeys(BreezySearchPage.textForSearchWithoutResults);
        driver.findElement(By.className(BreezySearchPage.SEARCH_BAR)).submit();
        Driver.waitForPresenceElementByClass(driver, BreezySearchPage.LABEL_NO_RESULTS, 2);

        Assertions.assertEquals(BreezySearchPage.noResults,
                driver.findElement(By.className(BreezySearchPage.LABEL_NO_RESULTS)).getText());
    }

    @Test
    public void testBreezyCleanSearchBar() {

        driver.findElement(By.className(BreezySearchPage.SEARCH_BAR)).sendKeys(BreezySearchPage.textForSearchWithResults);
        Driver.waitForElementToBeClickable(driver, BreezySearchPage.BUTTON_CLEAR_SEARCH, 3);
        driver.findElement(By.className(BreezySearchPage.BUTTON_CLEAR_SEARCH)).click();

        Assertions.assertTrue(driver.findElement(By.className(BreezySearchPage.SEARCH_BAR)).getText().isEmpty());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
