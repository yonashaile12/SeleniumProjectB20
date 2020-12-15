package com.cybertek.tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JsPractice {
    WebDriver driver;
    @Test
    public void scrollingTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        WebElement link = driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);

        js.executeScript("arguments[0].scrollIntoView(true);"+
                            "arguments[0].click()", link);

        Thread.sleep(2000);

        driver.close();

    }
}
