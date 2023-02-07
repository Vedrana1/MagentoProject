package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;  

    @Before
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
     
    @After
    public void teardown(){
        
        driver.quit();

    }
}
