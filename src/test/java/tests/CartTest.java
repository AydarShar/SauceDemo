package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test(priority = 1,
            description = "Проверка перехода на страницу корзины со страницы продуктов",
            testName = "Переход на страницу корзины",
            groups = {"smoke"})
    public void cartTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.goToCart();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }

    @Test(priority = 2,
            description = "Проверка добавления рюкзака в корзину",
            testName = "Добавление рюкзака в корзину",
            dependsOnMethods = "cartTest")
    public void addBackpackToCartTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.goToCart();
        assertEquals(cartPage.getItemName(), "Sauce Labs Backpack");
        assertEquals(cartPage.getItemPrice(), "$29.99");
    }
}
