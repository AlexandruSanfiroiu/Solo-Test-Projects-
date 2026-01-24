package utils;

import OrangeHRM_Pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;

public class BasePage  {

    public static WebDriver driver;
    public Logger logger;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        logger=LogManager.getLogger(driver);
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-US");
        options.addArguments("--disable-search-engine-choice-screen");
        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }


}
