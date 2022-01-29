package pageObjectsSandBox;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPageObject extends BasePage {
    private By CreateBusinessAccountLocator = By.xpath("//a[text()='Create a business account']");

    public CreateAccountPageObject(WebDriver driver, Logger log){
        super(driver, log);
    }

    public CreateBusinessAccountPageObject clickOnCreateBusinessAccount(){
        log.debug("Clicking on Create a business account");
        click(CreateBusinessAccountLocator);
        return new CreateBusinessAccountPageObject(driver,log);
    }
}
