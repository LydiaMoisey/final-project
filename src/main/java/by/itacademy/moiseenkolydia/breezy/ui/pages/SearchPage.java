package by.itacademy.moiseenkolydia.breezy.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    private final By SEARCH_BAR = By.className("header_search_input");
    private final By BUTTON_SEARCH = By.className("header_search_seaction_btn");
    private final By BUTTON_CLEAR_SEARCH = By.className("header_search_seaction_close");
    private final static String PRODUCT_FOR_SEARCH_WITH_RESULTS = "зарядное устройство";
    private final static String PRODUCT_FOR_SEARCH_WITHOUT_RESULTS = "магнитофон";
    private final By CHECKBOX_WIRELESS_CHARGER = By.xpath("//input[@value='35']");
    private final By CHECKBOX_POWERBANK = By.xpath("//input[@value='45']");
    private final By LABEL_PRODUCT_NAME = By.className("product_name");
    private final By BUTTON_PAGINATION_NEXT = By.xpath("//div[contains(@class, 'pagination_arrow_next')]");
    private final By LABEL_NO_RESULTS = By.className("search_page_no_result");
    private final static String NO_RESULTS = String.format("%s%s%s\n%s", "По вашему запросу ничего не найдено (", PRODUCT_FOR_SEARCH_WITHOUT_RESULTS, ")", "Попробуйте сократить запрос или задать его по-другому. Убедитесь, что название бренда и модели написано правильно.");

    public void searchProduct(String product) {
        driver.findElement(SEARCH_BAR).sendKeys(product);
        driver.findElement(BUTTON_SEARCH).submit();
    }

    public void clearSearchBar() {
        driver.findElement(BUTTON_CLEAR_SEARCH).click();
    }

    public ArrayList<String> checkProductNamesOnPage() {
        ArrayList<String> productName = new ArrayList<>();
        List<WebElement> products = driver.findElements(LABEL_PRODUCT_NAME);

        for (WebElement product : products) {
            productName.add(product.getText().toLowerCase());
        }
        while (driver.findElements(BUTTON_PAGINATION_NEXT).size() > 0) {
            driver.findElement(BUTTON_PAGINATION_NEXT).click();
            new WebDriverWait(driver, Duration.ofSeconds(6))
                    .until(ExpectedConditions.invisibilityOfElementWithText
                            (LABEL_PRODUCT_NAME, products.get(0).getText()));
            List<WebElement> productsOnTheNextPage = driver.findElements(LABEL_PRODUCT_NAME);
            for (WebElement product : productsOnTheNextPage) {
                productName.add(product.getText().toLowerCase());
            }
        }
        return productName;
    }
}
