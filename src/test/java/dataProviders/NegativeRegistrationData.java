package dataProviders;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class NegativeRegistrationData {
    @DataProvider(name = "data1")
    public Object[][] getData() {
        String legalBusinessName = new Faker().name().firstName();
        String legalFirstName = new Faker().name().firstName();
        String legalLastName = new Faker().name().lastName();
        String emailAddress = new Faker().name().firstName() + "@gmail.com";
        String companyType = "any";
        String state = "any";
        String agreement = "any";

        return new Object[][]{
                {1, "noBusinessName", legalFirstName, legalLastName, emailAddress, companyType, state, agreement, "Legal Business Name is required." },
                {2, legalBusinessName, "noFirstName", legalLastName, emailAddress, companyType, state, agreement, "First name is required." },
                {3, legalBusinessName, legalFirstName, "noLastName", emailAddress, companyType, state, agreement, "Last name is required." },
                {4, legalBusinessName, legalFirstName, legalLastName, "noEmailAddress", companyType, state, agreement, "Please enter a valid email address."},
                {5, legalBusinessName, legalFirstName, legalLastName, emailAddress, "noCompany", state, agreement, "Company type is required."},
                {6, legalBusinessName, legalFirstName, legalLastName, emailAddress, companyType, "noState", agreement, "Company state is required."},
                {7, legalBusinessName, legalFirstName, legalLastName, emailAddress, companyType, state, "noUserAgreement", "User Agreement is required."},
        };
    }
}
