package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoading1 {

    public DynamicLoading1() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement startButton;

    @FindBy(id = "username")
    public WebElement userNameInputBox;

    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement paswordInputBox;
    @FindBy (xpath = "//button[@class='btn btn-primary'][@type='submit']")
    public WebElement submitButton;
    @FindBy (id = "flash")
    public WebElement InvalidPasswordText;
}



