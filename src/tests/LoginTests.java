package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginTests extends BaseTest {

    String validEmail = "davidsmithtest717171@example.com";
    String validPassword = "davidsmith123!";
    String requiredFieldErrorMessage = "This is a required field.";
    String incorrectCaptchaErrorMessage = "Incorrect CAPTCHA";
    String blockedAccountErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
    String invalidEmail = "test@example.com";
    String invalidPassword = "testtest123";
    String logoutTitle = "You are signed out";  
      

    @Test
    public void verifySuccessfulLogin(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);       

        homePage.goToBaseUrl();
        homePage.clickOnSignIn();
        loginPage.Login(validEmail, validPassword);
        homePage.clickOnDropdownButton();
        homePage.verifySuccessfulLogin();
    }

    @Test
    public void verifyEmptyEmailLoginAttempt(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);       

        homePage.goToBaseUrl();
        homePage.clickOnSignIn();
        loginPage.Login("", validPassword);
        loginPage.verifyUnsuccessfulLoginWithEmptyEmail(requiredFieldErrorMessage);
    }

    @Test
    public void verifyEmptyPasswordLoginAttempt(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);       

        homePage.goToBaseUrl();
        homePage.clickOnSignIn();
        loginPage.Login(validEmail, "");
        loginPage.verifyUnsuccessfulLoginWithEmptyPassword(requiredFieldErrorMessage);
    }  

    @Test
    public void verifyInvalidEmailLoginAttempt(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);       

        homePage.goToBaseUrl();
        homePage.clickOnSignIn();
        loginPage.Login(invalidEmail, validPassword);
        // Ovdje saljem dva parametra, zato sto postoji mogucnost da se pojave dvije razlicite poruke, a u oba slucaja test treba da prodje
        loginPage.verifyUnuccessfulLoginWithInvalidData(incorrectCaptchaErrorMessage, blockedAccountErrorMessage);
    }

    @Test
    public void verifyInvalidPasswordLoginAttempt(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);       

        homePage.goToBaseUrl();
        homePage.clickOnSignIn();
        loginPage.Login(validEmail, invalidPassword);
        // Ovdje saljem dva parametra, zato sto postoji mogucnost da se pojave dvije razlicite poruke, a u oba slucaja test treba da prodje
        loginPage.verifyUnuccessfulLoginWithInvalidData(incorrectCaptchaErrorMessage, blockedAccountErrorMessage);
    }

    @Test
    public void verifySuccessfulLogout(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);   
        LogoutPage logoutPage = new LogoutPage(driver);   

        homePage.goToBaseUrl();
        homePage.clickOnSignIn();
        loginPage.Login(validEmail, validPassword);       
        homePage.clickOnDropdownButton();
        homePage.clickOnSignOut();
        logoutPage.verifySuccessfulLogout(logoutTitle);
    }

}
