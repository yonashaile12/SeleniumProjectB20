package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick {


    @Test
    public void doubleClick(){

        //TC	#16:	Double	ClickTest
        //1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().manage().window().maximize();

        //2.Switch	to	iframe.
        WebElement iframes = Driver.getDriver().findElement(By.xpath("//iframe[@id='iframeResult']"));
        Driver.getDriver().switchTo().frame(iframes);

        WebElement doubleClick = Driver.getDriver().findElement(By.xpath("//p[contains(text(),'Double-click me to change my text color')]"));

        //3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.wait(2);

        actions.moveToElement(doubleClick).doubleClick().perform();

        //4.Assert:	Text’s	“style”	attribute	value	contains red
        String actualStyle = doubleClick.getAttribute("style");

        Assert.assertTrue(actualStyle.contains("red"),"Actual style value does contains red.Verification FAILED!!");

    }
}
