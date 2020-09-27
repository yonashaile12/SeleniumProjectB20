package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilities.SmartBearsUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTablePractices {
        WebDriver driver;

        @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Default.aspx");
        SmartBearsUtilities.loginToSmartBear(driver);
    }


    // Using the verify order method from SmartBearUtilities class
    @Test
    public void task4_verify_order(){

      SmartBearsUtilities.verifyOrder(driver, "Mark Smith");
      //SmartBearsUtilities.verifyOrder(driver, "Mark Smiths"); //negative test
    }

    // Using
    @Test
    public void task5_print_names_cities(){

       SmartBearsUtilities.printNamesAndCities(driver);
    }



}
