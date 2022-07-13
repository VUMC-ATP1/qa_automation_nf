package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {
    private WebDriver driver;
    WebDriverWait wait;
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemQuantity = By.xpath("//span[contains(@class, 'shopping_cart_badge') and contains(text(), '1')]");
    private By itemSauceLabsBikeLight = By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]");
    private By itemPrice = By.xpath("//div[contains(@class, 'inventory_item_price')]");
    private By finishButton = By.id("finish");

    public void getItemQuantity() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(itemQuantity)));
        System.out.println("The quantity of item: 1");
    }

    public void getItemSauceLabsBikeLight() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(itemSauceLabsBikeLight)));
        System.out.println("The 'Sauce Labs Bike Light' is selected");
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
        System.out.println("User click on 'Finish' button");
    }
}