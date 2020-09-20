package com.cybertek.tests.day4_findElments_Checkboces_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_CybertekForgotPassword {

    public static void main(String[] args) {

        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        // a. “Home” link
        // using the text of the anchor tag to locate a
        WebElement homeLink = driver.findElement(By.xpath("//a[.= 'Home']"));
        //WebElement homeLink = driver.findElement(By.xpath("//a[@href='/']");

        // b. “Forgot password” header
        WebElement header = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        // c. “E-mail” text
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        // d. E-mail input box
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));

        // e. “Retrieve password” button
        //using cssSelector to locate this button
        //option #1: using this syntax ---> button#form_submit
        //option #2: using this syntax ---> button[id.'form_submit]
        //option #3: using this syntax ---> button[class = 'radius']
        //option #4: using this syntax ---> button.radius
        WebElement retrivePasswordButton = driver.findElement(By.cssSelector("button.radius"));

        // f. “Powered by Cybertek School” text
        WebElement linkText = driver.findElement(By.xpath("//a[.='Cybertek School']"));
        WebElement poweredByDiv = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        System.out.println("Link text "+linkText.getText());
        System.out.println("PoweredByDiv = "+ poweredByDiv.getText());

        // 4. Verify all WebElements are displayed.
        // .isDisplayed ---> retruns true if given web element is dispalyd
        if(homeLink.isDisplayed() && emailLabel.isDisplayed() && header.isDisplayed()
                && emailInput.isDisplayed() && retrivePasswordButton.isDisplayed()
                && poweredByDiv.isDisplayed()){
            System.out.println("ALL WEB ElEMENTS ARE DISPLAYED. VERIFICATION PASSED!");
        }else{
            System.out.println("one or more of the web elements are not displayed. Verification FAILED!!!");
        }
    }
}
