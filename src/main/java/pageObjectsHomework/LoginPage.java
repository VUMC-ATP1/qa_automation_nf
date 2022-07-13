package pageObjectsHomework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//div[contains(@class, 'error-message-container error')]");

    public WebElement getUsernameInput() {
        return driver.findElement(userNameInput);
    }
    public void setUsernameInput(String value) {
        getUsernameInput().clear();
        getUsernameInput().sendKeys(value);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInput);
    }
    public void setPasswordInput(String value) {
        getPasswordInput().clear();
        getPasswordInput().sendKeys(value);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void isErrorMessageDisplayed() throws Exception {
        try {
            driver.findElement(errorMessage).isDisplayed();
            System.out.println("Incorrect username or password are provided");
        } catch (Exception exception) {
            System.out.println("User logs in successfully");
        }
    }
}