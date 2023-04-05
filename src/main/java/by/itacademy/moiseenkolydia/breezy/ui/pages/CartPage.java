package by.itacademy.moiseenkolydia.breezy.ui.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {
    private final By BUTTON_CART = By.className("header_cart_opener");
    private final By LABEl_EMPTY_CART =
            By.xpath("//div[@class='header_action_item header_cart']/descendant::div[@class='tooltip_title']");
    private final static String EMPTY_CART = "Список заказов пуст";
    private final By LINK_ACCESSORS = By.xpath("//a[contains(@class,'open_dropdown')]/span[text()='Аксессуары']");
    private final By LINK_ADAPTORS = By.xpath("//a[text()='Кабели и переходники']");
    private final By LINK_SCREEN_PROTECTOR = By.xpath("//a[contains(@class,'open_dropdown')]/span[text()='Cтекла']");
    private final By LINK_SCREEN_PROTECTOR_FOR_WATCH = By.xpath("//a[text()='для Watch']");
    private final By LINK_TO_PRODUCT = By.className("product_name");
    private final By LABEL_PRODUCT_TITLE_IN_CARD = By.className("title");
    private final By BUTTON_BUY = By.xpath("//button[@class='button cart']");
    private final By LABEL_CART = By.xpath("//div[contains(text(),'Корзина')]");
    private final By LABEL_PRODUCT_NAME_IN_CART = By.className("modal_item_title");
    private final By PRODUCT_PRISE =
            By.xpath("//div[@class='main price__main']/descendant::span[@class='main__value']");
    private final By TOTAL_PRICE = By.xpath("//div[@class='modal_total_price']/span[@class='modal_price']");
    private final By BUTTON_REMOVE_ITEM = By.className("modal_remove");
    private final By BUTTON_INCREASE_PRODUCT_COUNTER = By.className("form_counter_more");
    private final By BUTTON_DECREASE_PRODUCT_COUNTER = By.className("form_counter_less");
    private final By NUMBER_OF_PRODUCTS = By.className("form_counter_input");
    private final By BUTTON_CLOSE_CART = By.className("modal_close_icon");

    public String isCartEmpty() {
        return driver.findElement(LABEl_EMPTY_CART).getText();
    }

    public void openCategory(By category, By subcategory) {
        driver.findElement(category).click();
        driver.findElement(subcategory).click();
    }

    public String getProductName() {
        return driver.findElement(LABEL_PRODUCT_TITLE_IN_CARD).getText();
    }

    public int getProductPrice() {
        String[] productPrice = driver.findElement(PRODUCT_PRISE).getText().split(" ");
        return Integer.valueOf(productPrice[0]);
    }

    public void addProductToCart() {
        driver.findElement(BUTTON_BUY).click();
    }

    public void removeProductFromCart() {
        driver.findElement(BUTTON_REMOVE_ITEM).click();
    }

    public int getTotalPrice() {
        String[] totalPrice = driver.findElement(TOTAL_PRICE).getText().split(" ");
        return Integer.valueOf(totalPrice[0]);
    }

    public int getAmountOfParticularProduct() {
        String counter = driver.findElement(NUMBER_OF_PRODUCTS).getAttribute("value");
        return Integer.parseInt(counter);
    }

    public void closeCart() {
        driver.findElement(BUTTON_CLOSE_CART).click();
    }
}
