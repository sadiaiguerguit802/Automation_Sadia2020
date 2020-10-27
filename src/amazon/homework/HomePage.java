package amazon.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePage {

    WebDriver driver = null;
    String amazonUrl=  "https://www.amazon.com/";


    @BeforeMethod
    public void setup() {
        String browserDriverPath = "BrowserDriver/windows/chromedriver.exe";
        //Initializing Chrome Browser
        System.setProperty("webdriver.chrome.driver", browserDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    //test1
   @Test(enabled = false)
    public void checktdBankUrl() throws InterruptedException {
        driver.get(amazonUrl);
        System.out.println("We Are Now Testing: " + driver.getCurrentUrl());
        String expectedamazonUrl=  "https://www.amazon.com/";
        String actualamazonUrl= driver.getCurrentUrl();
        //Validate Links
        Assert.assertEquals(actualamazonUrl, expectedamazonUrl, "Test Failed, Link Does Not Match");
        Thread.sleep(3000);
    }


    //Test2
    @Test(enabled = true)
    public void searchBestSellers() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)")).click();
        Thread.sleep(6000);
        //validate result
        String expectedResult = "Best Sellers";
        String actualResult= driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Test Failed: search keyword doe not match");

    }
    @AfterMethod
       public void tearDown(){
        driver.close();
        //driver.quit();

       }

}
