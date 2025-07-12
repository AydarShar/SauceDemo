package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By TITLE = By.className("title");
    private final String ADD_BACKPACK_TO_CART_PATTERN = "//div[text()=\"%s\"]/ancestor::" +
            "div[@data-test='inventory-item']//button[text()='Add to cart']";
    private final By FIRST_ITEM_TITLE = By.xpath("//*[@class=\"inventory_list\"]/div[@class='inventory_item'][1]" +
            "//div[@data-test='inventory-item-name']");
    private final By FILTER_NAME_A_TO_Z = By.xpath("//select/option[1]");
    private final By FILTER_NAME_Z_TO_A = By.xpath("//select/option[2]");
    private final By FILTER_PRICE_LOW_TO_HIGH = By.xpath("//select/option[3]");
    private final By FILTER_PRICE_HIGH_TO_LOW = By.xpath("//select/option[4]");
    private final By CART = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем, что страница открыта")
    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    @Step("Нажимаем на фильтр A to Z")
    public void chooseAToZFilter() {
        driver.findElement(FILTER_NAME_A_TO_Z).click();
    }

    @Step("Нажимаем на фильтр Z to A")
    public void chooseZToAFilter() {
        driver.findElement(FILTER_NAME_Z_TO_A).click();
    }

    @Step("Нажимаем на фильтр prise low to high")
    public void choosePriseLowToHighFilter() {
        driver.findElement(FILTER_PRICE_LOW_TO_HIGH).click();
    }

    @Step("Нажимаем на фильтр prise high to low")
    public void choosePriseHighToLowFilter() {
        driver.findElement(FILTER_PRICE_HIGH_TO_LOW).click();
    }

    @Step("Берем имя первого продукта в списке продуктов")
    public String getFirstItemTitle() {
        return driver.findElement(FIRST_ITEM_TITLE).getText();
    }

    @Step("Добавляем в корзину продукт: {product}")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_BACKPACK_TO_CART_PATTERN, product))).click();
    }

    @Step("Кликнуть на иконку корзины")
    public void goToCart() {
        driver.findElement(CART).click();
    }
}
