package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class UtilCodes {
  protected WebDriver driver;
  protected WebDriverWait wait;


  public UtilCodes(WebDriver driver){
      this.driver=driver;
      this.wait=new WebDriverWait(driver, Duration.ofSeconds(35));


  }

  protected By listAssert=By.xpath("//div[@class=\"oxd-table-cell oxd-padding-cell\"]//div[not(*)]");


  @FindBy(css = "input[name=\"firstName\"]")
  protected WebElement firstNameInput;

  @FindBy(css = "input[name=\"middleName\"]")
  protected WebElement middleNameInput;

  @FindBy(css = "input[name=\"lastName\"]")
  protected WebElement lastNameInput;

  @FindBy(xpath = "//div[@class=\"orangehrm-header-container\"]//button")
  protected WebElement addButton;

  @FindBy(css = "button[type=\"submit\"]")
  protected WebElement saveButton;

  @FindBy(xpath = "//button[normalize-space()='Save']")
  protected WebElement successfulAssert;

  @FindBy(css = "div[class=\"oxd-toast oxd-toast--error oxd-toast-container--toast\"]")
  protected WebElement unexpectedErrorAssert;

    public List<WebElement> findListAssert(){
        wait.until(ExpectedConditions.presenceOfElementLocated(listAssert));
        return driver.findElements(listAssert);
    }

    public void scrollToTheElement(By elements){
       WebElement target=wait.until(ExpectedConditions.presenceOfElementLocated(elements));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",target);

    }

}