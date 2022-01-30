package createBusinessAccountPageTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectsSandBox.CreateAccountPage;
import pageObjectsSandBox.CreateBusinessAccountPage;
import pageObjectsSandBox.SignInPage;
import pageObjectsSandBox.SuccessfulRegistrationPage;

public class PositiveRegistrationTest extends BaseTest {

    @Test
    public void newTest() {

        // Open main page
        SignInPage signInPage = new SignInPage(driver,log);
        signInPage.openSignInPage(url);

        // Open Create CreateBusinessAccountPageTests.New Account Page
        CreateAccountPage createAccountPage = signInPage.clickOnCreateNewAccount();

        // Open Create a business account page
        // Fill out the form
        CreateBusinessAccountPage createBusinessAccountPage = createAccountPage.clickOnCreateBusinessAccount();
        SuccessfulRegistrationPage successPage = createBusinessAccountPage.registerNewInstitutionalClient();

        /** Assert results */
        // CreateBusinessAccountPageTests.New Page Url Expected
        Assert.assertEquals(successPage.getCurrentUrl(), successPage.getPageUrl());
        // Successful Registration message expected
        Assert.assertEquals(successPage.getSuccessMessage(), successPage.expectedSuccessMessage());
        }
    }

