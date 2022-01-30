package createBusinessAccountPageTests;

import base.TestUtilities;
import dataProviders.NegativeRegistrationData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CreateAccountPage;
import pageObjects.CreateBusinessAccountPage;
import pageObjects.SignInPage;

public class NegativeRegistrationTests extends TestUtilities {

    @Test(dataProvider = "data1", dataProviderClass= NegativeRegistrationData.class)
    public void negativeRegistration(int no, String businessName, String firstName, String lastName, String emailAddress, String companyType, String state, String agreement, String expectedErrorMessage) {

        log.debug("Starting failed registration test # " + no);

        // Open main page
        SignInPage signInPage = new SignInPage(driver, log);
        signInPage.openSignInPage(url);

        // Open Create New Account Page
        CreateAccountPage createAccountPage = signInPage.clickOnCreateNewAccount();

        // Open Create a business account page and Fill out the form
        CreateBusinessAccountPage createBusinessAccountPage = createAccountPage.clickOnCreateBusinessAccount();
        createBusinessAccountPage.failedRegistration(businessName, firstName, lastName, emailAddress, companyType, state, agreement);

        // Take screenshot of failed registration page
        log.debug("Taking screenshot of failed registration page");
        takeScreenshot("Failed registration #" + no);

        // Assert results
        log.debug("Asserting results");
        Assert.assertEquals(createBusinessAccountPage.getErrorMessage(), expectedErrorMessage);
    }
}
