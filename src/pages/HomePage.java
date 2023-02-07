package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }

    By inventoryItemBy = By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[3]/div/div/ol/li");
    By createAccountLinkBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    By signInLinkBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]");
    By welcomeTitleBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span");
    By dropdownButtonBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]");
    By signOutLinkBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");    
    By whatsNewLinkBy = By.id("ui-id-3");

    String baseUrl = "https://magento.softwaretestingboard.com/";

    public HomePage goToBaseUrl(){
        driver.get(baseUrl);
        return this;
    }
    
    public HomePage verifyNumberOfProducts(int expectedNumber){
        int actualNumber = countItems(inventoryItemBy);
        assertIntegerEquals(expectedNumber, actualNumber);
        return this;
    }

    public HomePage clickOnCreateAccount(){
        click(createAccountLinkBy);
        return this;
    }

    public HomePage clickOnSignIn(){
        click(signInLinkBy);
        return this;
    }

    public HomePage verifySuccessfulLogin(){
        assertElementVisible(signOutLinkBy);
        return this;
    }

    // Metoda ispod treba da klikne na dropdown u meniju gdje se nalazi Sign Out opcija
    // Taj dropdown je u stvari <li>
    // Taj <li> mijenja mjesta u <ul> dok se svi elementi ne ucitaju, i zato je jako tesko locirati taj konkretan <li>
    // Zbog toga u metodi ispod koristim waitVisibility is BasePage-a da bi test sacekao da se ucita prvi <li> u listi prije nego sto klikne na taj dropdown
    public HomePage clickOnDropdownButton(){
        waitVisibility(welcomeTitleBy); 
        click(dropdownButtonBy);
        return this;
    }

    public HomePage clickOnSignOut(){
        click(signOutLinkBy);
        return this;
    }
    

    public HomePage clickOnWhatsNewLink(){
        click(whatsNewLinkBy);
        return this;
    }

}
