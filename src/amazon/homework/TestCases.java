package amazon.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCases {

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
    public void checkAmazonUrl() throws InterruptedException {
            driver.get(amazonUrl);
            System.out.println("We Are Now Testing: " + driver.getCurrentUrl());
            String expectedamazonUrl=  "https://www.amazon.com/";
            String actualamazonUrl= driver.getCurrentUrl();
            //Validate Links
            Assert.assertEquals(actualamazonUrl, expectedamazonUrl, "Test Failed, Link Does Not Match");
            Thread.sleep(3000);
        }


    //Test2(failed)
    @Test(enabled = false)
    public void checkAmazonUrl1() throws InterruptedException {
        driver.get(amazonUrl);
        System.out.println("We Are Now Testing: " + driver.getCurrentUrl());
        String expectedamazonUrl=  "https://www.amazon.coom/";
        String actualamazonUrl= driver.getCurrentUrl();
        //Validate Links
        Assert.assertEquals(actualamazonUrl, expectedamazonUrl, "Test Failed, Link Does Not Match");
        Thread.sleep(3000);
    }
    //test3
    @Test(enabled = false)
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
    //Test4
    @Test(enabled = false)
    public void changLanguage() throws InterruptedException {
        driver.get(amazonUrl);
        //navigate to the flag icon
        driver.findElement(By.cssSelector("#icp-nav-flyout > span > span.nav-line-2 > span.nav-icon.nav-arrow")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]/span/span[2]/span[2]")).click();
        Thread.sleep(5000);
        //validate
        String expectedResult="Language Settings";
        //String actualResult=driver.findElement(By.id("lop-heading-wrap")).getText();
        String actualResult=driver.findElement(By.xpath("//span[@id='lop-heading']")).getText();
        Assert.assertEquals(expectedResult, actualResult, "test fail: language setting not shows");

    }

    //Test5
    @Test(enabled = false)
    public void amazonGiftCards() throws InterruptedException {
        driver.get(amazonUrl);
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#nav-subnav > a.nav-a.nav-b.nav-hasArrow > span.nav-arrow")).click();
        Thread.sleep(4000);
        //validate test
        String expectedResult= "Gift Cards";
        String actualResult=driver.findElement(By.cssSelector("#nav-subnav > a.nav-a.nav-b.nav-hasArrow > span.nav-a-content")).getText();
        Assert.assertEquals(expectedResult, actualResult, "test fail: Gift Card does not exist");
    }

    //Test6
    @Test(enabled = false)
    public void tryPrime() throws InterruptedException {

        driver.get(amazonUrl);
        driver.findElement(By.cssSelector("#nav-link-prime > span")).click();
        Thread.sleep(2000);
        //validate test
        String expectedResult = "Try Prime";
        //String actualResult = driver.findElement(By.xpath("//*[@id=\"nav-link-prime\"]/span")).getText();
        String actualResult = driver.findElement(By.xpath("//span[@class='nav-line-2 ']")).getText();
        Assert.assertEquals(expectedResult, actualResult, "test fail: the Try Prime does not match");

    }

    //Test7
    @Test(enabled = false)
    public void accountAndLists() throws InterruptedException {
        driver.get(amazonUrl);
        driver.findElement(By.id("nav-link-accountList")).click();
        Thread.sleep(2000);

        //validate test
        String expectedResult = "Sign-In";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1")).getText();
        Assert.assertEquals(expectedResult, actualResult, "test fail: the Sign-In does not match");

    }

    //Test8
    @Test(enabled = false)
    public void amazonIcon() throws InterruptedException {
        driver.get(amazonUrl);
        //I will test icon previous rounded
        driver.findElement(By.cssSelector("#gw-desktop-herotator > div > div > div > div.a-carousel-col.a-carousel-left.celwidget > a > i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-previous-rounded']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"gw-desktop-herotator\"]/div/div/div/div[1]/a/i")).click();
        Thread.sleep(2000);
        //it will test icon next rounded
        driver.findElement(By.xpath("//*[@id=\"gw-desktop-herotator\"]/div/div/div/div[3]/a/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#gw-desktop-herotator > div > div > div > div.a-carousel-col.a-carousel-right.celwidget > a > i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-next-rounded']")).click();
        Thread.sleep(2000);
    }

    //test9
    @Test(enabled = true)
    public void amazonSearchBox() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);
        // Enter "Halloween Costumes" in searchBox WebEdit Field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Halloween Costumes");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        Thread.sleep(2000);
        //validate result
        String expectedResult = "\"Halloween Costumes\"";
        //String actualResult= driver.findElement(By.cssSelector("#search > span > div > span > h1 > div > div.sg-col-14-of-20.sg-col-26-of-32.sg-col-18-of-24.sg-col.sg-col-22-of-28.s-breadcrumb.sg-col-10-of-16.sg-col-30-of-36.sg-col-6-of-12 > div > div > span.a-color-state.a-text-bold")).getText();
        String actualResult= driver.findElement(By.xpath("//span[text()='\"Halloween Costumes\"']")).getText();

        Assert.assertEquals(actualResult, expectedResult, "Test Failed: search keyword doe not match");
    }

    //Test10
    @Test(enabled = false)
    public void searchBox1() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);

        // Enter "masks" in searchBox WebEdit Field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("masks for coronavirus protection");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        Thread.sleep(2000);
        //validate result
        String expectedResult = "\"masks for coronavirus protection\"";
        String actualResult= driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Test Failed: search keyword masks does not match");
    }
    //Test11
    @Test(enabled = false)
    public void searchBox2() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);
        ////driver.get(amazonUrl);
        // Enter "jewelery" in searchBox WebEdit Field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("jewlery");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        Thread.sleep(2000);
        //validate result
        String expectedResult = "\"jewlery\"";
        String actualResult= driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Test Failed: search keyword masks does not match");
    }

    //test12
    @Test(enabled = false)
    public void searchBox3() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);
        // Enter "Laptop HP" in searchBox WebEdit Field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop HP");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        Thread.sleep(2000);
        //validate result
        String expectedResult = "\"Laptop HP\"";
        String actualResult= driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Test Failed: search keyword masks does not match");

    }

    //Test13
    @Test(enabled = false)
    public void amazonRegistry() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(10)")).click();
        Thread.sleep(2000);
        //validate result
        String expectedResult = "Registry";
        String actualResult= driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[9]")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Test Failed: search keyword masks does not match");

    }
    //Test14
    @Test(enabled = false)
    public void shoppingCart() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);
        //click on shopping cart
        driver.findElement(By.cssSelector("#nav-cart")).click();
        Thread.sleep(2000);
        //validate result
        String expectedResult = "Cart";
        String actualResult = driver.findElement(By.cssSelector("#nav-cart-text-container > span.nav-line-2")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Test Failed: search keyword masks does not match");
    }

    //Test15
    @Test(enabled = false)
    public void CustomerService() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);
        //click on Customer service
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(5)")).click();
        Thread.sleep(2000);
        //validate result
        String expectedResult = "Some things you can do here";
        String actualResult = driver.findElement(By.cssSelector("body > div:nth-child(28) > div.a-section.a-spacing-base.ss-landing-container-wide > h2")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Test Failed: search keyword Some things you can do here does not match");

    }

    //Test16
    @Test(enabled = false)
    public void amazonSearchIn() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);
        driver.findElement(By.cssSelector("#nav-search-dropdown-card > div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"nav-search-dropdown-card\"]/div")).click();
        Thread.sleep(2000);
        //validate result
        String expectedResult = "All";
       // String actualResult = driver.findElement(By.xpath("//*[@id=\"nav-search-dropdown-card\"]/div/div")).getText();
        String actualResult = driver.findElement(By.xpath("//div[@class='nav-search-facade']")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Test Failed: search keyword Books does not match");

    }
    //Test17
    @Test(enabled = false)
    public void signingWithAmazon() throws InterruptedException {
        //Open Browser and navigate to amazon URL
        driver.get(amazonUrl);
        //click on hello sign
        driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).click();
        Thread.sleep(2000);
        //put you email or Phone number
        driver.findElement(By.cssSelector("#ap_email")).sendKeys("silineifri2017@yahoo.com");
        Thread.sleep(2000);
        //click on countinue bottun
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        Thread.sleep(3000);
        //navigate to password
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Sali82");
        Thread.sleep(3000);
        // Click submit/signIn button
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        Thread.sleep(3000);
    }

    //Test18
    @Test(enabled = false)
    public void checkTitle(){
       // webdriver driver = new ChromeDriver();
        driver.get(amazonUrl);
        String expectedTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle= driver.getTitle();
        //validate the title
        Assert.assertEquals(actualTitle, expectedTitle, "test pass the title found");
    }

    //Test19(Failed)
    @Test(enabled = false)
    public void checkTitle1(){
        // webdriver driver = new ChromeDriver();
        driver.get(amazonUrl);
        String expectedTitle="Amazon.com: Online Shopping for Electronics, jewelery, Computers, Books, DVDs & more";
        String actualTitle= driver.getTitle();
        //validate the title
        Assert.assertEquals(actualTitle, expectedTitle, "test fail the title not found");
    }

    //Test20
    @Test(enabled = false)
    public void holidaysDeals() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)")).click();
        Thread.sleep(2000);
        //validate result
        String expectedResult = "Holiday Deals";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Test pass: search keyword holiday deal is match");
    }

    //Test21
    @Test(enabled = false)
    public void newReleases() throws InterruptedException {
    //open Chrome and navigate amazon url
    driver.get(amazonUrl);
    driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(6)")).click();
    Thread.sleep(2000);
    //validate result
    String expectedResult = "Amazon Hot New Releases";
    String actualResult = driver.findElement(By.xpath("//*[@id=\"zg_banner_text_wrapper\"]")).getText();
    Assert.assertEquals(actualResult, expectedResult, "Test pass: search keyword holiday deal is match");
}

//Test22
    @Test(enabled = false)
    public void wholeFoods() throws InterruptedException {
        //open Chrome and navigate amazon url
        driver.get(amazonUrl);
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(8)")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[5]")).click();
        Thread.sleep(5000);
        //validate result
        String expectedResult = "Food";
        String actualResult = driver.findElement(By.xpath("//div[@class='fmc-local-page-header']")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Test pass: search keyword holiday deal is match");

    }

        @AfterMethod
        public void TearDown(){
            driver.close();
            //driver.quit();
        }


    }

