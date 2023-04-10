package by.itacademy.moiseenkolydia.breezy.ui;

import by.itacademy.moiseenkolydia.breezy.ui.pages.CartPage;
import by.itacademy.moiseenkolydia.breezy.ui.steps.CartSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {
    CartSteps steps = new CartSteps();

    @Test
    @DisplayName("Check if the cart is empty")
    public void testIsCartEmpty() {
        Assertions.assertEquals(CartPage.EMPTY_CART, steps.getTextInEmptyCart());
    }

    @Test
    @DisplayName("Check the name of one product in the cart")
    public void testOneProductTitleInCart() {
        Assertions.assertTrue(steps.checkProductTitleInCart());
    }

    @Test
    @DisplayName("Check the price of one product in the cart")
    public void testOneProductPriceInCart() {
        Assertions.assertTrue(steps.checkProductPriceInCart());
    }

    @Test
    @DisplayName("Check the names of several products in the cart")
    public void testSeveralProductTitlesInCart() {
        Assertions.assertTrue(steps.checkProductTitleInCart());
        Assertions.assertTrue(steps.checkSeveralProductTitlesInCart());
    }

    @Test
    @DisplayName("Check the prices of several products in the cart")
    public void testSeveralProductPricesInCart() {
        Assertions.assertTrue(steps.checkProductPriceInCart());
        Assertions.assertTrue(steps.checkSeveralProductPricesInCart());
    }

    @Test
    @DisplayName("Check if the cart is empty after cleaning")
    public void testIsCartEmptyAfterCleaning() {
        Assertions.assertEquals(CartPage.EMPTY_CART, steps.checkEmptyCartText());
    }

    @Test
    @DisplayName("Check the total sum after increasing and decreasing amount of products")
    public void testIsTotalSumCorrectAfterIncreasing() {
        Assertions.assertTrue(steps.checkIncreaseAmountOfProducts());
    }
}
