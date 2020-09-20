package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
