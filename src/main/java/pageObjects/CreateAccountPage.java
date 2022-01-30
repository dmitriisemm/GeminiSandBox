package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage {
    private By CreateBusinessAccountLocator = By.xpath("//a[text()='Create a business account']");

    public CreateAccountPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public CreateBusinessAccountPage clickOnCreateBusinessAccount(){
        log.debug("Clicking on Create a business account");
        click(CreateBusinessAccountLocator);
        return new CreateBusinessAccountPage(driver,log);
    }
}
