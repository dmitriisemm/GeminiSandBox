package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessfulRegistrationPage extends BasePage {
    private By successMessageFieldLocator = By.tagName("h3");
    private String pageUrl = "https://exchange.sandbox.gemini.com/register/institution/thanks";
    private String successMessage = "Thanks for Registering!";


    public SuccessfulRegistrationPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    /** Return text from success message */
    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageFieldLocator));
        return find(successMessageFieldLocator).getText();
    }

    /** Get URL variable from PageObject */
    public String getPageUrl() {
        return pageUrl;
    }

    /** Get String variable from PageObject */
    public String expectedSuccessMessage() {
        return successMessage;
    }

    /** Return new URL address */
    public String getCurrentUrl(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlMatches(pageUrl));
        return driver.getCurrentUrl();
    }
}
