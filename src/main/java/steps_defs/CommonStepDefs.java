package steps_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page_object.AuthorizationPage;
import page_object.CheckoutPage;
import page_object.InventoryPage;
import utils.WebDriverManager;

import java.time.Duration;

public class CommonStepDefs {
    WebDriver driver = WebDriverManager.getInstance();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    InventoryPage inventoryPage = new InventoryPage();

    CheckoutPage checkoutpage = new CheckoutPage();
    @Given("I have navigated to login page")
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @Given("I login with {string} and {string}")
    public void authorize(String username, String password) {
        authorizationPage.authorizeUser(username, password);
    }

    @Then("I am successfully logged in")
    public void checkSuccessfulLogin() {
        Assertions.assertThat(driver.getCurrentUrl()).containsIgnoringCase("inventory.html");
        System.out.println("Assertion passed. Successful login");
    }

    @Then("I see login error message {string}")
    public void checkErrorMessage(String value) {
        Assertions.assertThat(authorizationPage.getErrorField().getText()).isEqualTo(value);
    }

    @Then("I select {string} product")
    public void selectProduct(String product) {
        inventoryPage.selectProduct(product);
    }

    @Then("I click 'Add to cart' button")
    public void clickAddToCartButton() {
        inventoryPage.clickAddToCartButton();
    }

    @Then("I see shopping cart badge for one product")
    public void isShoppingCartBadgeDisplayed() {
        Assert.assertEquals(true, inventoryPage.getShoppingCartBadge().isDisplayed());
        System.out.println("Assertion passed. The one product shopping cart badge is displayed");
    }

    @Then("I click shopping cart link")
    public void clickShoppingCartLink() {
        inventoryPage.clickShoppingCartLink();
    }

    @Then("I see {string} product")
    public void verifyProduct(String product) {
        Assert.assertEquals(true, inventoryPage.verifyProduct(product).isDisplayed());
        System.out.println("Assertion passed. The '" + product + "' product is displayed");
    }

    @Then("I click 'Checkout' button")
    public void clickCheckoutButton() {
        inventoryPage.clickCheckoutButton();
    }

    @Then("I enter firstname as {string}, lastname as {string} and postal code as {string}")
    public void enterFirstnameLastnamePostalCode(String firstname, String lastname, String zipPostalCode) {
        inventoryPage.enterCheckoutInformation(firstname, lastname, zipPostalCode);
    }

    @Then("I click 'Continue' button")
    public void clickContinueButton() {
        inventoryPage.clickContinueButton();
    }

    @Then("I see {string} product in quantity of {string}")
    public void verifyOverviewInformation(String product, String quantity) {
        Assert.assertEquals(true, inventoryPage.verifyCheckoutOverviewProduct("Sauce Labs Bike Light").isDisplayed());;
        System.out.println("Assertion passed. The '" + product + "' product is displayed in CheckoutOverview information");
        Assert.assertEquals(true, inventoryPage.verifyCheckoutOverviewQuantity("1").isDisplayed());
        System.out.println("Assertion passed. The product of quantity '" + quantity + "' is displayed in CheckoutOverview information");
    }

    @Then("I click 'Finish' button")
    public void clickFinishButton() {
        inventoryPage.clickFinishButton();
    }

    @Then("I click 'Back Home' button")
    public void clickBackHomeButton() {
        inventoryPage.clickBackHomeButton();
    }

    @Then("I see error message {string}")
    public void validateErrorMessage(String errorMessage) {
        checkoutpage.getErrorMessage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(checkoutpage.getErrorMessage()));
        Assertions.assertThat(checkoutpage.getErrorMessage().getText()).isEqualTo(errorMessage);
        System.out.println("Assertion passed. The error message '" + errorMessage + "' is displayed");
    }

    @Then("I refresh the page")
    public void refresh() {
        checkoutpage.refresh();
    }

    @Then("I have successfully navigated to {string}")
    public void checkNavigationToCheckout2(String url) {
        Assertions.assertThat(driver.getCurrentUrl()).containsIgnoringCase(url);
        System.out.println("Assertion passed. Successfully navigated to Checkout 2nd step");
    }
}