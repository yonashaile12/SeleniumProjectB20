package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F4_AttributeValueVerification {
    public static void main(String[] args) throws InterruptedException {
        //TC #4: Facebook header verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        //creating an instance variable
        WebDriver driver = new ChromeDriver();

        // 2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");


        // 3.Verify “Create a page” link href value contains text:
        // Expected: “registration_form”
        String expectedInAttribute = "registration_form";
        String actualAttribute = driver.findElement(By.linkText("Create a Page")).getAttribute("href");

        System.out.println("actualAttribute = " + actualAttribute);
        System.out.println("expectedInAttribute = " + expectedInAttribute);

        if(actualAttribute.equals(expectedInAttribute)){
            System.out.println("Attribute value Verification Passed!");
        }else{
            System.out.println("Attribute Value Verification Failed!");
        }






    }
}
