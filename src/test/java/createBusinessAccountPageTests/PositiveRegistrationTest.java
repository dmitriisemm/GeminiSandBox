package createBusinessAccountPageTests;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CreateAccountPage;
import pageObjects.CreateBusinessAccountPage;
import pageObjects.SignInPage;
import pageObjects.SuccessfulRegistrationPage;

public class PositiveRegistrationTest extends TestUtilities {

    @Test
    public void successfulRegistration() {

        // Open main page
        SignInPage signInPage = new SignInPage(driver, log);
        signInPage.openSignInPage(url);

        // Open Create New Account Page
        CreateAccountPage createAccountPage = signInPage.clickOnCreateNewAccount();

        // Open Create a business account page and Fill out the form
        CreateBusinessAccountPage createBusinessAccountPage = createAccountPage.clickOnCreateBusinessAccount();
        SuccessfulRegistrationPage successPage = createBusinessAccountPage.registerNewInstitutionalClient();

        log.debug("Asserting results");
        // CreateBusinessAccountPageTests.New Page Url Expected
        Assert.assertEquals(successPage.getCurrentUrl(), successPage.getPageUrl());
        // Successful Registration message expected
        Assert.assertEquals(successPage.getSuccessMessage(), successPage.expectedSuccessMessage());

        // Take screenshot of successful registration page
        log.debug("Taking screenshot of successful registration page");
        takeScreenshot("Successful registration");
    }
}

