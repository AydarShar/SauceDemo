package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void filterFromZToATest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.chooseZToAFilter();
        assertEquals(productsPage.getFirstItemTitle(), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void filterPriseLowToHighTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.choosePriseLowToHighFilter();
        assertEquals(productsPage.getFirstItemTitle(), "Sauce Labs Onesie");
    }

    @Test
    public void filterPriseHighToLowTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.choosePriseHighToLowFilter();
        assertEquals(productsPage.getFirstItemTitle(), "Sauce Labs Fleece Jacket");
    }

    @Test
    public void filterFromAToZTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.chooseAToZFilter();
        assertEquals(productsPage.getFirstItemTitle(), "Sauce Labs Backpack");
    }
}
