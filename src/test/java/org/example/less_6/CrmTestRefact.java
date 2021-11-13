package org.example.less_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrmTestRefact {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://crm.geekbrains.space/");
    }

    @Test
    void loginTest() throws InterruptedException {
        new CrmLogin (driver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();

        new HomePageCrm (driver).menuCrm.openNavBarItem("Расходы");
        new ExpensesSubMenu(driver).expensesSubMenuItemClick();
        new ExpensesPageCrm (driver).clickCreateExpenseRequest();
        new CreateExpensePage(driver)
                .fillDescription("test")
                .selectBusinessUnit("Research & Development")
                .selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры")
                .selectPlannedDate("18")
                .fillInputSumPlan("90000000")
                .clickSaveAndCloseButton();

        webDriverWait.until(ExpectedConditions.invisibilityOf(new BaseCrm (driver).loader));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[.='Заявка на расход сохранена']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
