package com.cybertek.tests.day6_dropdown_review_javaFaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values

public class DropdownTasks {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //open a new browser
        driver = WebDriverFactory.getDriver("chrome");
        //maximize the page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the page
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    //TC #2: Selecting state from State dropdown and verifying result
    @Test
    public void test2_verify_state_dropdown() throws InterruptedException{
        // we need to locate the dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois --> selecting by visible text
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia --> selecting by value
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        //5. Select California --> select by index
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        //6. Verify final selected option is California.
        String expectedResult = "California";
        String actualResult = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult, expectedResult, "Actual vs expected is not equal!");

        //Use all Select options. (visible text, value, index)

    }
}
