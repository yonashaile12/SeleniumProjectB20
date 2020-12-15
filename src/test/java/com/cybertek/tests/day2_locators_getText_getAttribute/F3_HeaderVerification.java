package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F3_HeaderVerification {

    public static void main(String[] args) {
        //TC #3: Facebook header verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // 2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        // 3.Verify header text is as expected:
        // Expected: “Connect with friends and the world around you on Facebook.”

        String expectedHeaderText = "Connect with friends and the world around you on Facebook.";
        String actualHeaderText = driver.findElement(By.className("_8eso")).getText();
        //driver.findElement(By.className("_8eso"));

        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header verification Passed!");
        }else{
            System.out.println("Header Verification Failed!");
        }

        driver.close();
    }
}
