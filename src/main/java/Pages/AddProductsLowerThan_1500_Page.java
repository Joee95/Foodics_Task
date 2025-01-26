package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddProductsLowerThan_1500_Page {

    private WebDriver driver;
    private WebDriverWait wait;

    public AddProductsLowerThan_1500_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
    }

    private By CartIcon = By.id("nav-cart");

    public ShoppingCartPage AddProductsLowerThan_1500() {
        int maxPrice = 1500;

        boolean hasProduct = true;
        boolean foundEligibleProduct = false;

        while (hasProduct) {
            List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
            List<WebElement> addToCartBtns = driver.findElements(By.xpath("//button[@class='a-button-text' and contains(. ,'Add to cart')]"));
            List<WebElement> nextPageBtns = driver.findElements(By.xpath("//li[@class='s-list-item-margin-right-adjustment']"));

            hasProduct = false;

            for (int i = 0; i < prices.size(); i++) {
                String priceText = prices.get(i).getText().replace(",", "").replace(" ", "").trim();
                int price = Integer.parseInt(priceText);

                // Check if the price is less than 15K
                if (price < maxPrice && addToCartBtns.get(i).isDisplayed() && addToCartBtns.get(i).isEnabled()) {
                    hasProduct = true;
                    foundEligibleProduct = true;
                    WebElement addToCartButton = addToCartBtns.get(i);

                    System.out.println("Price: " + price + ", Button displayed: " + addToCartButton.isDisplayed() + ", Button enabled: " + addToCartButton.isEnabled());
                    wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ewc-content"))); // Adjust as necessary
                }

                if (foundEligibleProduct) {
                    break;
                }
            }

            // Check for next page buttons if no eligible product was found
            if (!foundEligibleProduct && nextPageBtns.size() > 0) {
                nextPageBtns.get(0).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-price-whole")));
            } else {
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartIcon));
        driver.findElement(CartIcon).click();
        return new ShoppingCartPage(driver);
    }
}