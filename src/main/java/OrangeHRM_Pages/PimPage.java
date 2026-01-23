package OrangeHRM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PimPage {
    WebDriver driver;
    WebDriverWait wait;

    public PimPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//ul[@class=\"oxd-main-menu\"]//li)[2]")
    private WebElement pimPageOption;

    @FindBy(xpath = "(//a[@class=\"oxd-topbar-body-nav-tab-item\"])[3]")
    private WebElement reportsSection;

    By listAssert=By.xpath("//div[@class=\"oxd-table-cell oxd-padding-cell\"]//div[not(*)]");



    public void openThePimPage(){
        pimPageOption.click();


    }

    public void goToTheReportsSection(){
        reportsSection.click();
    }




    public List<WebElement> findListAssert() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listAssert));
        return driver.findElements(listAssert);
    }









}
