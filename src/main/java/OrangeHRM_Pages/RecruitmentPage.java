package OrangeHRM_Pages;



import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.UtilCodes;



import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class RecruitmentPage extends UtilCodes {

    public RecruitmentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    //Elements
    @FindBy(css = "a[href=\"/web/index.php/recruitment/viewRecruitmentModule\"]")
    private WebElement recruitmentPage;

    @FindBy(css = "div[class=\"oxd-select-wrapper\"]")
    private WebElement jobsOptions;

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

    @FindBy(css = "button[class=\"oxd-button oxd-button--medium oxd-button--success\"]")
    private WebElement shortlistButton;

    @FindBy(css = "button[class=\"oxd-button oxd-button--medium oxd-button--danger\"]")
    private WebElement rejectButton;

    @FindBy(css = "li[class=\"oxd-topbar-body-nav-tab\"]")
    private WebElement vacancySection;

    @FindBy(css = "div[role=\"listbox\"]")
    private WebElement hiringManagersList;

    @FindBy(xpath = "(//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input)[1]")
    private WebElement vacancyNameInput;

    @FindBy(xpath = "(//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input)[2]")
    private WebElement hiringManagers;

    @FindBy(xpath = "(//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input)[3]")
    private WebElement numberOfPositionsInput;

    @FindBy(css = "textarea[class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]")
    private WebElement descriptionInput;

    //Asserts

    public WebElement getSuccessfulAssert() {
        wait.until(ExpectedConditions.visibilityOf(successfulAssert));
        return successfulAssert;
    }

    public WebElement getCreatedVacancyAssert() {
        wait.until(ExpectedConditions.visibilityOf(createdVacancyAssert));
        return createdVacancyAssert;
    }

   public WebElement getUnexpectedErrorAssert() {
       wait.until(ExpectedConditions.visibilityOf(unexpectedErrorAssert));
       return unexpectedErrorAssert;
   }

   public WebElement getRequiredAssert(){
        wait.until(ExpectedConditions.visibilityOf(requiredAssert));
        return requiredAssert;
   }
    public void openTheVacancySection () {
        vacancySection.click();
    }

    public void openTheRecruitmentPage () {
            recruitmentPage.click();
        }



        public void scrollToTheList () {
            scrollToTheElement(listAssert);
        }

        public void addCandidate(){
        addButton.click();
        }

        public void addVacancy(){
        addButton.click();
        }

        public void fillTheApplicationCredentials(String firstName,String middleName,String lastName,String Option,String email,String contactNumber,String keyWords,String dateOfApplication,String notes){
        By vacancyOption=By.xpath("//span[contains(text(), '"+Option+"')]");
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(firstName);
        middleNameInput.sendKeys(middleName);
        lastNameInput.sendKeys(lastName);
        jobsOptions.click();
        wait.until(ExpectedConditions.elementToBeClickable(vacancyOption));
        driver.findElement(vacancyOption).click();
        emailInput.sendKeys(email);
        contactNumberInput.sendKeys(contactNumber);
        keywordInput.sendKeys(keyWords);
        dateInput.sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
        dateInput.sendKeys(dateOfApplication);
        noteInput.sendKeys(notes);
        consentDataCheckBox.click();

        }



        public void fillTheVacancyCredentials(String vacancyName,String option,String managerName,String description,String numbersOfPositions) {
            By jobOption = By.xpath("//span[normalize-space()='" + option + "']");
            By hiringManger=By.xpath("//span[normalize-space()='"+managerName+"']");
            vacancyNameInput.sendKeys(vacancyName);
            jobsOptions.click();
            driver.findElement(jobOption).click();
            hiringManagers.sendKeys(managerName);
            wait.until(ExpectedConditions.presenceOfElementLocated(hiringManger));
            driver.findElement(hiringManger).click();
            descriptionInput.sendKeys(description);
            numberOfPositionsInput.sendKeys(numbersOfPositions);


        }


        public void saveCandidateApplication(){
        wait.until(elementToBeClickable(saveButton));
            saveButton.click();
        }

        public void saveVacancy(){
            wait.until(elementToBeClickable(saveButton));
            saveButton.click();
        }

        public void shortlistOptionPath(){
        wait.until(elementToBeClickable(shortlistButton));
        shortlistButton.click();
    }

        public void rejectOptionPath(){
        wait.until(elementToBeClickable(rejectButton));
        rejectButton.click();



        }


    }


