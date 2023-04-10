package by.itacademy.moiseenkolydia.breezy.ui.steps;

import by.itacademy.moiseenkolydia.breezy.ui.pages.CartPage;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartSteps extends CartPage {

    public String getTextInEmptyCart() {
        openCart();
        return getLabelEmptyCart();
    }

    public boolean checkProductTitleInCart() {
        openCategory(CartPage.LINK_ACCESSORS, CartPage.LINK_ADAPTORS).
                openProductCard();
        String productTitle = getProductTitleInCard();
        addProductToCart();
        boolean productNameInCardAndCart = getProductNameInCart().equals(productTitle);
        closeCart();
        return productNameInCardAndCart;
    }

    public boolean checkProductPriceInCart() {
        openCategory(CartPage.LINK_ACCESSORS, CartPage.LINK_ADAPTORS).
                openProductCard();
        int productPrise = getProductPrice();
        addProductToCart();
        boolean productPriceInCardAndCart = (getProductTotalPriceInCart() == productPrise);
        closeCart();
        return productPriceInCardAndCart;
    }

    public boolean checkSeveralProductTitlesInCart() {
        openCategory(CartPage.LINK_SCREEN_PROTECTOR, CartPage.LINK_SCREEN_PROTECTOR_FOR_WATCH).
                openProductCard();
        String secondProductTitle = getProductTitleInCard();
        addProductToCart();
        List<WebElement> productsInCart = driver.findElements(CartPage.LABEL_PRODUCT_NAME_IN_CART);
        return secondProductTitle.equals(productsInCart.get(1).getText());
    }

    public boolean checkSeveralProductPricesInCart() {
        openCategory(CartPage.LINK_SCREEN_PROTECTOR, CartPage.LINK_SCREEN_PROTECTOR_FOR_WATCH).
                openProductCard();
        int secondProductPrice = getProductPrice();
        addProductToCart();
        List<WebElement> productsInCart = driver.findElements(CartPage.TOTAL_PRODUCT_PRICE);
        String[] secondProductPriceInCart = productsInCart.get(1).getText().split(" ");
        int PriceInCart = Integer.parseInt(secondProductPriceInCart[0]);
        return secondProductPrice == PriceInCart;
    }

    public String checkEmptyCartText() {
        openCategory(CartPage.LINK_ACCESSORS, CartPage.LINK_ADAPTORS).
                openProductCard();
        addProductToCart().
                removeProductFromCart().
                openCart();
        return getLabelEmptyCart();
    }

    public boolean checkIncreaseAmountOfProducts() {
        openCategory(CartPage.LINK_ACCESSORS, CartPage.LINK_ADAPTORS).
                openProductCard();
        int productPrise = getProductPrice();
        addProductToCart().
                increaseProductCounter().
                increaseProductCounter().
                decreaseProductCounter();
        int amountOfProducts = getAmountOfParticularProduct();
        int expectedTotalSum = productPrise * amountOfProducts;
        return expectedTotalSum == getTotalOrderSum();
    }
}
