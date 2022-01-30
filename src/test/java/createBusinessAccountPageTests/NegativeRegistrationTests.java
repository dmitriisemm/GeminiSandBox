package createBusinessAccountPageTests;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjectsSandBox.BasePage;
import pageObjectsSandBox.CreateAccountPage;
import pageObjectsSandBox.CreateBusinessAccountPage;
import pageObjectsSandBox.SignInPage;

import java.util.List;
import java.util.Random;

public class NegativeRegistrationTests extends BaseTest {

    @DataProvider(name = "data")
    public Object[][] getData(){
        String legalBusinessName = new Faker().name().firstName();
        String legalFirstName = new Faker().name().firstName();
        String legalLastName = new Faker().name().lastName();
        String emailAddress = new Faker().name().firstName()+"@gmail.com";

        return new Object[][]{
                {"",legalFirstName,legalLastName,emailAddress/*,"Legal Business Name is required."*/},
                {legalBusinessName,"",legalLastName, emailAddress/*,"First name is required."*/},
                {legalBusinessName,legalFirstName,"",emailAddress/*,"Last name is required."*/},
                {legalBusinessName, legalFirstName, legalLastName,""/*,"Please enter a valid email address."*/},
        };
    }

    @Test(dataProvider = "data")
    public void negativeRegister(String businessName, String firstName, String lastName, String emailAddress) throws InterruptedException {
        // Open main page
        SignInPage signInPage = new SignInPage(driver,log);
        signInPage.openSignInPage(url);

        // Open Create CreateBusinessAccountPageTests.New Account Page
        CreateAccountPage createAccountPage = signInPage.clickOnCreateNewAccount();
        // Open Create a business account page
        // Fill out the form
        CreateBusinessAccountPage createBusinessAccountPage = createAccountPage.clickOnCreateBusinessAccount();
        createBusinessAccountPage.registerNewInstitutionalClient2(businessName, firstName, lastName,emailAddress);
    }
}
