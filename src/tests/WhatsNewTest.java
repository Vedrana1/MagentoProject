package tests;

import org.junit.Test;

import pages.CartPage;
import pages.HomePage;
import pages.WhatsNewPage;

public class WhatsNewTest extends BaseTest{

    String productTitle = "Phoebe Zipper Sweatshirt";
    

    @Test
    public void verifySuccessfulAddToCartProduct(){
        HomePage homePage = new HomePage(driver);
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.goToBaseUrl();
        homePage.clickOnWhatsNewLink();
        whatsNewPage.clickOnProductSize();
        whatsNewPage.clickOnProductColor();
        whatsNewPage.clickOnAddToCart();
        whatsNewPage.clickOnCartLink();
        cartPage.verifySuccessfulAddProduct(productTitle);
    }
}
