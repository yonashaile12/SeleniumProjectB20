package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekURLVerification {

    public static void main(String[] args) {

        //TC #2: Cybertek verifications
        // 1.Open Chrome browser
        // I need to setup my browser driver
        WebDriverManager.chromedriver().setup();

        // To Create instance of chrome browser from webdriver.
        WebDriver driver = new ChromeDriver();

        // this line will maximize the newly opened browser page
        driver.manage().window().maximize();

        // 2.Go	to https://practice.cybertekschool.com
        driver.get("http://practice.cybertekschool.com");

        // 3.Verify	URL	contains
        // Expected: cybertekschool

        String expectedInUrl = "cybertekschool";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedInUrl)){
            System.out.println("Url verification PASSED!");
        }else{
            System.out.println("Url verification FAILED!!!");
        }

        // 4.Verify	title:
        // Expected: Practice
        // --->actual title<---  --->expected title<----
        if(driver.getTitle().equals("Practice")){
            System.out.println("Title Verification PASSED!");
        }else{
            System.out.println("Title Verification FAILED!!!");
        }


    }
}
