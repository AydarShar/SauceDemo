package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(priority = 1,
            description = "Проверка фильтра по названию продукта от конца алфавита к началу",
            testName = "Проверка фильтра Z to A",
            groups = {"smoke"})
    public void filterFromZToATest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.chooseZToAFilter();
        assertEquals(productsPage.getFirstItemTitle(), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test(priority = 2,
            description = "Проверка фильтра по цене продукта от низкой в высокой",
            testName = "Проверка фильтра prise low to high")
    public void filterPriseLowToHighTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.choosePriseLowToHighFilter();
        assertEquals(productsPage.getFirstItemTitle(), "Sauce Labs Onesie");
    }

    @Test(priority = 2,
            description = "Проверка фильтра по цене продукта от высокой к низкой",
            testName = "Проверка фильтра prise high to low")
    public void filterPriseHighToLowTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.choosePriseHighToLowFilter();
        assertEquals(productsPage.getFirstItemTitle(), "Sauce Labs Fleece Jacket");
    }

    @Test(priority = 2,
            description = "Проверка фильтра по названию продукта от начала алфавита к концу",
            testName = "Проверка фильтра A to Z")
    public void filterFromAToZTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.chooseAToZFilter();
        assertEquals(productsPage.getFirstItemTitle(), "Sauce Labs Backpack");
    }
}
