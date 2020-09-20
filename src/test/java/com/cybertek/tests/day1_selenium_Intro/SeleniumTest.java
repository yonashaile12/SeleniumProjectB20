package com.cybertek.tests.day1_selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        //1-set up web driver
        WebDriverManager.chromedriver().setup();

        //2- create the instance of the chrome driver
        WebDriver driver = new ChromeDriver();

        // this will maximize
        driver.manage().window().maximize();

        //3- test the driver is working
        driver.get("https://www.google.com");

        System.out.println("the title of the webpage is: " + driver.getTitle());

        String actualTitle = driver.getTitle();

        String actualURL = driver.getCurrentUrl();

        System.out.println("actualURL = " + actualURL);

        Thread.sleep(1000);

        driver.navigate().back();

        Thread.sleep(1000);

        driver.navigate().forward();

        Thread.sleep(1000);

        driver.navigate().refresh();

        Thread.sleep(1000);

        driver.navigate().to("https://www.facebook.com");

        String pageSource = driver.getPageSource();

        System.out.println("pageSource = " + pageSource);

        driver.close();




    }
}
