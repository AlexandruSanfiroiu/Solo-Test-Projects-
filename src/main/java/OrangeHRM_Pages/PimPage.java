package OrangeHRM_Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilCodes;



public class PimPage extends UtilCodes {


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
        scrollToTheElement(listAssert);
    }

    public void goToTheReportsSection(){
        reportsSection.click();
        scrollToTheElement(listAssert);
    }














}