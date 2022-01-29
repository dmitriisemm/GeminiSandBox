package pageObjectsSandBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class SignInPageObject extends BasePage{
    private By createNewAccountLocator = By.xpath("//a[text()='Create new account']");

    public SignInPageObject(WebDriver driver, Logger log){
        super(driver,log);
    }

    public void openSignInPage(String url){
        log.debug("Opening "+url);
        openUrl(url);
    }

    public CreateAccountPageObject clickOnCreateNewAccount(){
        log.debug("Clicking on Create new Account");
        click(createNewAccountLocator);
        return new CreateAccountPageObject(driver, log);
    }









}
