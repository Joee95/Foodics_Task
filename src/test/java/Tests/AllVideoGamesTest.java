package Tests;

import Base.TestBase;
import org.testng.annotations.Test;

public class AllVideoGamesTest extends TestBase {


    @Test(priority = 2)
    public void NavigateTo_AllVideoGamesPage() {
        allVideoGamesPage.NavigateTo_AllVideoGamesPage();
        allVideoGamesPage.FileterationOptions();
        addProductsLowerThan_1500_page = allVideoGamesPage.SortByPrice();
    }

}
