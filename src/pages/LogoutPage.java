package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage{
    public LogoutPage (WebDriver driver){
        super(driver);
    }

    By logoutTitleBy = By.xpath("/html/body/div[2]/main/div[1]/h1/span");

    public LogoutPage verifySuccessfulLogout(String expectedText){
        String actualText = readText(logoutTitleBy);
        assertStringEquals(actualText, expectedText);
        return this;
    }
    
}
