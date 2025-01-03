package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.qameta.allure.Step;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductsPage extends BasePage {
    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(css = ".btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Adds random product to cart")
    public void addRandomProductToCart() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, products.size());
        addToCartButtons.get(randomIndex).click();
    }

    @Step("Adds multiple products to the shopping cart")
    public void addMultipleProductsToCart(int count) {
        for (int i = 0; i < count && i < products.size(); i++) {
            addToCartButtons.get(i).click();
        }
    }

    @Step("Navigates to shopping cart page")
    public CartPage navigateToCart() {
        cartLink.click();
        return new CartPage(driver);
    }

    @Step("Logs out")
    public LoginPage logout() {

        menuButton.click();
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.click();
        return new LoginPage(driver);
    }
}