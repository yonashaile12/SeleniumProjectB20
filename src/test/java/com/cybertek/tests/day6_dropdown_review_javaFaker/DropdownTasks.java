package com.cybertek.tests.day6_dropdown_review_javaFaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
//TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values

public class DropdownTasks {
    WebDriver driver;
            /*
    @BeforeClass
    public void setupClass(){
        //open a new browser
        driver = WebDriverFactory.getDriver("chrome");
    }
 */
            /*
    @AfterMethod
    public void aftermethodClass(){
        driver.close();
    }
     */
    @BeforeMethod
    public void setupMethod(){
        //open a new browser
        driver = WebDriverFactory.getDriver("chrome");
        //maximize the page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the page
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    //TC #2: Selecting state from State dropdown and verifying result
    @Test
    public void test2_verify_state_dropdown() throws InterruptedException{
        // we need to locate the dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois --> selecting by visible text
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia --> selecting by value
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        //5. Select California --> select by index
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        //6. Verify final selected option is California.
        String expectedResult = "California";
        String actualResult = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult, expectedResult, "Actual vs expected is not equal!");
        //Use all Select options. (visible text, value, index)

    }

    @Test
    public void test3_date_dropdown_verification(){
        //TC #3: Selecting date on dropdown and verifying
        // 1.Open Chrome browser2.Go to http://practice.cybertekschool.com/dropdown
        //locate all webelements/drodowns
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        // 3.Select “December 1st, 1921” and verify it is selected.
        // Selecting year using text:
        yearDropdown.selectByVisibleText("1921");

        //selecting month using value attribute
        monthDropdown.selectByValue("11");

        //selecting day using index
        dayDropdown.selectByIndex(0);


        //creating expec ted values in one place
        String expectedYear = "1921";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting our actual values from the web page
        String actualyear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //creating assert line
        Assert.assertEquals(actualyear,expectedYear,"actualYear vs expectedYear not equal");
        Assert.assertEquals(actualMonth,expectedMonth, "actual month vs expected month not equal");
        Assert.assertTrue(actualDay.equals(expectedDay),"actual day vs expectedday not eqaul");




    }

    @Test
    public void test4_multiple_value_select_dropdown(){

        // 3.Select all the options from multiple select dropdown.
        //locate the dropdown
        Select multipleSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        //creating a list of webElements to store all of the options inside of this dropdown
        List<WebElement> allOptions = multipleSelectDropdown.getOptions();

        //loop all through the options to select all of them

        for(WebElement eachOptiopns:allOptions){
                eachOptiopns.click(); // this will click each option with every iterations
            // 4.Print out all selected values.
            System.out.println("Selected: "+eachOptiopns.getText());

            //Asserting the option is actually selected or not
            Assert.assertTrue(eachOptiopns.isSelected(),"The option "+eachOptiopns.getText()+" is not selected");
        }
        // 5.Deselect all values.
    }
}
