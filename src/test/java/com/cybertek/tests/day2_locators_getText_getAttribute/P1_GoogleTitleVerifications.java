package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerifications {

    public static void main(String[] args) {

        // TC# 1:	Google
        WebDriverManager.chromedriver().setup();
        //if you are using browsers drivers locally, you need to use System.setProperty everytime
        // we use WebDriverManager

        // TC# 3: Open	Chrome	browser2.
        //we create an instance of the chromeDriver, which also opens an empty browser for us
        WebDriver driver = new ChromeDriver();

        // TC# 4: Go	to	https://www.google.com.
        driver.get("https://www.google.com");

        // TC# 5: Verify	title:	Expected:	Google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title Verification Failed!");
        }

    }

}
