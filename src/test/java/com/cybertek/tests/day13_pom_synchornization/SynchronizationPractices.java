package com.cybertek.tests.day13_pom_synchornization;

import com.cybertek.pages.Loading7Page;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SynchronizationPractices {

    ////TC#40 : Dynamically Loaded Page Elements 7
    ////1. Go to http://practice.cybertekschool.com/dynamic_loading/7
    ////2. Wait until title is "Dynamic Title"
    ////3. Assert : Message "Done" is displayed.
    ////4. Assert : Image is displayed.
    ////Note: Follow POM
    @Test
    public void p40_dynamic_title_test() {
        String url = "http://practice.cybertekschool.com/dynamic_loading/7";
        Driver.getDriver().get(url);

        //creating the object to be able to use webelement
        Loading7Page loading7Page = new Loading7Page();

        //Using WebDriverWait to create explicit wait until title changes
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //we need to use the object 'wait' to SETUP OUR EXPECTED CONDITION
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //assert that message is displayed
        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());

    }
}
