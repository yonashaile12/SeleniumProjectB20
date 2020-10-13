package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextClick {
    /*

    2.Right	click to the box.
    3.Alert	will open.
    4.Accept alertNo assertion needed for this practice
     */

    @Test
    public void contextClick(){
       // TC	#17: Context	Click	–HOMEWORK
       // 1.Go to https://the-internet.herokuapp.com/context_menu
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        Driver.getDriver().manage().window().maximize();

        WebElement context = Driver.getDriver().findElement(By.id("hot-spot"));
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.wait(2);

        actions.contextClick(context).perform();
        BrowserUtils.wait(2);
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();




    }
}
