package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilsPractice {

    @Test
    public void simple_google_search_test(){
        //Driver.getDriver() = driver.get("http://google.com")
        //From now on we will call the driver --> Driver.getDriver
        Driver.getDriver().get("https://google.com");

        //locating the google search box using its name attribute value
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        String search = ConfigurationReader.getProperty("searchValue");
        searchBox.sendKeys(search+ Keys.ENTER);

        //expected
        String expectedInTitle = search;
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
}
