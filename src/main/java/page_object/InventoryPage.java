package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

public class InventoryPage {
    WebDriver driver = WebDriverManager.getInstance();
    private By productSauceLabsBikeLight = By.xpath("//div[@class = 'inventory_item_name' and text() = 'Sauce Labs Bike Light']");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By shoppingCartLink = By.xpath("//a[contains(@class, 'shopping_cart_link')]");
    private By shoppingCartBadge = By.xpath("//span[contains(@class, 'shopping_cart_badge')]");
    private By oneProductShoppingCartBadge = By.xpath("//span[contains(@class, 'shopping_cart_badge') and contains(text(), '1')]");
    private By checkoutButton = By.id("checkout");
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By zipPostalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By backHomeButton = By.id("back-to-products");

    public void selectProduct(String product) {
        //driver.findElement(productSauceLabsBikeLight).click();
        driver.findElement(By.xpath("//div[@class = 'inventory_item_name' and text() = '" + product + "']")).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public WebElement getShoppingCartBadge() {
        return driver.findElement(oneProductShoppingCartBadge);
    }

    public void clickShoppingCartLink() {
        driver.findElement(shoppingCartLink).click();
    }

    public WebElement verifyProduct(String product) {
        return driver.findElement(By.xpath("//div[@class = 'inventory_item_name' and text() ='" + product + "']"));
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void enterCheckoutInformation(String firstname, String lastname, String zipPostalCode) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstname);
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastname);
        driver.findElement(zipPostalCodeInput).clear();
        driver.findElement(zipPostalCodeInput).sendKeys(zipPostalCode);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public WebElement verifyCheckoutOverviewProduct(String product) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + product + "')]"));
    }

    public WebElement verifyCheckoutOverviewQuantity(String quantity) {
        return driver.findElement(By.xpath("//span[contains(@class, 'shopping_cart_badge') and contains(text(), '" + quantity + "')]"));
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    public void clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
    }
}
