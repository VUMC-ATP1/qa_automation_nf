package browserHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class BrowserLuLvTest {
    ChromeDriver driver;
    private final String LU_URL = "https://www.lu.lv/";

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initializing Chromedriver");
        driver = new ChromeDriver();
        driver.get(LU_URL);
    }

    @Test
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(),"Latvijas Universitāte");
        Assert.assertEquals(driver.getCurrentUrl(), LU_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing Chromedriver");
        driver.close();
        driver.quit();
    }
}