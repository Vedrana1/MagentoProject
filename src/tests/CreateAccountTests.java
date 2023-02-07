package tests;

import org.junit.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;


public class CreateAccountTests extends BaseTest {
    String firstName = "David";
    String lastName = "Smith";
    String email = "davidsmithtest717171@example.com";
    String password = "davidsmith123!";
    String confirmPassword = "davidsmith123!";
    String titlePage = "My Account";
    String existingEmailErrorMessage = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
    String requiredFieldErrorMessage = "This is a required field.";    
    String invalidPasswordLenghtErrorMessage = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";
    String invalidPasswordStructureErrorMessage = "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";    
    String nonMatchingPasswordErrorMessage = "Please enter the same value again.";


    @Test
    public void verifySuccessfulCreateAccount(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnCreateAccount();
        createAccountPage.CreateAccount(firstName, lastName, email, password, confirmPassword);
        myAccountPage.verifyPageTitle(titlePage);
    }

    @Test
    public void verifyUnsuccessfulCreateAccountWithUsedEmail(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);        

        homePage.goToBaseUrl();
        homePage.clickOnCreateAccount();
        createAccountPage.CreateAccount(firstName, lastName, "davidsmithtest777@example.com", password, confirmPassword);   
        createAccountPage.verifyUnsuccessfulCreateAccountWithUsedEmail(existingEmailErrorMessage);     
    }
    
    @Test    
    public void verifyUnsuccessfulCreateAccountWithEmptyFirstname(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnCreateAccount();
        createAccountPage.CreateAccount("", lastName, email, password, confirmPassword);
        createAccountPage.verifyUnsuccessfulCreateAccountWithEmptyFirstname(requiredFieldErrorMessage);
    }

    @Test
    public void verifyUnsuccessfulCreateAccountWithEmptyLastname(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnCreateAccount();
        createAccountPage.CreateAccount(firstName, "", email, password, confirmPassword);
        createAccountPage.verifyUnsuccessfulCreateAccountWithEmptyLastname(requiredFieldErrorMessage);
    }

    @Test
    public void verifyUnsuccessfulCreateAccountWithEmptyEmail(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnCreateAccount();
        createAccountPage.CreateAccount(firstName, lastName, "", password, confirmPassword);
        createAccountPage.verifyUnsuccessfulCreateAccountWithEmptyEmail(requiredFieldErrorMessage);
    }

    @Test
    public void verifyUnsuccessfulCreateAccountWithEmptyPassword(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnCreateAccount();
        createAccountPage.CreateAccount(firstName, lastName, email, "", confirmPassword);
        createAccountPage.verifyUnsuccessfulCreateAccountWithInvalidPassword(requiredFieldErrorMessage);
    }

    @Test
    public void verifyUnsuccessfulCreateAccountWithInvalidPasswordLenght(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnCreateAccount();
        createAccountPage.CreateAccount(firstName, lastName, email, "p", "p");
        createAccountPage.verifyUnsuccessfulCreateAccountWithInvalidPassword(invalidPasswordLenghtErrorMessage);
    }

    @Test
    public void verifyUnsuccessfulCreateAccountWithInvalidPasswordStructure(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnCreateAccount();
        createAccountPage.CreateAccount(firstName, lastName, email, "ppppppppp", "ppppppppp");
        createAccountPage.verifyUnsuccessfulCreateAccountWithInvalidPassword(invalidPasswordStructureErrorMessage);
    }

    @Test
    public void verifyUnsuccessfulCreateAccountWithEmptyConfirmPassword(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnCreateAccount();
        createAccountPage.CreateAccount(firstName, lastName, email, password, "");
        createAccountPage.verifyUnsuccessfulCreateAccountWithInvalidConfirmPassword(requiredFieldErrorMessage);
    }

    @Test
    public void verifyUnsuccessfulCreateAccountWithNonMatchingConfirmPassword(){
        HomePage homePage = new HomePage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnCreateAccount();
        createAccountPage.CreateAccount(firstName, lastName, email, password, "differentPassTest12!");
        createAccountPage.verifyUnsuccessfulCreateAccountWithInvalidConfirmPassword(nonMatchingPasswordErrorMessage);
    }
}
