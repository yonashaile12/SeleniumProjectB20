package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.tests.Base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.SmartBearsUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SmartBearPractices9_10_11 extends TestBase {
/*
    WebDriver driver;

    @BeforeMethod

    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
    */

    /*
    TC #9: SmartBear delete order
    1.Open browser and login to SmartBear
    2.Delete “Mark Smith” from the list
    3.Assert it is deleted from the list
     */

    @Test
    public void delete_order_task() throws IOException {

        //Creating properties objhect to be able to read properties file
        Properties properties = new Properties();

        //Opening the file in JVM memory using FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        //Loading the file into properties object
        properties.load(file);

        //--->URL FROM CONFIGURATION PROPERTIES
        String url = properties.getProperty("smartbearUrl"); //returning url configuration properties

        driver.get(url);
        SmartBearsUtilities.loginToSmartBear(driver);
        //locate the checkbox for 'Mark Smith' and click to it
        WebElement markSmithCheckBox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));
        markSmithCheckBox.click();
        BrowserUtils.wait(1);
        //locate 'Delete Selected' button and click to it

        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();
        //Assert 'Mark Smith' is not in the table

        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each : namesList) {
            Assert.assertFalse(each.getText().equals("Mark Smith"));
        }

    }
}
