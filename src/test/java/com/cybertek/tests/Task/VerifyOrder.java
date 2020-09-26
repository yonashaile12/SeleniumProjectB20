package com.cybertek.tests.Task;

import com.cybertek.utilities.SmartBearsUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyOrder {
    /*
    PRACTICE #4: Method: verifyOrder
    •Create a method named verify Order in SmartBearUtils class.
    •Method takes WebDriver object and String(name).
    •Method should verify if given name exists in orders.
    •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    •Create a new TestNG test to test if the method is working as expected.
    */
    WebDriver driver;

    @BeforeMethod
    public void setDriver() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearsUtilities.loginToSmartBear(driver);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    public void verify_order() throws InterruptedException {
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();

        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("ScreenSaver");

        WebElement quantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys(Keys.BACK_SPACE );
        Thread.sleep(1000);

        quantity.sendKeys("2");

        WebElement nameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        nameInput.sendKeys("Yonas Habtu");
        Thread.sleep(1000);

        WebElement streetInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        streetInput.sendKeys("12 E Lake Street");

        WebElement cityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        cityInput.sendKeys("Chicago");
        Thread.sleep(1000);

        WebElement stateInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        stateInput.sendKeys("Illinois");
        Thread.sleep(1000);

        WebElement zipCode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipCode.sendKeys("60001");
        Thread.sleep(1000);

        WebElement creditCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        creditCard.click();
        Thread.sleep(1000);

        WebElement cardInfo = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        cardInfo.sendKeys("123432123");
        Thread.sleep(1000);

        WebElement cardExpiration = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        cardExpiration.sendKeys("12/2022");
        Thread.sleep(1000);

        WebElement processOrder = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processOrder.click();
        Thread.sleep(2000);

        WebElement viewOrderList = driver.findElement(By.xpath("//li[1]//a[1]"));
        viewOrderList.click();
        Thread.sleep(1000);


        String expectedName = "Yonas Habtu";
        WebElement ActualName = driver.findElement(By.xpath("//tr[2]//td[2]"));

        Assert.assertTrue(ActualName.equals(expectedName),"Actual name and expected name are not equal");


    }

}
