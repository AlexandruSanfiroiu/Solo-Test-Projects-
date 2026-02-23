package OrangeHRM_Tests;

import OrangeHRM_Pages.LoginPage;
import OrangeHRM_Pages.RecruitmentPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BasePage;
import utils.HelperTests;

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
            Assert.assertFalse(element.getText().isEmpty(),"Some text are missing");

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
        recruitmentPage.openTheVacancySection();
        recruitmentPage.scrollToTheList();
        List<WebElement> recruitments=recruitmentPage.findListAssert();
        Assert.assertTrue(!recruitments.isEmpty(), "Vacancies list is empty");

        for(WebElement element:recruitments){
            Assert.assertFalse(element.getText().isEmpty());
        }

    }


     @Test
     public void Add_Vacancies_Test(){
        LoginPage login=new LoginPage(driver);
        RecruitmentPage recruitment=new RecruitmentPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        login.fillTheLoginCredentials();
        login.clickTheLoginButton();
        recruitment.openTheRecruitmentPage();
        recruitment.openTheVacancySection();
        recruitment.addVacancy();
        //Put a different vacancy name at every test
        recruitment.fillTheVacancyCredentials("name432","QA Engineer","yedghjb1 ru84 90jsnd","7rdht fafafad","32");
        recruitment.saveVacancy();

        Assert.assertTrue(recruitment.getCreatedVacancyAssert().isDisplayed());


     }


    @Test
    public void Add_Candidate_Application_Test(){
        LoginPage loginPage=new LoginPage(driver);
        RecruitmentPage recruitmentPage=new RecruitmentPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.fillTheLoginCredentials();
        loginPage.clickTheLoginButton();
        recruitmentPage.openTheRecruitmentPage();
        recruitmentPage.addCandidate();
        //Important note:At vacancy option you need you select the exact vacancy option you have and you can use only numbers at contact number.
        recruitmentPage.fillTheApplicationCredentials("firstname","middleName","lastName","Senior QA Lead","email@example.com","06436363","grereyeyey","2026-01-20","dadfafaff");
        recruitmentPage.saveCandidateApplication();
        Assert.assertTrue(recruitmentPage.getSuccessfulAssert().isDisplayed());

    }


    @Test
    public void Shortlist_Or_Reject_The_Candidate_Test() {

        //false=reject | true=shortlist
        boolean accept = true;
        HelperTests helperTests = new HelperTests(driver);
        RecruitmentPage recruitment = new RecruitmentPage(driver);
        helperTests.createCandidate();

        if (accept) {
            recruitment.shortlistOptionPath();
        }else {
            recruitment.rejectOptionPath();
        }

        recruitment.saveVacancy();
        if(recruitment.getUnexpectedErrorAssert().isDisplayed()) {
            Assert.fail("Unexpected Error");

        }else if(recruitment.getSuccessfulAssert().isDisplayed()){
            Assert.assertTrue(recruitment.getSuccessfulAssert().isDisplayed());
        }

    }
}



