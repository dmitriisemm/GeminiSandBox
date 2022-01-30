package pageObjects;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CreateBusinessAccountPage extends BasePage {
    private By legalBusinessNameFieldLocator = By.xpath("//input[@name='company.legalName']");
    private By legalFirstNameFieldLocator = By.xpath("//input[@name='personal.legalName.firstName']");
    private By legalLastNameFieldLocator = By.xpath("//input[@name='personal.legalName.lastName']");
    private By yourEmailAddressFieldLocator = By.xpath("//input[@name='personal.email']");
    private By companyTypeDropdownLocator = By.id("companyTypeDropdown");
    private By companyTypeDropdownMenuLocator = By.xpath("//div[contains(@class,'companyTypeDropdown__option')]");
    private By stateDropDownMenuLocator = By.xpath("//div[contains(@class,'usStateDropdown__option')]");
    private By stateDropDownLocator = By.id("stateDropdown");
    private By checkBoxRulesLocator = By.xpath("//input[@name='tos']/following-sibling::span");
    private By submitButtonLocator = By.xpath("//button[@type='submit']");
    private By errorMessageLocator = By.xpath("//div[@class='AlertBody']//li");

    public CreateBusinessAccountPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    /** Successful registration */
    public SuccessfulRegistrationPage registerNewInstitutionalClient() {
        log.debug("Typing Legal Business Name");
        String legalBusinessName = new Faker().name().firstName();
        type(legalBusinessName,legalBusinessNameFieldLocator);
        log.debug("Selecting random Company Type");
        click(companyTypeDropdownLocator);
        selectRandomDropDownValue(companyTypeDropdownMenuLocator);
        log.debug("Selecting random State");
        click(stateDropDownLocator);
        selectRandomDropDownValue(stateDropDownMenuLocator);
        log.debug("Typing Legal First Name");
        String legalFirstName = new Faker().name().firstName();
        type(legalFirstName,legalFirstNameFieldLocator);
        log.debug("Typing Legal Last Name");
        String legalLastName = new Faker().name().lastName();
        type(legalLastName,legalLastNameFieldLocator);
        log.debug("Typing Email Address");
        String emailAddress = new Faker().name().firstName()+"@gmail.com";
        type(emailAddress,yourEmailAddressFieldLocator);
        log.debug("Clicking on Rules Checkbox");
        click(checkBoxRulesLocator);
        log.debug("Clicking on submit button");
        click(submitButtonLocator);
        return new SuccessfulRegistrationPage(driver,log);
    }

    /** Failed registration */
    public void failedRegistration (String businessName, String firstName, String lastName, String emailAddress, String company, String state, String agreement) {
        if (businessName.equals("noBusinessName")) {log.debug("Skipping Business Name field");}
        else {
            log.debug("Typing Legal Business Name");
            type(businessName, legalBusinessNameFieldLocator);
        }
        if (company.equals("noCompany")) {log.debug("Skipping Company Type field");}
        else {
            log.debug("Selecting random Company Type");
            click(companyTypeDropdownLocator);
            selectRandomDropDownValue(companyTypeDropdownMenuLocator);
        }
        if (state.equals("noState")) {log.debug("Skipping state field");}
        else{
            log.debug("Selecting random State");
            click(stateDropDownLocator);
            selectRandomDropDownValue(stateDropDownMenuLocator);
        }
        if (firstName.equals("noFirstName")) {log.debug("Skipping Legal First Name field");}
        else {
            log.debug("Typing Legal First Name");
            type(firstName, legalFirstNameFieldLocator);
        }
        if (lastName.equals("noLastName")) {log.debug("Skipping Legal Last Name field");}
        else {
            log.debug("Typing Legal Last Name");
            type(lastName, legalLastNameFieldLocator);
        }
        if (emailAddress.equals("noEmailAddress")) {log.debug("Skipping Email Adress field");}
        else {
            log.debug("Typing Email Address");
            type(emailAddress, yourEmailAddressFieldLocator);
        }
        if (agreement.equals("noUserAgreement")){log.debug("Skipping User Agreement checkbox");}
        else{
            log.debug("Clicking on Rules Checkbox");
            click(checkBoxRulesLocator);
        }
        log.debug("Clicking on submit button");
        click(submitButtonLocator);
    }

    /** Return text from error message */
    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return find(errorMessageLocator).getText();
    }
}
