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

       @FindBy(css = "button[class=\"oxd-button oxd-button--medium oxd-button--success\"]")
       private WebElement shortlistButton;

       @FindBy(css = "button[class=\"oxd-button oxd-button--medium oxd-button--danger\"]")
       private WebElement rejectButton;


       @FindBy(css = "li[class=\"oxd-topbar-body-nav-tab\"]")
       private WebElement vacancySection;



       //Asserts
       @FindBy(css = "div[class=\"oxd-toast oxd-toast--success oxd-toast-container--toast\"]")
       private WebElement successfulAssert;


    public WebElement getSuccessfulAssert() {
        return successfulAssert;
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
        wait.until(ExpectedConditions.elementToBeClickable(vacancyOptions));
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

        public void shortlistOptionPath(){
        wait.until(ExpectedConditions.elementToBeClickable(shortlistButton));
        shortlistButton.click();



        }

        public void rejectOptionPath(){
        wait.until(ExpectedConditions.elementToBeClickable(rejectButton));
        rejectButton.click();



        }
        public void saveShortlistCandidate(){
            wait.until(ExpectedConditions.elementToBeClickable(saveButton));
            saveButton.click();
        }

    public boolean isSuccessToastDisplayedAssert() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successfulAssert));
            return successfulAssert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    }

