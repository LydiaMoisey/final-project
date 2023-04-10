package by.itacademy.moiseenkolydia.breezy.ui.pages;

import by.itacademy.moiseenkolydia.breezy.ui.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    private final By SEARCH_BAR = By.className("header_search_input");
    private final By BUTTON_SEARCH = By.className("header_search_seaction_btn");
    private final By BUTTON_CLEAR_SEARCH = By.className("header_search_seaction_close");
    public final By CHECKBOX_WIRELESS_CHARGER = By.xpath("//input[@value='35']");
    public final By CHECKBOX_POWERBANK = By.xpath("//input[@value='45']");
    private final static By LABEL_PRODUCT_NAME = By.className("product_name");
    private final static By BUTTON_PAGINATION_NEXT = By.xpath("//div[contains(@class, 'pagination_arrow_next')]");
    private final By LABEL_NO_RESULTS = By.className("search_page_no_result");
    public final static String PRODUCT_FOR_SEARCH_WITH_RESULTS = "зарядное устройство";
    public final static String PRODUCT_FOR_SEARCH_WITHOUT_RESULTS = "магнитофон";
    public final static String NO_RESULTS =
            String.format("%s%s%s\n%s", "По вашему запросу ничего не найдено (", PRODUCT_FOR_SEARCH_WITHOUT_RESULTS,
                    ")", "Попробуйте сократить запрос или задать его по-другому. Убедитесь, что название бренда и модели написано правильно.");
    static List<String> productNameList;

    public SearchPage enterProductToSearchBar(String product) {
        driver.findElement(SEARCH_BAR).sendKeys(product);
        return this;
    }

    public SearchPage searchProduct(String product) {
        driver.findElement(SEARCH_BAR).sendKeys(product);
        driver.findElement(BUTTON_SEARCH).submit();
        return this;
    }

    public void clearSearchBar() {
        Util.waitForElementToBeVisible(driver, 2, BUTTON_CLEAR_SEARCH);
        driver.findElement(BUTTON_CLEAR_SEARCH).click();
    }

    public String getTextFromSearchBar() {
        return driver.findElement(SEARCH_BAR).getText();
    }

    public String getNoResultsText() {
        Util.waitForElementToBeVisible(driver, 2, LABEL_NO_RESULTS);
        return driver.findElement(LABEL_NO_RESULTS).getText();
    }

    public SearchPage selectFilterOption(By option) {
        Util.waitForPresenceOfElement(driver, 3, option);
        driver.findElement(option).click();
        return this;
    }

    public static List<String> getProductNamesOnPage() {
        Util.waitForTextPresence(driver, 2,
                driver.findElement(LABEL_PRODUCT_NAME), PRODUCT_FOR_SEARCH_WITH_RESULTS);
        productNameList = new ArrayList<>();
        List<WebElement> products = driver.findElements(LABEL_PRODUCT_NAME);

        for (WebElement product : products) {
            productNameList.add(product.getText().toLowerCase());
        }
        while (driver.findElements(BUTTON_PAGINATION_NEXT).size() > 0) {
            driver.findElement(BUTTON_PAGINATION_NEXT).click();
            Util.waitForElementWithTextInvisibility(driver, 6, LABEL_PRODUCT_NAME, products);
            List<WebElement> productsOnTheNextPage = driver.findElements(LABEL_PRODUCT_NAME);
            for (WebElement product : productsOnTheNextPage) {
                productNameList.add(product.getText().toLowerCase());
            }
        }
        return productNameList;
    }

    public static boolean isSearchResultListContainsProductName(String productName) {
        if (productNameList == null) {
            productNameList = getProductNamesOnPage();
        }
        return productNameList.stream().anyMatch(s -> s.contains(productName));
    }
}
