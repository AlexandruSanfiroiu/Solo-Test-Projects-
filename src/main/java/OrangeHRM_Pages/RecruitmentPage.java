package OrangeHRM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UtilCodes;




public class RecruitmentPage extends UtilCodes{
    WebDriver driver;
    WebDriverWait wait;

    public RecruitmentPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);




    }
    @FindBy(css = "a[href=\"/web/index.php/recruitment/viewRecruitmentModule\"]")
    private WebElement recruitmentPage;







    public void openTheRecruitmentPage(){
        recruitmentPage.click();
        scrollToTheList(listAssert);
    }




}
