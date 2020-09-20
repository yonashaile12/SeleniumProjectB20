package com.cybertek.tests.day5_testNG_Intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Practices {
        WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
         driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();

         //waits until the page is loaded for the given time.
         //it will wait up to 15 seconds, if page is loaded before that it will continue
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

         // 1-go to google
        driver.get("https://www.google.com");
    }

    @Test
    public void google_title_verification(){

        //2-Verify title is google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"Titles are not matching!");

    }
    @Test
    public void google_search_title_verification(){
        //go to google
        System.out.println("google_serach_title_verification is running...");
        //search apple
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple"+ Keys.ENTER);

        //make sure title contains apple
        String expectedInTitle = "apple";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle),"Title does not contain search value.");

    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
