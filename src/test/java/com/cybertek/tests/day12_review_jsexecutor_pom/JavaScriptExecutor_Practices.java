package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Practices {

    @Test
    public void scroll_using_jsexecutor_1(){
        //Get the page to scroll
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //Create instance of JSExecutor and cast our driver type to it.
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //use execute script method


        for (int i = 0; i < 10 ; i++) {
            BrowserUtils.wait(1);
            js.executeScript("window.scrollBy(0, 500)");

        }
    }

    @Test
    public void scroll_using_jsexecutor_2(){
        //get the page to scroll
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        //use js executor to scroll "Cybertek School" link intoView
        JavascriptExecutor js =(JavascriptExecutor) Driver.getDriver();

        //Locating cybertek school link
        WebElement cybertekLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        //use scroolIntoView function from javaScript top scroll to a specific webElement
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true)", cybertekLink);

        BrowserUtils.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);


    }

    @Test
    public void fill_form_using_javascript(){
        Driver.getDriver().get("http://practice.cybertekschool.com/sign_up");

        WebElement usernameInput = Driver.getDriver().findElement(By.name("full_name"));
        WebElement emailInput = Driver.getDriver().findElement(By.name("email"));
        WebElement signUpButton = Driver.getDriver().findElement(By.name("wooden_spoon"));

        BrowserUtils.wait(1);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //sending keys to usernameInput using javascript function  .setAttribute
        js.executeScript("arguments[0].setAttribute('value','Jane Doe')",usernameInput);

        BrowserUtils.wait(1);

        //sending keys to emailinput using javascript function  .setAttribute
        js.executeScript("arguments[0].setAttribute('value','something@gmail.com')",emailInput);

        BrowserUtils.wait(1);
        //clicking to signUpButton using javascript funtion
        js.executeScript("arguments[0].click()",signUpButton);

    }
}
