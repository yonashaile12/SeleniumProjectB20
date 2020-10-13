package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest {


    @Test
    public void DragAndDrop(){
        //TC #16: Hover	Test
        //1.Go to	https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Driver.getDriver().manage().window().maximize();

        WebElement source = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));

        //2.Drag	and	drop the small circle to bigger	circle.
        WebElement target = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        BrowserUtils.wait(10);
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.wait(5);
        actions.dragAndDrop(source,target).perform();

        String actualtext = target.getText();
        Assert.assertTrue(actualtext.contains("You did great"),"Verification FAIILED!!!");

    }
}
