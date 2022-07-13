package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By zipPostalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By errorIconForFirstName = By.xpath("//input[@class = 'input_error form_input error' and @id = 'first-name']");
    private By errorIconForLastName = By.xpath("//input[@class = 'input_error form_input error' and @id = 'last-name']");
    private By errorIconForZipPostalCode = By.xpath("//input[@class = 'input_error form_input error' and @id = 'postal-code']");
    private By errorMessage = By.xpath("//h3[@data-test='error']");
    private By menuButton = By.xpath("//button[@id = 'react-burger-menu-btn']");
    private By logoutLink = By.xpath("//a[@id = 'logout_sidebar_link']");
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInput);
    }

    public void setFirstNameInput(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getFirstNameInput()));
        getFirstNameInput().sendKeys(value);
        System.out.println("Firstname is filled");
    }

    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInput);
    }

    public void setLastNameInput(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getLastNameInput()));
        getLastNameInput().sendKeys(value);
        System.out.println("Lastname is filled");
    }

    public WebElement getZipPostalCodeInput() {
        return driver.findElement(zipPostalCodeInput);
    }

    public void setZipPostalCodeInput(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getZipPostalCodeInput()));
        getZipPostalCodeInput().sendKeys(value);
        System.out.println("Postal code is filled");
    }

    public void clickContinueButton() {
        WebElement element = driver.findElement(continueButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        System.out.println("User clicks on 'Continue' button");
    }

    public void clearAllFields() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getFirstNameInput()));
        getFirstNameInput().clear();
        wait.until(ExpectedConditions.visibilityOf(getLastNameInput()));
        getLastNameInput().clear();
        wait.until(ExpectedConditions.visibilityOf(getZipPostalCodeInput()));
        getZipPostalCodeInput().clear();

    }

    public void refresh() {
        driver.navigate().refresh();
        System.out.println("The browser has been refreshed. All fields are cleared");
    }

    public void isErrorIconForFirstNameDisplayed() {
        try {
            driver.findElement(errorIconForFirstName).isDisplayed();
            System.out.println("The error icon on 'Firstname' is displayed");
        } catch (Exception exception) {
            System.out.println("The error icon on 'Firstname' is not displayed");
        }
    }

    public void isErrorIconForLastNameDisplayed() {
        try {
            driver.findElement(errorIconForLastName).isDisplayed();
            System.out.println("The error icon on 'Lastname' is displayed");
        } catch (Exception exception) {
            System.out.println("The error icon on 'Lastname' is not displayed");
        }
    }

    public void isErrorIconForZipPostalCodeDisplayed() {
        try {
            driver.findElement(errorIconForZipPostalCode).isDisplayed();
            System.out.println("The error icon on 'Postal code' is displayed");
        } catch (Exception exception) {
            System.out.println("The error icon on 'Postal code' is not displayed");
        }
    }

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }

    public void isErrorButtonDisplayed() {
        try {
            getErrorMessage().isDisplayed();
            System.out.println("The error button is displayed");
        } catch (Exception exception) {
            System.out.println("The error button is not displayed");
        }
    }

    public void errorMessageText(String expectedMessageText) {
        String actualMessageText = getErrorMessage().getText();
        Assert.assertEquals(actualMessageText, expectedMessageText);
        System.out.println("The error message is: '" + actualMessageText + "'");
    }

    public WebElement getMenuButton() {
        return driver.findElement(menuButton);
    }

    public void openMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(getMenuButton()));
        getMenuButton().click();
        System.out.println("User clicks on 'Menu' button");
    }

    public WebElement getLogoutLink() {
        return driver.findElement(logoutLink);
    }

    public void clickLogoutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(getLogoutLink()));
        getLogoutLink().click();
        System.out.println("User clicks on 'Logout' link");
    }
}
