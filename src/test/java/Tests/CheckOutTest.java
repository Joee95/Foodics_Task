package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.testng.annotations.Test;


public class CheckOutTest extends TestBase {

    String FullName = LoadPropertiesFile.userdata.getProperty("FullName");
    String MobileNumber = LoadPropertiesFile.userdata.getProperty("MobileNumber");
    String StreetName = LoadPropertiesFile.userdata.getProperty("StreetName");
    String BuildingNumber = LoadPropertiesFile.userdata.getProperty("BuildingNumber");
    String City = LoadPropertiesFile.userdata.getProperty("City");
    String District = LoadPropertiesFile.userdata.getProperty("District");

    @Test(priority = 6)
    public void CheckItemsInCart() throws InterruptedException {
        checkOutPage.addAddressAndSelectPaymentMethod
                (FullName, MobileNumber, StreetName, BuildingNumber, City, District);
    }

}
