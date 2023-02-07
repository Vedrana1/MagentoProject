package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver){
        super(driver);
    }

    By productTitleBy = By.xpath("//*[@id='shopping-cart-table']/tbody/tr[1]/td[1]/div/strong");      
    By totalPriceBy = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span");
    By estimateShippingDropdownBy = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[1]/div[1]");
    By countryDropdownBy = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[1]/div[2]/form[1]/fieldset/div[1]/div/select");
    By stateInputBy = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[1]/div[2]/form[1]/fieldset/div[3]/div/input");
    By zipInputBy = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[1]/div[2]/form[1]/fieldset/div[4]/div/input");
    By flatRateFixedBy = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[2]");    


    public CartPage verifySuccessfulAddProduct(String expectedText){
        String actualText = readText(productTitleBy);
        assertStringEquals(actualText, expectedText);
        return this;
    }
    
    // Ovdje sam koristila i waitVisibility metodu iz BasePage-a kako bih sacekala da Dropdown bude vidljiv prije nego sto
    // test pokusa da klikne na taj dropdown
    // Test je u protivnom pucao, jer nije mogao da nadje dropdown na koji treba da klikne
    public CartPage clickOnShippingDropdown(){
        waitVisibility(estimateShippingDropdownBy);
        click(estimateShippingDropdownBy);
        return this;
    }    

    public CartPage clickOnCountryDropdown(){        
        click(countryDropdownBy);
        return this;
    }

    public CartPage selectDropdownOptionByValue(String value){
        selectDropdownOptionByValue(countryDropdownBy, value);
        return this;
    }

    public CartPage populateStateAndZip(String state, String zipCode){           
        writeText(stateInputBy, state);
        writeText(zipInputBy, zipCode);        
        return this;
    }

    // Kada se doda zemlja za dostavu na Cart stranici, treba da prodje par sekundi da bi se na cijenu dodala i taksa
    // Iz tog razloga u metodi ispod sam koristila Thread.sleep da bih pauzirala izvrsavanje testa na 3 sekunde i
    // omogucila stranici da izracuna ukupnu cijenu prije nego sto test pokusa da je procita i verifikuje 
    public CartPage verifyTotalPrice(String expectedPrice){
        try 
        {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        String actualPrice = readText(totalPriceBy);
        assertStringEquals(actualPrice, expectedPrice);
        return this;
    }
}
