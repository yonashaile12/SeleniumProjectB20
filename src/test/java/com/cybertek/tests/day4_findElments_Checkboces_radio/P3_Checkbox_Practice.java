package com.cybertek.tests.day4_findElments_Checkboces_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Checkbox_Practice {

    public static void main(String[] args) throws InterruptedException {

        //Practice:	Cybertek Checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 1.Go	to	http://practice.cybertekschool.com/checkboxes
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //locating the first checkbox
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        //locating the first checkbox
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        // 2.Confirm	checkbox	#1	is	NOT	selected	by	default
        if(!checkbox1.isSelected()){
            System.out.println("Checkbox 1 is not selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox 1 is Selected. Verification FAILED!!!");
        }
        // 3.Confirm	checkbox	#2	is	SELECTED	by	default.

        if(checkbox2.isSelected()){
            System.out.println("Checkbox 2 is Selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox 2 is not selected. Verification FAILED!!!");
        }
        // 4.Click	checkbox	#1	to	select	it.
        Thread.sleep(10000);
        checkbox1.click();

        // 5.Click	checkbox	#2	to	deselect	it.
        Thread.sleep(1000);
        checkbox2.click();

        // 6.Confirm	checkbox	#1	is	SELECTED.
        if(checkbox1.isSelected()){
            System.out.println("Checkbox 1 is selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox 1 is not Selected. Verification FAILED!!!");
        }

        // 7.Confirm	checkbox	#2	is	NOT
        if(!checkbox2.isSelected()){
            System.out.println("Checkbox 2 is NOT Selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox 2 is selected. Verification FAILED!!!");
        }

        WebElement homeLink = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        homeLink.click();

        Thread.sleep(1000);

        driver.navigate().refresh();
        checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        checkbox1.click();



    }
}
