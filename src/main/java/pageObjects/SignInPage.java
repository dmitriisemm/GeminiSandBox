package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class SignInPage extends BasePage{
    private By createNewAccountLocator = By.xpath("//a[text()='Create new account']");

    public SignInPage(WebDriver driver, Logger log){
        super(driver,log);
    }

    public void openSignInPage(String url){
        log.debug("Opening "+url);
        openUrl(url);
    }

    public CreateAccountPage clickOnCreateNewAccount(){
        log.debug("Clicking on Create new Account");
        click(createNewAccountLocator);
        return new CreateAccountPage(driver, log);
    }









}
