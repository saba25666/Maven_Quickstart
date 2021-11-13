package org.example.less_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmLogin extends BaseCrm {

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement buttonLogin;

    public CrmLogin fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public CrmLogin fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public void submitLogin() {
        buttonLogin.click();
    }

    public CrmLogin (WebDriver driver) {
        super(driver);
    }
}
