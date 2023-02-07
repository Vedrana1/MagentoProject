package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage{
    public CreateAccountPage(WebDriver driver){
        super(driver);
    }

    By firstNameBy = By.id("firstname");
    By lastNameBy = By.id("lastname");
    By emailBy = By.id("email_address");
    By passwordBy = By.id("password");
    By confirmPasswordBy = By.id("password-confirmation");
    By createAccountButtonBy = By.xpath("//*[@id='form-validate']/div/div[1]/button");
    By existingEmailErrorMessageBy = By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div");
    By firstNameErrorMessageBy = By.id("firstname-error");
    By lastNameErrorMessageBy = By.id("lastname-error");
    By emailErrorMessageBy = By.id("email_address-error");
    By passwordErrorMessageBy = By.id("password-error");
    By confirmPasswordErrorMessageBy = By.id("password-confirmation-error");


    public CreateAccountPage CreateAccount(String firstName, String lastName, String email, String password, String confirmPassword){
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(emailBy, email);
        writeText(passwordBy, password);
        writeText(confirmPasswordBy, confirmPassword);
        click(createAccountButtonBy);
        return this;
    }

    public CreateAccountPage verifyUnsuccessfulCreateAccountWithUsedEmail(String expectedText){
        String errorMessage = readText(existingEmailErrorMessageBy);
        assertStringEquals(errorMessage, expectedText);
        return this;
    }

    public CreateAccountPage verifyUnsuccessfulCreateAccountWithEmptyFirstname(String expectedText){
        String errorMessage = readText(firstNameErrorMessageBy);
        assertStringEquals(errorMessage, expectedText);
        return this;
    }

    
    public CreateAccountPage verifyUnsuccessfulCreateAccountWithEmptyLastname(String expectedText){
        String errorMessage = readText(lastNameErrorMessageBy);
        assertStringEquals(errorMessage, expectedText);
        return this;
    }

    public CreateAccountPage verifyUnsuccessfulCreateAccountWithEmptyEmail(String expectedText){
        String errorMessage = readText(emailErrorMessageBy);
        assertStringEquals(errorMessage, expectedText);
        return this;
    }
    
    public CreateAccountPage verifyUnsuccessfulCreateAccountWithInvalidPassword(String expectedText){
        String errorMessage = readText(passwordErrorMessageBy);
        assertStringEquals(errorMessage, expectedText);
        return this;
    }

    public CreateAccountPage verifyUnsuccessfulCreateAccountWithInvalidConfirmPassword(String expectedText){
        String errorMessage = readText(confirmPasswordErrorMessageBy);
        assertStringEquals(errorMessage, expectedText);
        return this;
    }    
    
}
