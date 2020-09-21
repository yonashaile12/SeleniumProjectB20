package com.cybertek.VyTrackTest;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VyTrack {

    @Test
    public void setupMethod() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://qa2.vytrack.com/");


        WebElement emailInputBox = driver.findElement(By.id("prependedInput"));
        emailInputBox.sendKeys("user123"); //user165

        WebElement retrievePasswordButton = driver.findElement(By.name("_password"));
        retrievePasswordButton.sendKeys("UserUser123");

        driver.findElement(By.xpath("//button[@id='_submit']")).click();
        Thread.sleep(3000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Login";

        Assert.assertEquals(actualTitle, expectedTitle);


    }
}
