package Tests;

import Base.TestBase;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase {

    @Test(priority = 4)
    public void CheckItemsInCart() {
        shoppingCartPage.ensureAllProductsInCart();
    }

    @Test(priority = 5)
    public void ProceedToCheckout() {
        checkOutPage = shoppingCartPage.ProceedToCheckout();
    }
}
