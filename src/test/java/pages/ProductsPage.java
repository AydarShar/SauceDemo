package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By TITLE = By.className("title");
    private final By ADD_BACKPACK_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private final By FIRST_ITEM_TITLE = By.xpath("//*[@class=\"inventory_list\"]/div[@class='inventory_item'][1]//div[@data-test='inventory-item-name']");
    private final By FILTER_NAME_A_TO_Z = By.xpath("//select/option[1]");
    private final By FILTER_NAME_Z_TO_A = By.xpath("//select/option[2]");
    private final By FILTER_PRICE_LOW_TO_HIGH = By.xpath("//select/option[3]");
    private final By FILTER_PRICE_HIGH_TO_LOW = By.xpath("//select/option[4]");
    private final By CART = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public void chooseAToZFilter() {
        driver.findElement(FILTER_NAME_A_TO_Z).click();
    }

    public void chooseZToAFilter() {
        driver.findElement(FILTER_NAME_Z_TO_A).click();
    }

    public void choosePriseLowToHighFilter() {
        driver.findElement(FILTER_PRICE_LOW_TO_HIGH).click();
    }

    public void choosePriseHighToLowFilter() {
        driver.findElement(FILTER_PRICE_HIGH_TO_LOW).click();
    }

    public String getFirstItemTitle() {
        return driver.findElement(FIRST_ITEM_TITLE).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(ADD_BACKPACK_TO_CART_BUTTON).click();
    }

    public void goToCart() {
        driver.findElement(CART).click();
    }
}
