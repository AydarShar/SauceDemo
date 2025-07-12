package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By ITEM_NAME = By.className("inventory_item_name");
    private final By ITEM_PRICE = By.className("inventory_item_price");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }
}
