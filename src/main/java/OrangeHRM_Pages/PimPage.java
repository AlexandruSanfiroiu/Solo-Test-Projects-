package OrangeHRM_Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.UtilCodes;



public class PimPage extends UtilCodes {


    public PimPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "(//ul[@class=\"oxd-main-menu\"]//li)[2]")
    private WebElement pimPageOption;

    @FindBy(xpath = "(//a[@class=\"oxd-topbar-body-nav-tab-item\"])[3]")
    private WebElement reportsSection;

    @FindBy(xpath = "//div[@class=\"oxd-grid-2 orangehrm-full-width-grid\"]//input")
    private WebElement idInput;

    @FindBy(xpath = "//div[@class=\"oxd-switch-wrapper\"]//span")
    private WebElement createLoginDetailsButton;

    @FindBy(xpath = "(//div[@class=\"oxd-grid-2 orangehrm-full-width-grid\"]//input)[2]")
    private WebElement usernameInput;

    @FindBy(xpath = "(//input[@type=\"password\"])[1]")
    private WebElement passwordInput;

    @FindBy(xpath = "(//input[@type=\"password\"])[2]")
    private WebElement confirmPasswordInput;

    @FindBy(css = "div[class=\"--name-grouped-field\"]")
    private WebElement fullNameAssert;


    public WebElement getEmployeeNameAssert(String name) {
        By nameAssert=By.xpath("//h6[normalize-space()='"+name+"']");
        wait.until(ExpectedConditions.presenceOfElementLocated(nameAssert));
        return driver.findElement(nameAssert);
    }

    public WebElement getEmployeeFullNameAssert(String fullName) {
        wait.until(ExpectedConditions.textToBePresentInElement(fullNameAssert,fullName));
        return fullNameAssert;
    }


    public void openThePimPage() {
        pimPageOption.click();

    }

    public void AddEmployee(){
        addButton.click();
    }

    public void fillTheEmployeeInformation(String firstName,String middleName,String lastName,String id){
        firstNameInput.sendKeys(firstName);
        middleNameInput.sendKeys(middleName);
        lastNameInput.sendKeys(lastName);
        idInput.sendKeys(id);

    }

    public void createLoginDetails(String username,String password){
        createLoginDetailsButton.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
    }

    public void save(){
        saveButton.click();
    }

    public void goToTheReportsSection() {
        reportsSection.click();
        scrollToTheElement(listAssert);
    }

}