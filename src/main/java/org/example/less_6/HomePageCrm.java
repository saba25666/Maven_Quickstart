package org.example.less_6;

import org.openqa.selenium.WebDriver;

public class HomePageCrm extends BaseCrm {
    MenuCrm menuCrm;

    public HomePageCrm (WebDriver driver) {
        super(driver);
        menuCrm = new MenuCrm (driver);
    }
}
