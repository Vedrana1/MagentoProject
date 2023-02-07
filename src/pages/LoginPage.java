package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage (WebDriver driver){
        super(driver);
    }
    
    By emailBy = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[2]/div/input");
    By passwordBy = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[3]/div/input");
    By signInLinkBy = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button");
    By emptyEmailErrorMessageBy = By.id("email-error");
    By emptyPasswordErrorMessageBy = By.id("pass-error");    
    By invalidEmailAndPasswordMessageBy = By.xpath("//*[@id='maincontent']/div[2]/div[2]/div/div/div");

    public LoginPage Login(String email, String password){
        writeText(emailBy, email);
        writeText(passwordBy, password);
        click(signInLinkBy);
        return this;
    }

    public LoginPage verifyUnsuccessfulLoginWithEmptyEmail(String expectedText){        
        String actualText = readText(emptyEmailErrorMessageBy);
        assertStringEquals(actualText, expectedText);
        return this;
    }
    public LoginPage verifyUnsuccessfulLoginWithEmptyPassword(String expectedText){
        String actualText = readText(emptyPasswordErrorMessageBy);
        assertStringEquals(actualText, expectedText);
        return this;
    }

    // Ova metoda prima dva parametra, tj dvije razlicite poruke
    // Razlog za to jeste sto ukoliko nekoliko puta pokrecemo testove za neuspjesan login, stranica blokira nalog korisnika
    // U tom slucaju, prikazuje se drugacija poruka
    // Za nas, ako se bilo koja od te dvije poruke pojave, test je prosao
    // Zato u metodi ispod poredim obije poruke koje se mogu pojaviti
    public LoginPage verifyUnuccessfulLoginWithInvalidData(String expectedText1, String expectedText2){
        String actualText = readText(invalidEmailAndPasswordMessageBy);
        try {
            assertStringEquals(actualText, expectedText1);
        }
        catch (AssertionError e) {
            assertStringEquals(actualText, expectedText2);
        }
        
        return this;
    }
}
