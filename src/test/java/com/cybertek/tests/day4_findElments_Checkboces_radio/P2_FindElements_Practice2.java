package com.cybertek.tests.day4_findElments_Checkboces_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P2_FindElements_Practice2 {


    public static void main(String[] args) {
        //TC #0: FIND ELEMENTS
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to https://www.merriam-webster.com/
        driver.get("https://www.merriam-webster.com/");

        // 3.Print out the texts of all links
        //Locating all of the web elements on the page and storing ina list of webElement
        List<WebElement> ListOfLinks = driver.findElements(By.xpath("//body//a"));
        int linksWithOutText = 0;
        int linksWithText = 0;

        for(WebElement eachLinks:ListOfLinks){

            String textOfEachLinks = eachLinks.getText();

            System.out.println(eachLinks.getText());

            if (textOfEachLinks.isEmpty()) {
                linksWithOutText++;
            } else {
                linksWithText++;
            }
        }

        // 4.Print out how many link is missing text

        System.out.println("Links WithOut Text = " + linksWithOutText);
        System.out.println("Links with Text = "+ linksWithText);
        System.out.println("Number of Links: "+ListOfLinks.size());


        // 5.Print out how many link has text
        // 6.Print out how many total link
    }
}
