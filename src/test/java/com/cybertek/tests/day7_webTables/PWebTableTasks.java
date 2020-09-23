package com.cybertek.tests.day7_webTables;

import com.cybertek.utilities.SmartBearsUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PWebTableTasks {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Default.aspx");
        SmartBearsUtilities.loginToSmartBear(driver);
    }
    /*
    TC#3: Smartbear software order verification
    1.Open browser and login to Smartbear software
    2.Click on View all orders
    3.Verify Susan McLaren has order on date “01/05/2010”
     */

    @Test
    public void p3_verify_susans_order_date(){
        WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
        System.out.println("Susan Date = "+susansDate.getText());

        String actualResult = "01/05/2010";
        String expectedResult = susansDate.getText();

        Assert.assertTrue(actualResult.equals(expectedResult),"Actual date is not equal to expected date");

        Assert.assertEquals(actualResult,expectedResult,"Actual date is not equal to expected date");

        //Assert.fail();
    }
}
