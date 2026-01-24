package OrangeHRM_Tests;

import OrangeHRM_Pages.LoginPage;
import OrangeHRM_Pages.RecruitmentPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BasePage;

import java.util.List;

public class RecruitmentTest extends BasePage {

    @Test
    public void Candidates_List_Test(){
        LoginPage loginPage=new LoginPage(driver);
        RecruitmentPage recruitmentPage=new RecruitmentPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.fillTheLoginCredentials();
        loginPage.clickTheLoginButton();
        recruitmentPage.openTheRecruitmentPage();
        recruitmentPage.scrollToTheList();
        List<WebElement> recruitments=recruitmentPage.findListAssert();
        Assert.assertTrue(!recruitments.isEmpty(),"Candidates list is empty");

        for(WebElement element:recruitments){
            Assert.assertFalse(element.getText().isEmpty());
        }

    }

    @Test
    public void Vacancies_List_Test(){
        LoginPage loginPage=new LoginPage(driver);
        RecruitmentPage recruitmentPage=new RecruitmentPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.fillTheLoginCredentials();
        loginPage.clickTheLoginButton();
        recruitmentPage.openTheRecruitmentPage();
        recruitmentPage.scrollToTheList();
        List<WebElement> recruitments=recruitmentPage.findListAssert();
        Assert.assertTrue(!recruitments.isEmpty(),"Vacancies list is empty");

        for(WebElement element:recruitments){
            Assert.assertFalse(element.getText().isEmpty());
        }

    }
}
