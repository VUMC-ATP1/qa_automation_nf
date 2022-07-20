package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
    private WebDriver driver;
    MainPage mainPage;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By firstNameField = By.id("fNameID");
    private By lastNameField = By.id("lNameID");
    private By aboutMeField = By.id("aboutMeID");
    private By checkDataButton = By.id("checkDataID");
    private By studentCheckbox = By.id("studentID");
    private By universities = By.id("universitiesID");
    private By javaRadioButton = By.id("javaID");
    private By linkedinUrl = By.linkText("LinkedIn");
    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }
    public void setFirstNameField(String value) {
        getFirstNameField().sendKeys(value);
    }
    public WebElement getLastNameField() { return driver.findElement(lastNameField); }
    public void setLastNameField(String value) { getLastNameField().sendKeys(value); }
    public WebElement getAboutMeField() { return driver.findElement(aboutMeField); }
    public void setAboutMeField(String value) { getAboutMeField().sendKeys(value); }

    public WebElement getCheckDataButton() {
        return driver.findElement(checkDataButton);
    }
    public void setCheckDataButton() {
        getCheckDataButton().click();
    }

    public WebElement getStudentCheckbox() {
        return driver.findElement(studentCheckbox);
    }
    public void setStudentCheckbox() {
        getStudentCheckbox().click();
    }

    //public WebElement getUniversity() {
       //return new Select(driver.findElement(universities));
    //}

    public void setUniversity() {
        getStudentCheckbox().click();
    }
        //Select universities = new Select (driver.findElement(By.id("universitiesID")));
        //universities.selectByVisibleText("Rīgas Tehniskā universitāte");

    public WebElement getLinkedinURL() {
        return driver.findElement(linkedinUrl);
    }

}

