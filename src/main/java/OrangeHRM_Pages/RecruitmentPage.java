package OrangeHRM_Pages;



import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.UtilCodes;




public class RecruitmentPage extends UtilCodes {


    public RecruitmentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }



    //Elements
    @FindBy(css = "a[href=\"/web/index.php/recruitment/viewRecruitmentModule\"]")
    private WebElement recruitmentPage;

    @FindBy(css = "div[class=\"oxd-select-wrapper\"]")
    private WebElement vacanciesSection;



        @FindBy(xpath = "(//input[@placeholder=\"Type here\"])[1]")
        private WebElement emailInput;

        @FindBy(xpath = "(//input[@placeholder=\"Type here\"])[2]")
        private WebElement contactNumberInput;

       @FindBy(xpath = "(//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input)[7]")
       private WebElement keywordInput;

       @FindBy(xpath = "//div[@class=\"oxd-date-input\"]//input")
       private WebElement dateInput;

       @FindBy(xpath = "//div[@class=\"oxd-form-row\"]//textarea")
       private WebElement noteInput;

       @FindBy(css = "i[class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]")
       private WebElement consentDataCheckBox;

       @FindBy(css = "button[type=\"submit\"]")
       private WebElement saveButton;

       @FindBy(xpath = "(//button[@type=\"button\"])[5]")
       private WebElement shortlistButton;

       @FindBy(css = "li[class=\"oxd-topbar-body-nav-tab\"]")
       private WebElement vacancySection;

       //Asserts
       @FindBy(css = "div[class=\"oxd-toast oxd-toast--success oxd-toast-container--toast\"]")
       private WebElement addApplicationAssert;

       @FindBy(xpath = "(//p[@class=\"oxd-text oxd-text--p\"])[1]")
       private WebElement nameAssert;

       @FindBy(xpath = "(//p[@class=\"oxd-text oxd-text--p\"])[2]")
       private WebElement vacancyAssert;

       @FindBy(xpath = "(//p[@class=\"oxd-text oxd-text--p\"])[3]")
       private WebElement hiringManagerAssert;

       @FindBy(css = "p[class=\"oxd-text oxd-text--p oxd-text--subtitle-2\"]")
       private WebElement statusAssert;

    public WebElement getAddApplicationAssert() {
        return addApplicationAssert;
    }
    public WebElement getNameAssert() {
        return nameAssert;
    }
    public WebElement getVacancyAssert() {
        return vacancyAssert;
    }
    public WebElement getHiringManagerAssert() {
        return hiringManagerAssert;
    }
    public WebElement getStatusAssert() {
        return statusAssert;
    }

    public void openTheRecruitmentPage () {
            recruitmentPage.click();
        }

        public void openTheVacancySection () {
            vacancySection.click();
        }

        public void scrollToTheList () {
            scrollToTheElement(listAssert);
        }

        public void addCandidate(){
            addButton.click();
        }

        public void fillTheApplicationCredentials(String firstName,String middleName,String lastName,String Option,String email,String contactNumber,String keyWords,String dateOfApplication,String notes){
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(firstName);
        middleNameInput.sendKeys(middleName);
        lastNameInput.sendKeys(lastName);
        vacanciesSection.click();
        By vacancyOptions=By.xpath("//span[contains(text(), '"+Option+"')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(vacancyOptions));
        driver.findElement(vacancyOptions).click();
        emailInput.sendKeys(email);
        contactNumberInput.sendKeys(contactNumber);
        keywordInput.sendKeys(keyWords);
        dateInput.sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
        dateInput.sendKeys(dateOfApplication);
        noteInput.sendKeys(notes);
        consentDataCheckBox.click();

        }

        public void saveCandidateApplication(){
            saveButton.click();
        }
    }

