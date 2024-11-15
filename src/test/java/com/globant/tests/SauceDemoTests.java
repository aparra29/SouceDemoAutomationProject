package com.globant.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.pages.ProductsPage;
import com.globant.pages.CartPage;
import com.globant.pages.CheckoutPage;
import com.globant.pages.LoginPage;

public class SauceDemoTests extends BaseTest {
    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @Test
    public void testCompletePurchase() {
        ProductsPage productsPage = loginPage.login(USERNAME, PASSWORD);
        productsPage.addRandomProductToCart();

        CartPage cartPage = productsPage.navigateToCart();
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();

        checkoutPage.fillShippingInfo("John", "Doe", "12345");
        checkoutPage.completePurchase();

        Assert.assertTrue(checkoutPage.isOrderConfirmed(),
                "Order confirmation message should be displayed");
    }

    @Test
    public void testRemoveCartItems() {
        ProductsPage productsPage = loginPage.login(USERNAME, PASSWORD);
        productsPage.addMultipleProductsToCart(3);

        CartPage cartPage = productsPage.navigateToCart();
        cartPage.removeAllItems();

        Assert.assertTrue(cartPage.isCartEmpty(),
                "Shopping cart should be empty after removing all items");
    }

    @Test
    public void testLogout() {
        ProductsPage productsPage = loginPage.login(USERNAME, PASSWORD);
        LoginPage loginPageAfterLogout = productsPage.logout();

        Assert.assertTrue(loginPageAfterLogout.isOnLoginPage(),
                "User should be redirected to login page after logout");
    }
}
