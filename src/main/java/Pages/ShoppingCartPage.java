package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
    }

    private By CartIcon = By.id("nav-cart");
    private By CartItems = By.className("sc-list-item-content");
    private By ProceedToCheckout = By.xpath("/html/body/div[1]/div[1]/div[4]/div[4]/div/div[1]/div[1]/div/form/div/div[3]/span[1]/span/span/input");

    public void ensureAllProductsInCart() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(CartItems));

        List<WebElement> cartItems = driver.findElements(CartItems);

        if (cartItems.size() > 0) {
            System.out.println("All products are added to the cart successfully.");
        } else {
            System.out.println("No products found in the cart.");
        }
    }

    public CheckOutPage ProceedToCheckout() {
        WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(ProceedToCheckout));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceedButton);

        return new CheckOutPage(driver);
    }
}