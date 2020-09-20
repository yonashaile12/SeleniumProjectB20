package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigationAndTitleVerification {

    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        // 1-Open a chrome browser
        // setting up the browse driver
        WebDriverManager.chromedriver().setup();

        //open browser and create an instance of the driver
        WebDriver driver = new ChromeDriver();

        // 2-Go to: https://google.com (www. is optional)
        driver.get("https://google.com");

        // 3-Click to Gmail from top right.
        // we are locating the gmail link web element using findElement method And linkText Locator
        driver.findElement(By.linkText("Gmail")).click();
        /*
  it looks partial string match from the web elements,
  if there are more than 1 match, it will return the first web element
  and do the action on it.
       // driver.findElement(By.partialLinkText("mail")).click();
         */


        // 4-Verify title contains:
        // Expected: Gmail
        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedInTitle)){
            System.out.println("Gmail Title verification PASSED!");
        }else{
            System.out.println("Gmail Title Verification FAILED!!!");
        }

        // 5-Go back to Google by using the .back();
        driver.navigate().back();

        // 6-Verify title equals:
        // Expected: Google

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if(actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Google Title Verification PASSED!");
        }else{
            System.out.println("Google Title Verification FAILED!!!");
        }


    }
}
