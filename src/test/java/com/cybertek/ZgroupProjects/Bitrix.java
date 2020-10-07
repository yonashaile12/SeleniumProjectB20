package com.cybertek.ZgroupProjects;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Bitrix {
/**
 US#2 AC#4. (Automation) User should be able to create a quote by clicking on the comma
 */

    WebDriver driver;

    @BeforeMethod
    public void login_to_bitrix_page(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com/");
        driver.manage().window().maximize();


        WebElement userName = driver.findElement(By.xpath("//div[1]/input[1]"));
        userName.sendKeys("helpdesk5@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//div[2]/input[1]"));
        password.sendKeys("UserUser");

        WebElement login = driver.findElement(By.className("login-btn"));
        login.click();
        /*
        //User should be able to create a quote by clicking on the Comma icon.
        //WebElement taskButton = driver.findElement(By.xpath());
         */

    }

    @Test
    public void task_button(){
        /**
        user should be able to click on task and should be able to see "Things to do"
        Given I am on the "Activity Stream"
        When I click on the "Task" button
        Then I should be able to see "Things to do"
         */
        WebElement taskButton = driver.findElement(By.xpath("(//span[.='Task'])[2]"));
        taskButton.click();
        BrowserUtils.wait(2);
        /**
        When I hover to the bottom of the blank message page
        Then I should be able to locate "Quote text" button
        Then I should be able click "Quote text
         */
        driver.findElement(By.xpath("(//span[@title='Quote text'])[2]")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.name("ACTION[0][ARGUMENTS][data][TITLE]")).sendKeys("Automating User story 2");

        driver.switchTo().frame(1);

        WebElement creatingQoute = driver.findElement(By.className("bxhtmled-quote"));
        creatingQoute.sendKeys("user should be able to create a quote by clicking ,, \"Quote text\"");
        /**
        Then I should be able to see an edit box
        Then I should be able to create a quote by clicking "send" button
         */
        String actualValue = creatingQoute.getText();
        String expectedValue = "user should be able to create a quote by clicking ,, \"Quote text\"";

        Assert.assertEquals(actualValue,expectedValue,"Message is not displayed. Verification FAILED!!!");

    }


}
