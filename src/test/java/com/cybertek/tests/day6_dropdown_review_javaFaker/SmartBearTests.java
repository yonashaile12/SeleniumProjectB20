package com.cybertek.tests.day6_dropdown_review_javaFaker;

import com.cybertek.utilities.SmartBearsUtilities;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
    //TC #1: Smart bear software link verification
        // 1.Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //maximize
        driver.manage().window().maximize();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      //2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearsUtilities.loginToSmartBear(driver);
    }
    @Test
    public void task1_login_page_links_print_test(){


        // 6.Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Count of all the link on the page = " + allLinks.size());

        // 7.Print out each link text on this page
        for(WebElement eachLink: allLinks){
            System.out.println("each link = "+ eachLink.getText());
        }
    }

    @Test
    public void task2_create_order_with_javafaker() throws InterruptedException {
        //6. Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        //quantityInput.clear();
        Thread.sleep(1000);
        quantityInput.sendKeys(Keys.BACK_SPACE );

        Thread.sleep(1000);
        quantityInput.sendKeys("2");

        //8. Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //locating all of the web elements using id
        WebElement nameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));


        //9. Fill address Info with JavaFaker
        Faker faker = new Faker();
        //• Generate: name, street, city, state, zip code
        nameInput.sendKeys(faker.name().fullName());

        streetInput.sendKeys(faker.address().streetAddress());

        cityInput.sendKeys(faker.address().city());

        stateInput.sendKeys(faker.address().state());

        zipInput.sendKeys(faker.address().zipCode().replaceAll("-",""));

        //10. Click on “visa” radio button
        WebElement visaRadio = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadio.click();

        //11. Generate card number using JavaFaker
        WebElement creditCardInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        creditCardInput.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        //Enter expiration day
        WebElement expirationInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expirationInput.sendKeys("12/25");
        //12. Click on “Process”
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        //13.Verify success message “New order has been successfully added.”
        WebElement suceessMessage = driver.findElement(By.xpath("//strong"));
        Assert.assertTrue(suceessMessage.isDisplayed(),"Success message is displayed");
    }

}
