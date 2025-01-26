package Base;

import Pages.*;
import Utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    protected static ChromeOptions options;

    // creating objects from pages' classes.
    protected static LoginPage loginPage;
    protected static AllVideoGamesPage allVideoGamesPage;
    protected static AddProductsLowerThan_1500_Page addProductsLowerThan_1500_page;
    protected static ShoppingCartPage shoppingCartPage;
    protected static CheckOutPage checkOutPage;

    public static ChromeOptions chromeOption() {
        options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.8");
        return options;
    }

    @BeforeSuite
    @Parameters({"browser"})
    public void setUpEnvironment() {
        WebDriverManager.chromedriver().setup();
        options = chromeOption();
        driver = new ChromeDriver(options);
        driver.navigate().to(" https://www.amazon.eg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    //take screenshot if the test failed
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.print("Failed and taking screenshot");
            System.out.print(result.getName());
            Helper.takesScreenshot(driver, result.getName());
        }
    }
}
