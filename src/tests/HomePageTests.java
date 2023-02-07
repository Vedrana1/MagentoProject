package tests;

import org.junit.Test;

import pages.HomePage;

public class HomePageTests extends BaseTest{
    
    int expectedNumberOfProducts = 6;

    @Test
    public void verifyNumberOfProducts(){
        HomePage homePage = new HomePage(driver);

        homePage.goToBaseUrl();
        homePage.verifyNumberOfProducts(expectedNumberOfProducts);
    }
    
}
