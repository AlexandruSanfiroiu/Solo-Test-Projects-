package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class UtilCodes {
  protected WebDriver driver;
  protected WebDriverWait wait;


  public UtilCodes(WebDriver driver){
      this.driver=driver;
      this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));


  }

    public By listAssert=By.xpath("//div[@class=\"oxd-table-cell oxd-padding-cell\"]//div[not(*)]");

    public List<WebElement> findListAssert(){
        wait.until(ExpectedConditions.presenceOfElementLocated(listAssert));
        return driver.findElements(listAssert);
    }

    public void scrollToTheList(By elements){
       WebElement target=wait.until(ExpectedConditions.presenceOfElementLocated(elements));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",target);

    }

}