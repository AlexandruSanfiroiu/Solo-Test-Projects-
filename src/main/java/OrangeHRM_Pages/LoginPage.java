package OrangeHRM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginPage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[name=\"username\"]")
    private WebElement usernameInput;

    @FindBy(css = "input[name=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement loginButton;

    @FindBy(css = "div[class=\"oxd-layout-container\"]")
    private WebElement assertLogin;

   public WebElement getAssertLogin(){
       return assertLogin;
   }

    public void fillTheLoginCredentials(){
        usernameInput.sendKeys("Admin");
        passwordInput.sendKeys("admin123");
    }



    public void login(){
        loginButton.click();
    }

}
