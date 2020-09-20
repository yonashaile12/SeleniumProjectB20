package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Amazon_CssSelector {

    public static void main(String[] args) {

        //TC #3: Amazon link number verification
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2. Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        // 3. Enter search term (use cssSelector to locate search box)
       // WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        WebElement searchBox = driver.findElement(By.cssSelector("input[id=twotabsearchtextbox]"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        // 4. Verify title contains search term


    }
}
