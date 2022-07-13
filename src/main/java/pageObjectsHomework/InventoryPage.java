package pageObjectsHomework;

import org.openqa.selenium.*;

public class InventoryPage {
    private WebDriver driver;
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    private By productSauceLabsBikeLight = By.xpath("//div[@class = 'inventory_item_name' and text() = 'Sauce Labs Bike Light']");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By shoppingCartLink = By.xpath("//a[contains(@class, 'shopping_cart_link')]");
    private By shoppingCartBadge = By.xpath("//span[contains(@class, 'shopping_cart_badge')]");

    private By shoppingCartBadgeOneProduct = By.xpath("//span[contains(@class, 'shopping_cart_badge') and contains(text(), '1')]");
    public void selectProductSauceLabsBikeLight() {
        driver.findElement(productSauceLabsBikeLight).click();
    }
    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        System.out.println("User adds 'Sauce Labs Bike Light' product to cart");
    }
    public void clickShoppingCartLink() {
        driver.findElement(shoppingCartLink).click();
        System.out.println("User clicks on 'Shopping cart' link");
    }

    public void isShoppingCartBadgeDisplayed() {
        try {
            driver.findElement(shoppingCartBadgeOneProduct).isDisplayed();
            System.out.println("The shopping cart is not empty. One product is added to cart");
        } catch (Exception exception) {
            System.out.println("The shopping cart is empty");
        }
    }
}