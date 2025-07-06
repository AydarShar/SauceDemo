package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class LocatorsTest {

    @Test(description = "Разновидности локаторов", testName = "Локаторы")
    public void locatorsTest() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.tagName("form"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.linkText("About"));
        driver.findElement(By.partialLinkText("Reset"));

        driver.findElement(By.xpath("//div[@data-test='secondary-header']"));
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        driver.findElement(By.xpath("//a[contains(@class, 'shopping_cart_link')]"));
        driver.findElement(By.xpath("//div[contains(text(), 'Backpack')]"));
        driver.findElement(By.xpath("//select//ancestor::span"));
        driver.findElement(By.xpath("//div[@class='header_secondary_container']//descendant::span"));
        driver.findElement(By.xpath("//div[@class='header_label']/following::div[1]"));
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']//parent::*"));
        driver.findElement(By.xpath("//div[@class='app_logo']//preceding::a[1]"));
        driver.findElement(By.xpath("//span[@class='title' and text()='Products']"));

        driver.findElement(By.cssSelector(".app_logo"));
        driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
        driver.findElement(By.cssSelector(".pricebar .inventory_item_price"));
        driver.findElement(By.cssSelector("#shopping_cart_container"));
        driver.findElement(By.cssSelector("select"));
        driver.findElement(By.cssSelector("div.inventory_list"));
        driver.findElement(By.cssSelector("[data-test=title]"));
        driver.findElement(By.cssSelector("[class~=btn_small]"));
        driver.findElement(By.cssSelector("[data-test|=active]"));
        driver.findElement(By.cssSelector("[class^=social]"));
        driver.findElement(By.cssSelector("[src$='.jpg']"));
        driver.findElement(By.cssSelector("[alt*=Bolt]"));
        driver.quit();
    }
}
