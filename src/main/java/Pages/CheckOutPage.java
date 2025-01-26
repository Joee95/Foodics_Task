package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions actions;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    private By AddNewAddressBtn = By.xpath("//span[@id='add-new-address-desktop-sasp-tango-link' and contains (. , 'Add a new delivery address')]");
    private By FullNameField = By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']");
    private By MobileNumberField = By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']");
    private By StreetNameField = By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']");
    private By BuildingNumberField = By.xpath("//input[@id='address-ui-widgets-enter-building-name-or-number']");
    private By CityField = By.xpath("//input[@id='address-ui-widgets-enterAddressCity']");
    private By DistrictField = By.xpath("//input[@id='address-ui-widgets-enterAddressDistrictOrCounty']");
    private By DistrictDDL = By.xpath("//input[@id=\"address-ui-widgets-enterAddressDistrictOrCounty\"]");
    private By SaveAddressBtn = By.xpath("//span[@id='checkout-primary-continue-button-id-announce' and contains (. , 'Use this address')]");
    private By Heading = By.xpath("//h2[contains (. , 'Enter a new shipping address') ]");

    //    private By PaymentMethod = By.name("payment-method");
//    private By PlaceOrder = By.name("placeOrder");
//    private By SubmitAddress = By.id("submitAddress");
//    private By CashPaymentOption = By.xpath("//input[@value='Cash']");
//    private By SelectCashPaymentOption = By.xpath("//input[@value='Cash']");

    public void addAddressAndSelectPaymentMethod(String FullName, String MobileNumber, String StreetName, String BuildingNumber
            , String City, String District) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(AddNewAddressBtn));
        driver.findElement(AddNewAddressBtn).click();

        // Address Details
        // Full Name Field
        driver.findElement(FullNameField).sendKeys(FullName);
        // Mobile Number Field
        driver.findElement(MobileNumberField).sendKeys(MobileNumber);
        // StreetName Field
        driver.findElement(StreetNameField).sendKeys(StreetName);
        // Building Number Field
        driver.findElement(BuildingNumberField).sendKeys(BuildingNumber);
        // City Field
        driver.findElement(CityField).click();
        driver.findElement(CityField).sendKeys(City);
        driver.findElement(CityField).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        actions.moveToElement(driver.findElement(Heading)).click().build().perform();
        // District Field
        wait.until(ExpectedConditions.visibilityOfElementLocated(DistrictField));
        driver.findElement(DistrictDDL).click();
        driver.findElement(DistrictField).sendKeys(District);
        driver.findElement(DistrictField).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        actions.moveToElement(driver.findElement(Heading)).click().build().perform();
        // Save Address Button
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaveAddressBtn));
        driver.findElement(SaveAddressBtn).click();

        // Choose payment method ---> Not enabled on UI
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("payment-method"))); // Wait for payment options
//        WebElement cashPaymentOption = driver.findElement(By.xpath("//input[@value='Cash']"));
//        if (cashPaymentOption.isDisplayed() && cashPaymentOption.isEnabled()) {
//            cashPaymentOption.click(); // Select cash payment method
//        }
    }
}
