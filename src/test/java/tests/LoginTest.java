package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] provideDiscountData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "LoginData", priority = 2,
            description = "Вход с неверными данными, проверка сообщения об ошибке",
            testName = "Негативный тест на аутентификацию",
            dependsOnMethods = "checkLogin")
    public void checkLoginWithNegativeValues(String username, String password, String expectedMessage) {
        loginPage.open();
        loginPage.login(username, password);
        assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не соответствует");
    }

    @Test(priority = 1,
            description = "Вход с корректными данными",
            testName = "Успешная аутентификация",
            groups = {"smoke"})
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
    }
}
