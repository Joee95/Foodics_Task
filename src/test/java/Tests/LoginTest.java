package Tests;

import Base.TestBase;
import LoadProperties.LoadPropertiesFile;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    String email = LoadPropertiesFile.userdata.getProperty("email");
    String password = LoadPropertiesFile.userdata.getProperty("password");

    @Test(priority = 1)
    public void Login() {
        allVideoGamesPage = loginPage.Login(email, password);
    }

}
