package Tests;

import Base.TestBase;
import org.testng.annotations.Test;

public class AddProductsLowerThan_1500_Test extends TestBase {

    @Test(priority = 3)
    public void AddProductsLowerThan_1500_Test() {
        shoppingCartPage = addProductsLowerThan_1500_page.AddProductsLowerThan_1500();
    }

}
