package OrangeHRM_Tests;

import OrangeHRM_Pages.LoginPage;
import OrangeHRM_Pages.PimPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BasePage;


import java.util.List;

public class PimTest extends BasePage {



    @Test
    public void Employees_List_Test(){
        LoginPage login=new LoginPage(driver);
        PimPage pim=new PimPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        login.fillTheLoginCredentials();
        login.clickTheLoginButton();
        pim.openThePimPage();
        List<WebElement> employees=pim.findListAssert();
        Assert.assertTrue(!employees.isEmpty(), "Employee list is empty");

        for(WebElement element: pim.findListAssert()){

            Assert.assertFalse(element.getText().isEmpty());


        }


    }

    @Test
    public void Reports_List_Test(){
    LoginPage login=new LoginPage(driver);
    PimPage pim=new PimPage(driver);
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    login.fillTheLoginCredentials();
    login.clickTheLoginButton();
    pim.openThePimPage();
    pim.goToTheReportsSection();
        List<WebElement> reports=pim.findListAssert();
        Assert.assertTrue(!reports.isEmpty(), "Reports list is empty");

    for(WebElement element: pim.findListAssert()){

        Assert.assertFalse(element.getText().isEmpty());
    }

    }

}
