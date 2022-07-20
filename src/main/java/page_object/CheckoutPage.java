package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

public class CheckoutPage {
    WebDriver driver = WebDriverManager.getInstance();
    private By errorMessage = By.xpath("//h3[@data-test='error']");

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
