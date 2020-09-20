package com.cybertek.tests.Task;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class DropDownSelection {

    public static void main(String[] args) {
        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");


        // 3.Verify “Simple dropdown” default selected value is correct
        // Expected: “Please select an option” // xpath  //*[@id="state"]/option[15]




        // 4.Verify“State selection” default selected value is correct
        // Expected: “Select a State”
    }

}
