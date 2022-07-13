package seleniumHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class sauceDemoTests {
    ChromeDriver driver;
    WebDriverWait wait;

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;

    private final String SAUCEDEMO_URL = "https://www.saucedemo.com/";
    private final String LOGIN_SAUCEDEMO_URL = "https://www.saucedemo.com/inventory.html";

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowserAndLogin() {
        log.info("Initializing ChromeDriver");
        driver = new ChromeDriver();
        driver.get(SAUCEDEMO_URL);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutSuccessPage = new CheckoutSuccessPage(driver);

        // Page validation
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
        Assert.assertEquals(driver.getCurrentUrl(), SAUCEDEMO_URL);
    }

    @Test
    public void firstScenarioTest() throws Exception {
        /*
        1. Navigēt uz saiti https://www.saucedemo.com/  - @BeforeMethod
        2. Ielogoties ar pareizu lietotāja vārdu/paroli
        3. Pārbaudīt, ka lietotājs ir ielogojies
        4. Ievietot Grozā 1 produktu
        5. Doties uz grozu
        6. Pārbaudīt, kā šī prece ir grozā
        7. Doties uz Checkout
        8. Ievadīt vārdu/uzvārdu/pasta indeksu
        9. Doties uz Checkout overview lapu, pārbaudīt datus
        10. Doties uz finish lapu un pārbaudīt vai viss bija veiksmīgi
        11. Doties atpakaļ uz pirmo lapu ar pogu 'Back Home'
         */

        System.out.println("Test scenario 1:");
        // Login with correct username and password
        loginPage.setUsernameInput("standard_user");
        loginPage.setPasswordInput("secret_sauce");
        loginPage.clickLoginButton();

        // Check if user logs in successfully
        loginPage.isErrorMessageDisplayed();
        //Assert.assertEquals(driver.getCurrentUrl(), LOGIN_SAUCEDEMO_URL);

        inventoryPage.isShoppingCartBadgeDisplayed();
        inventoryPage.selectProductSauceLabsBikeLight();
        inventoryPage.clickAddToCartButton();
        inventoryPage.isShoppingCartBadgeDisplayed();
        inventoryPage.clickShoppingCartLink();

        cartPage.isItemSauceLabsBikeLightDisplayed();
        cartPage.clickCheckoutButton();

        checkoutPage.clearAllFields();
        checkoutPage.setFirstNameInput("Jānis");
        checkoutPage.setLastNameInput("Bērziņš");
        checkoutPage.setZipPostalCodeInput("LV-1234");
        checkoutPage.clickContinueButton();

        checkoutOverviewPage.getItemSauceLabsBikeLight();
        checkoutOverviewPage.getItemQuantity();
        checkoutOverviewPage.clickFinishButton();

        checkoutSuccessPage.getCheckoutCompletedInfo();
        checkoutSuccessPage.clickBackHomeButton();
    }

    @Test
    public void secondScenarioTest() {
        /*
        1. Navigēt uz saiti https://www.saucedemo.com/  @BeforeMethod
        2. Ielogoties ar pareizu lietotāja vārdu/paroli
        3. Doties uz grozu
        4. Doties uz Checkout
        5. Pārbaudīt, ka FirstName/LastName/Zip code ir obligāts
        6. Pārbaudīt, ka forma parāda pareizu kļūdas paziņojumu pie katra neievadītā lauka
         */

        System.out.println("Test scenario 2:");
        loginPage.setUsernameInput("standard_user");
        loginPage.setPasswordInput("secret_sauce");
        loginPage.clickLoginButton();

        inventoryPage.clickShoppingCartLink();

        cartPage.clickCheckoutButton();

        // Required fields validation
        // All fields are empty
        checkoutPage.refresh();
        checkoutPage.clickContinueButton();
        checkoutPage.isErrorIconForFirstNameDisplayed();
        checkoutPage.isErrorIconForLastNameDisplayed();
        checkoutPage.isErrorIconForZipPostalCodeDisplayed();
        checkoutPage.isErrorButtonDisplayed();
        checkoutPage.errorMessageText("Error: First Name is required");

        // Only Firstname is empty
        checkoutPage.refresh();
        checkoutPage.setLastNameInput("Bērziņš");
        checkoutPage.setZipPostalCodeInput("LV-1234");
        checkoutPage.clickContinueButton();
        checkoutPage.isErrorIconForFirstNameDisplayed();
        checkoutPage.isErrorIconForLastNameDisplayed();
        checkoutPage.isErrorIconForZipPostalCodeDisplayed();
        checkoutPage.isErrorButtonDisplayed();
        checkoutPage.errorMessageText("Error: First Name is required");

        // Only Lastname is empty
        checkoutPage.refresh();
        checkoutPage.setFirstNameInput("Jānis");
        checkoutPage.setZipPostalCodeInput("LV-1234");
        checkoutPage.clickContinueButton();
        checkoutPage.isErrorIconForFirstNameDisplayed();
        checkoutPage.isErrorIconForLastNameDisplayed();
        checkoutPage.isErrorIconForZipPostalCodeDisplayed();
        checkoutPage.isErrorButtonDisplayed();
        checkoutPage.errorMessageText("Error: Last Name is required");

        // Only Postal code is empty
        checkoutPage.refresh();
        checkoutPage.setFirstNameInput("Jānis");
        checkoutPage.setLastNameInput("Bērziņš");
        checkoutPage.clickContinueButton();
        checkoutPage.isErrorIconForFirstNameDisplayed();
        checkoutPage.isErrorIconForLastNameDisplayed();
        checkoutPage.isErrorIconForZipPostalCodeDisplayed();
        checkoutPage.isErrorButtonDisplayed();
        checkoutPage.errorMessageText("Error: Postal Code is required");

        // All fields are filled
        checkoutPage.refresh();
        checkoutPage.setFirstNameInput("Jānis");
        checkoutPage.setLastNameInput("Bērziņš");
        checkoutPage.setZipPostalCodeInput("LV-1234");
        checkoutPage.clickContinueButton();
        checkoutPage.isErrorIconForFirstNameDisplayed();
        checkoutPage.isErrorIconForLastNameDisplayed();
        checkoutPage.isErrorIconForZipPostalCodeDisplayed();
        checkoutPage.isErrorButtonDisplayed();

        checkoutPage.openMenu();
        checkoutPage.clickLogoutLink();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing ChromeDriver");
        driver.quit();
    }
}