package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutSuccessPage {
    private WebDriver driver;
    WebDriverWait wait;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }
    private By checkoutCompletedInfo = By.xpath("//span[contains(@class, 'title')]");
    private By backHomeButton = By.id("back-to-products");

    public void getCheckoutCompletedInfo() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(checkoutCompletedInfo)));
        System.out.println("Checkout completed successfully");
    }
    public void clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
    }
}
