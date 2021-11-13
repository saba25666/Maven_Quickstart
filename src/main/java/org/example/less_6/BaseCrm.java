package org.example.less_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCrm {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @FindBy(xpath="//body/div[contains(@class,'loader')]")
    public WebElement loader;
    public BaseCrm (WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 4);
        PageFactory.initElements(driver, this);
    }
}
