package OrangeHRM_Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilCodes;




public class RecruitmentPage extends UtilCodes{


    public RecruitmentPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "a[href=\"/web/index.php/recruitment/viewRecruitmentModule\"]")
    private WebElement recruitmentPage;

    @FindBy(css = "li[class=\"oxd-topbar-body-nav-tab\"]")
    private WebElement vacanciesSection;


    public void openTheRecruitmentPage() {
        recruitmentPage.click();
    }

    public void scrollToTheList(){
        scrollToTheElement(listAssert);
    }

}
