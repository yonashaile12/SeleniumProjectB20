package com.cybertek.utilities;

import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearsUtilities {
    //Mini-Task:
    //1-Create a method called loginToSmartBear
    //2-create a static method called loginToSmartBear
    //2-This method simply logs in to SmartBear when you call it.
    //3-Accepts WebDriver type as parameter

    public static void loginToSmartBear(WebDriver driver){
        // 3.Enter username: “Tester”
        WebElement userNameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        userNameInput.sendKeys("Tester");

        // 4.Enter password: “test”
        WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordInput.sendKeys("test");

        // 5.Click to Login button
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();
    }


    /*
    PRACTICE #4: Method: verifyOrder
    •Create a method named verifyOrder in SmartBearUtils class.
    •Method takes WebDriver object and String(name).
    •Method should verify if given name exists in orders.
    •This method should simply accepts a name(String), and assert whether
    given name is in the list or not.
    •Create a new TestNG test to test if the method is working as expected.
     */
    public static void verifyOrder(WebDriver driver, String name){

        //created a locatr that only return the names of the customer from all of the rows
        //Created a list and stored the cells that has name information into it.
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //if thet is only one table on the page, you don't have to locate the table ---> //tr/td[2]
        //List<WebElement> namesList = driver.findElements(By.xpath("//tr/td[2]")

        //typr iter press tab for "for each"m loop short cut
        for (WebElement each : namesList) {

            if(each.getText().equalsIgnoreCase(name)){
                Assert.assertTrue(each.getText().equalsIgnoreCase(name));
                return;
            }

        }
        //Assert.fail method will fail the test when it is called, no matter what.
        Assert.fail("Name does not exist in the list! Verification Failed!!!");




    }
}
