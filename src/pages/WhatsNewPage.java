package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhatsNewPage extends BasePage{
    public WhatsNewPage(WebDriver driver){
        super(driver);
    }

    By productSizeBy = By.id("option-label-size-143-item-166");
    By productColorBy = By.id("option-label-color-93-item-57");
    By addToCartButtonBy = By.xpath("//*[@id='maincontent']/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[1]/div/div/div[3]/div/div[1]/form/button");    
    By cartLinkBy = By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div/a");

    public WhatsNewPage clickOnProductSize(){
        click(productSizeBy);
        return this;
    }

    public WhatsNewPage clickOnProductColor(){
        click(productColorBy);
        return this;
    }

    public WhatsNewPage clickOnAddToCart(){
        click(addToCartButtonBy);
        return this;
    }

    // Kada se doda product u cart, nekada se desi da stranica ne prepozna da je product dodan i cart je prazan 
    // Iz tog razloga u metodi ispod sam koristila Thread.sleep da bih pauzirala izvrsavanje testa na 3 sekunde i
    // omogucila stranici da doda product u cart prije nego sto test pokusa da otvori cart i verifikuje da je product ubacen 
    public WhatsNewPage clickOnCartLink(){   
        try 
        {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }     
        click(cartLinkBy);
        return this;
    }
    
}
