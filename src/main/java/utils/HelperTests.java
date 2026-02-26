package utils;

import OrangeHRM_Pages.LoginPage;
import OrangeHRM_Pages.RecruitmentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HelperTests{
    WebDriver driver;
    WebDriverWait wait;


    public HelperTests(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void createCandidate() {

        LoginPage loginPage = new LoginPage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.fillTheLoginCredentials();
        loginPage.clickTheLoginButton();
        recruitmentPage.openTheRecruitmentPage();
        recruitmentPage.addCandidate();
        //Important note:At vacancy option you need you select the exact vacancy option you have and you can use only numbers at contact number.
        recruitmentPage.fillTheApplicationCredentials("firstname", "middleName", "lastName", "Senior QA Lead", "email@example.com", "06436363", "grereyeyey", "2026-01-20", "asdda");
        recruitmentPage.saveCandidateApplication();


    }


}
