package com.cybertek.tests.day4_findElments_Checkboces_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P0_FindElements_Practice1 {


    public static void main(String[] args) {
        //TC #0: FIND ELEMENTS
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Print out the texts of all links
        //shortcut is (option + enter) for mac to introduce the local variable

        // locating all of the links on the page and storing them into a list of a WebElements
        List<WebElement> ListOfLinks = driver.findElements(By.xpath("//body//a"));

        for(WebElement eachLink:ListOfLinks){
            //Getting the text of each element in each iteration, and printing the value
            System.out.println(eachLink.getText());
        }

        // 4.Print out how many total link
        int numberOfLinks = ListOfLinks.size();

        System.out.println("Number of Links: " + numberOfLinks);


    }
}
