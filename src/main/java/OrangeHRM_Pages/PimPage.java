package OrangeHRM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UtilCodes;

import java.time.Duration;
import java.util.List;

public class PimPage extends UtilCodes {
    WebDriver driver;
    WebDriverWait wait;

    public PimPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//ul[@class=\"oxd-main-menu\"]//li)[2]")
    private WebElement pimPageOption;

    @FindBy(xpath = "(//a[@class=\"oxd-topbar-body-nav-tab-item\"])[3]")
    private WebElement reportsSection;





    public void openThePimPage(){
        pimPageOption.click();
        scrollToTheList(listAssert);


    }

    public void goToTheReportsSection(){
        reportsSection.click();
        scrollToTheList(listAssert);
    }














}