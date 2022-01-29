package pageObjectsSandBox;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public CreateBusinessAccountPage(WebDriver driver, Logger log){
        super(driver, log);
    }

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






}
