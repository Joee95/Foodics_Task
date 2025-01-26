package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(500));
    }

    private By Accounts_Lists = By.id("nav-link-accountList");
    private By Email = By.id("ap_email");
    private By Continue = By.id("continue");
    private By Password = By.id("ap_password");
    private By SignInSubmit = By.id("signInSubmit");

    public AllVideoGamesPage Login(String email, String password) {
        driver.findElement(Accounts_Lists).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Continue).click();
        driver.findElement(Password).sendKeys(password);
        driver.findElement(SignInSubmit).click();
        return new AllVideoGamesPage(driver);
    }
}
