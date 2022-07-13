package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    private By itemSauceLabsBikeLight = By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]");
    private By checkoutButton = By.id("checkout");

    public void isItemSauceLabsBikeLightDisplayed() {
        try {
            driver.findElement(itemSauceLabsBikeLight).isDisplayed();
            System.out.println("'Sauce Labs Bike Light' is in the cart");
        } catch (Exception exception) {
            System.out.println("'Sauce Labs Bike Light' is not in the cart");
        }
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
        System.out.println("User clicks on 'Checkout' button");
    }
}
