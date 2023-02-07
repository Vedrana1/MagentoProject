package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    By pageTitleBy = By.xpath("//*[@id='maincontent']/div[2]/div[1]/div[1]/h1");

    public MyAccountPage verifyPageTitle(String expectedText){
        String pageTitle = readText(pageTitleBy);
        assertStringEquals(pageTitle, expectedText);
        return this;
    }
}
