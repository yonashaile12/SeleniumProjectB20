package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_EtsyTitleVerification {

    public static void main(String[] args) {

        //TC #5: EtsyTitle Verification
        // 1.Open Chrome browser
        // 2.Go to https://www.etsy.com

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com");

        // 3.Search for “wooden spoon”
        // we need first to find the search box
        // send keys "wooden spoon"
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon" + Keys.ENTER);

        // 4.Verify title:
        // Expected: “Wooden spoon | Etsy”

        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Etsy title Verification PASSED!");
        }else{
            System.out.println("Etsy title Verification FAILED!!!");
        }



    }
}
