package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllVideoGamesPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;

    public AllVideoGamesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        this.js = (JavascriptExecutor) driver;
    }

    private By AllVideoGames = By.xpath("//*[@id=\"hmenu-content\"]/ul[32]/li[3]/a");
    private By VideoGames = By.linkText("Video Games");
    private By HamburgerMenu = By.id("nav-hamburger-menu");
    private By FreeShipingCheckBox = By.xpath("//*[@id=\"s-refinements\"]/div[2]/ul/li/span/a/div[1]/label/i");
    private By ConditionNewBtn = By.xpath("//span[@class='a-size-base a-color-base' and contains (. , 'New')]");
    private By SeeAllBtn = By.xpath("//a[@class='hmenu-item hmenu-compressed-btn']");
    private By SortbyBtn = By.id("a-autoid-0-announce");
    private By PriceHighToLowBtn = By.linkText("Price: High to Low");


    public void NavigateTo_AllVideoGamesPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HamburgerMenu));
        driver.findElement(HamburgerMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SeeAllBtn));
        driver.findElement(SeeAllBtn).click();
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(VideoGames));
        wait.until(ExpectedConditions.visibilityOfElementLocated(VideoGames));
        driver.findElement(VideoGames).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AllVideoGames));
        driver.findElement(AllVideoGames).click();
    }

    public void FileterationOptions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FreeShipingCheckBox));
        driver.findElement(FreeShipingCheckBox).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConditionNewBtn));
        driver.findElement(ConditionNewBtn).click();
    }

    public AddProductsLowerThan_1500_Page SortByPrice() {
        driver.findElement(SortbyBtn).click();
        driver.findElement(PriceHighToLowBtn).click();
        return new AddProductsLowerThan_1500_Page(driver);
    }
}
