package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/*
in this class we will store utility methods that can be applied to any browser content
 Anytime you feel like you have a good logic that you can use in the future,
 create a method of it and store it in this class
 */
public class BrowserUtils {
    /**
    Accepts a list of web Element
    @param list
    @return List<String>
    Method should be returning a list of Strings
     */

    public static List<String> getElementText(List<WebElement> list){

        List<String> webelementAsString = new ArrayList<>();

        for (WebElement each : list) {
            webelementAsString.add(each.getText());
        }
        return webelementAsString;
    }
    /**
    Create a utility method named: wait
    static method
    @param sec
    return void
    the integer number that i pass as parameter should be accpeted as SECONDS
    handle checked exeptions with try/catch
     */

    public static void wait(int sec){
        try{
            Thread.sleep(sec * 1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }


}
