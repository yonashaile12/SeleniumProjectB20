package com.cybertek.tests.day13_pom_synchornization;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests_SB {
        LoginPage loginPage;

    @Test  (description = "entering incorrect username")
    public void negative_login_test1(){

        String url = ConfigurationReader.getProperty("smartbearUrl");
        Driver.getDriver().get(url);

        //Lets us start using PageObjectModel

        //#1 - We need to crete the object of the class we want to use
        loginPage = new LoginPage();
        // When we create the instance of this class, the constructor immediately
        //initialize out Driver and the object "loginPage"

        //#2- Call the object to use the web Elements
        //Entering incorrect username
        loginPage.usernameInput.sendKeys("asdfafa");

        //Enter correct password
        String password = ConfigurationReader.getProperty(("smartbear_password"));
        loginPage.passwordInput.sendKeys(password);

        // click to login button
        loginPage.loginButton.click();

        //assert true that error message is displayed on the page
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"Error message is not displayed. Verification FAILED!!!");



    }

    @Test (description = "using login method for negative test")
    public void negative_login_test2(){

        String url = ConfigurationReader.getProperty("smartbearUrl");
        Driver.getDriver().get(url);

        loginPage = new LoginPage();

        String username = "wrongusername";
        String password = ConfigurationReader.getProperty(("smartbear_password"));

        loginPage.login(username,password);

        //assert true that error message is displayed on the page
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"Error message is not displayed. Verification FAILED!!!");


    }
}
