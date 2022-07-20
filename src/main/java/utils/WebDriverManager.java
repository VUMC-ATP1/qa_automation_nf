package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    public static WebDriver driver;

    public static WebDriver getInstance() {
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        //driver.close();
        driver.quit();
        driver = null;
    }
}
