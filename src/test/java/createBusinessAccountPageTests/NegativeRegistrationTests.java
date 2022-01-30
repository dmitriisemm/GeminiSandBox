package createBusinessAccountPageTests;

import base.TestUtilities;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CreateAccountPage;
import pageObjects.CreateBusinessAccountPage;
import pageObjects.SignInPage;


public class NegativeRegistrationTests extends TestUtilities {

    @DataProvider(name = "data")
    public Object[][] getData() {
        String legalBusinessName = new Faker().name().firstName();
        String legalFirstName = new Faker().name().firstName();
        String legalLastName = new Faker().name().lastName();
        String emailAddress = new Faker().name().firstName() + "@gmail.com";

        return new Object[][]{
                {1, "", legalFirstName, legalLastName, emailAddress, "Legal Business Name is required."},
                {2, legalBusinessName, "", legalLastName, emailAddress, "First name is required."},
                {3, legalBusinessName, legalFirstName, "", emailAddress, "Last name is required."},
                {4, legalBusinessName, legalFirstName, legalLastName, "", "Please enter a valid email address."},
        };
    }

    @Test(dataProvider = "data")
    public void negativeRegistration(int no, String businessName, String firstName, String lastName, String emailAddress, String expectedErrorMessage) {

        log.debug("Starting failed registration test # " + no);

        // Open main page
        SignInPage signInPage = new SignInPage(driver, log);
        signInPage.openSignInPage(url);

        // Open Create CreateBusinessAccountPageTests.New Account Page
        CreateAccountPage createAccountPage = signInPage.clickOnCreateNewAccount();

        // Open Create a business account page and Fill out the form
        CreateBusinessAccountPage createBusinessAccountPage = createAccountPage.clickOnCreateBusinessAccount();
        createBusinessAccountPage.failedRegistration(businessName, firstName, lastName, emailAddress);

        // Take screenshot of failed registration page
        log.debug("Taking screenshot of failed registration page");
        takeScreenshot("Failed registration #" + no);

        // Assert results
        log.debug("Asserting results");
        Assert.assertEquals(createBusinessAccountPage.getErrorMessage(), expectedErrorMessage);
    }
}
