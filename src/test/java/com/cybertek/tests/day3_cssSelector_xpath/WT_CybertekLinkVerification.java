package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WT_CybertekLinkVerification {

    public static void main(String[] args) {
        //TC #3: Practice Cybertek/ForgotPassword URL verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Enter any email into input box
        //driver.findElement(By.name("email")).sendKeys("anyemail@domain.com");
        // this is just making the code reuseable
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("anyemail@domain.com");

        // 4.Click on Retrieve password
        //driver.findElement(By.id("form_submit")).click();
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();


        // 5.Verify URL contains:
        // Expected: “email_sent”
        String expectedInUrl = "email_sent";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification Passed!");
        }else{
            System.out.println("URL verification Failed!!!");
        }

        // 6.Verify text box displayed the content as expected.
        // Expected: “Your e-mail’s been sent!”
        //verify the text
        // Mac --> alt enter to introduce a new variable
        WebElement confiramtionMessage = driver.findElement(By.name("confirmation_message"));

        String actualText = confiramtionMessage.getText();
        String expectedText = "Your e-mail's been sent!";

        //System.out.println(actualText);
        //System.out.println(expectedText);


        if(actualText.equals(expectedText)){
            System.out.println("Header text verification PASSED!");
        }else{
            System.out.println("Header text value verification FAILED!!!");
        }

        // verify if the web element is displayed or not

        if(confiramtionMessage.isDisplayed()){
            System.out.println("Confirmation message is displayed. verification PASSED!");
        }else{
            System.out.println("Confirmation message is NOT displayed. verification FAILED!!!");
        }


    }
}
