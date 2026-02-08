package OrangeHRM_Tests;


import OrangeHRM_Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BasePage;

public class LoginTest extends BasePage {

    @Test
    public void Login_Test_Right_Credentials() {
          LoginPage login=new LoginPage(driver);
           driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
           login.fillTheLoginCredentials();
           login.clickTheLoginButton();
           Assert.assertTrue(login.getAssertLogin().isDisplayed());


    }
    @Test
    public void Login_Test_Invalid_Credentials() {
           LoginPage login = new LoginPage(driver);
           driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
           login.fillTheLoginWithInvalidCredentials();
           login.clickTheLoginButton();
           Assert.assertEquals(login.getAssertInvalidCredentialsError().getText(),"Invalid credentials");


    }
    @Test
    public void Login_Test_With_No_Credentials() {
           LoginPage login = new LoginPage(driver);
           driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
           login.clickTheLoginButton();
           Assert.assertEquals(login.getAssertNoCredentialsError().getText(),"Required");


    }
}
