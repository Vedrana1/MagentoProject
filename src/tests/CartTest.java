package tests;

import org.junit.Test;

import pages.CartPage;
import pages.HomePage;
import pages.WhatsNewPage;

public class CartTest extends BaseTest{

    String countryOptionValue = "RS";
    String expectedTotalPriceOfProducts = "$64.00";
    String stateInputValue = "Beograd";
    String zipCodeInputValue = "11000";

    @Test
    public void verifyTotalPrice(){
        HomePage homePage = new HomePage(driver);
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnWhatsNewLink();
        whatsNewPage.clickOnProductSize();
        whatsNewPage.clickOnProductColor();
        whatsNewPage.clickOnAddToCart();
        whatsNewPage.clickOnCartLink();
        cartPage.clickOnShippingDropdown();
        cartPage.selectDropdownOptionByValue(countryOptionValue);
        cartPage.populateStateAndZip(stateInputValue,zipCodeInputValue);
        cartPage.verifyTotalPrice(expectedTotalPriceOfProducts);
    }
    
}
