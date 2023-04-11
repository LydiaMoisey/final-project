package by.itacademy.moiseenkolydia.breezy.ui.pages;

import by.itacademy.moiseenkolydia.breezy.ui.util.Util;
import org.openqa.selenium.By;

public class CartPage extends BasePage {
    private final By BUTTON_CART = By.className("header_cart_opener");
    private final By LABEl_EMPTY_CART =
            By.xpath("//div[@class='header_action_item header_cart']/descendant::div[@class='tooltip_title']");
    public final static By LINK_ACCESSORS = By.xpath("//a[contains(@class,'open_dropdown')]/span[text()='Аксессуары']");
    public final static By LINK_ADAPTORS = By.xpath("//a[text()='Кабели и переходники']");
    public final static By LINK_SCREEN_PROTECTOR = By.xpath("//a[contains(@class,'open_dropdown')]/span[text()='Cтекла']");
    public final static By LINK_SCREEN_PROTECTOR_FOR_WATCH = By.xpath("//a[text()='для Watch']");
    private final By LINK_TO_PRODUCT = By.className("product_name");
    private final By LABEL_PRODUCT_TITLE_IN_CARD = By.className("title");
    private final By BUTTON_BUY = By.xpath("//button[@class='button cart']");
    public final static By LABEL_PRODUCT_NAME_IN_CART = By.className("modal_item_title");
    private final By PRODUCT_PRISE =
            By.xpath("//div[@class='main price__main']/descendant::span[@class='main__value']");
    public final static By TOTAL_PRODUCT_PRICE = By.xpath("//*[@class='modal_item_side']/descendant::div[@class='modal_price_val']");
    private final By TOTAL_ORDER_SUM = By.xpath("//div[@class='modal_total_price']/span[@class='modal_price']");
    private final By BUTTON_REMOVE_ITEM = By.className("modal_remove");
    private final By BUTTON_INCREASE_PRODUCT_COUNTER = By.className("form_counter_more");
    private final By BUTTON_DECREASE_PRODUCT_COUNTER = By.className("form_counter_less");
    private final By NUMBER_OF_PRODUCTS = By.className("form_counter_input");
    private final By BUTTON_CLOSE_CART = By.className("modal_close_icon");
    public final static String EMPTY_CART = "Список заказов пуст";

    public void openCart() {
        driver.findElement(BUTTON_CART).click();
    }

    public String getLabelEmptyCart() {
        Util.waitForElementToBeVisible(driver, 3, LABEl_EMPTY_CART);
        return driver.findElement(LABEl_EMPTY_CART).getText();
    }

    public CartPage openCategory(By category, By subcategory) {
        driver.findElement(category).click();
        driver.findElement(subcategory).click();
        return this;
    }

    public void openProductCard() {
        driver.findElement(LINK_TO_PRODUCT).click();
    }

    public String getProductTitleInCard() {
        Util.waitForPresenceOfElement(driver, 5, LABEL_PRODUCT_TITLE_IN_CARD);
        return driver.findElement(LABEL_PRODUCT_TITLE_IN_CARD).getText();
    }

    public String getProductNameInCart() {
        return driver.findElement(LABEL_PRODUCT_NAME_IN_CART).getText();
    }

    public int getProductPrice() {
        Util.waitForElementToBeVisible(driver, 15, PRODUCT_PRISE);
        String[] productPrice = driver.findElement(PRODUCT_PRISE).getText().split(" ");
        return Integer.parseInt(productPrice[0]);
    }

    public int getProductTotalPriceInCart() {
        String[] totalProductPrice = driver.findElement(TOTAL_PRODUCT_PRICE).getText().split(" ");
        return Integer.parseInt(totalProductPrice[0]);
    }

    public CartPage addProductToCart() {
        driver.findElement(BUTTON_BUY).click();
        return this;
    }

    public CartPage removeProductFromCart() {
        driver.findElement(BUTTON_REMOVE_ITEM).click();
        return this;
    }

    public CartPage increaseProductCounter() {
        driver.findElement(BUTTON_INCREASE_PRODUCT_COUNTER).click();
        return this;
    }

    public void decreaseProductCounter() {
        driver.findElement(BUTTON_DECREASE_PRODUCT_COUNTER).click();
    }

    public int getTotalOrderSum() {
        String[] totalOrderSum = driver.findElement(TOTAL_ORDER_SUM).getText().split(" ");
        return Integer.parseInt(totalOrderSum[0]);
    }

    public int getAmountOfParticularProduct() {
        String counter = driver.findElement(NUMBER_OF_PRODUCTS).getAttribute("value");
        return Integer.parseInt(counter);
    }

    public void closeCart() {
        Util.waitForPresenceOfElement(driver, 4, BUTTON_CLOSE_CART);
        driver.findElement(BUTTON_CLOSE_CART).click();
    }
}
