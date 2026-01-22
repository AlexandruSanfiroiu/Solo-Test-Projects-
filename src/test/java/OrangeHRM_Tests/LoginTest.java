package OrangeHRM_Tests;

import OrangeHRM_Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BasePage;

public class LoginTest extends BasePage {

    @Test
    public void Login_Test() {
        LoginPage login = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        login.fillTheLoginCredentials();
        login.login();
        Assert.assertTrue(login.getAssertLogin().isDisplayed());

    }
}
