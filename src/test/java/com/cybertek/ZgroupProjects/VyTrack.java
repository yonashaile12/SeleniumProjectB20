package com.cybertek.ZgroupProjects;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class VyTrack {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/");
        driver.manage().window().maximize();
        WebElement emailInputBox = driver.findElement(By.id("prependedInput"));
        emailInputBox.sendKeys("user165"); //user165
        WebElement retrievePasswordButton = driver.findElement(By.name("_password"));
        retrievePasswordButton.sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
        Thread.sleep(3000);
    }
    @Test
    public void test1_vehicle_odometerPage()throws InterruptedException{
        WebElement fleetModule = driver.findElement(By.linkText("Fleet"));
        fleetModule.click();
        Thread.sleep(1000);
        WebElement vehicleOdometer = driver.findElement(By.xpath("//span[contains(text(),'Vehicle Odometer')]"));
        vehicleOdometer.click();
        Thread.sleep(3000);
        WebElement SelectVehicle = driver.findElement(By.xpath("//tr[6]//td[4]"));
        SelectVehicle.click();
        Thread.sleep(2000);
        WebElement editButton = driver.findElement(By.xpath("//*[@id='container']/div[2]/div[1]/div/div/div[1]/div[1]/div[1]/a"));
        editButton.click();
    }
}


