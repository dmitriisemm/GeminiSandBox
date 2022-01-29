package pageObjectsSandBox;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateBusinessAccountPageObject extends BasePage {
    By legalBusinessNameFieldLocator = By.xpath("//input[@name='company.legalName']");
    By legalFirstNameFieldLocator = By.xpath("//input[@name='personal.legalName.firstName']");
    By middleNameFieldLocator = By.xpath("//input[@name='personal.legalName.middleName']");
    By legalLastNameFieldLocator = By.xpath("//input[@name='personal.legalName.lastName']");
    By yourEmailAddressFieldLocator = By.xpath("//input[@name='personal.email']");

    public CreateBusinessAccountPageObject(WebDriver driver, Logger log){
        super(driver, log);
    }



}
