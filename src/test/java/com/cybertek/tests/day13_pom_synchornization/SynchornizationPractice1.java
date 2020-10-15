package com.cybertek.tests.day13_pom_synchornization;

import com.cybertek.pages.DynamicLoading1;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SynchornizationPractice1 {

    /*
    TC#41: Dynamically Loaded Page Elements 1
    1.Go to http://practice.cybertekschool.com/dynamic_loading/1
    2.Click to start
    3.Wait until loading bar disappears
    4.Assert username input box is displayed
    5.Enter username: tom smith
    6.Enter password: incorrect password
    7.Click to Submit button
    8.Assert “Your username is invalid!” text is displayed.
    Note: Follow POM
     */



    @Test
    public void p41_loading_negative_test(){

        String url = "http://practice.cybertekschool.com/dynamic_loading/1";
        Driver.getDriver().get(url);

        DynamicLoading1 dynamicLoading1 = new DynamicLoading1();
        dynamicLoading1.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(dynamicLoading1.userNameInputBox));

        Assert.assertTrue(dynamicLoading1.userNameInputBox.isDisplayed(), "UserNameInputBox was not displayed!");

        dynamicLoading1.userNameInputBox.sendKeys("tomsmith");
        dynamicLoading1.paswordInputBox.sendKeys("incorrectpassword");
        dynamicLoading1.submitButton.click();

        Assert.assertTrue(dynamicLoading1.InvalidPasswordText.isDisplayed(), "InvalidPasswordText verification failed!");










    }
}
