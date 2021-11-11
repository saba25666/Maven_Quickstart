package org.example.less_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiaryTest {

    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver ().setup ();
        WebDriver webDriver = new ChromeDriver ();
        webDriver.get ("https://diary.ru");
        Cookie cookie = new Cookie("_identity_","9030afc5e21cd01ed35a05c81c2187938c1eb9d58044b553ec20963eafcb531ba%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3558813%2C%22Hrm_OeEao6YEo_4ipd9LHO8Fk_dwR8_g%22%2C2592000%5D%22%3B%7D");
        webDriver.manage ().addCookie (cookie);
        webDriver.navigate ().refresh ();


        webDriver.findElement ( By.xpath ("//a/span[.='Новая запись']")).click ();
        webDriver.findElement (By.id ("postTitle")).sendKeys("test");
        webDriver.findElement ( By.id ("atAvatarCheck")).click ();
        webDriver.findElement ( By.id ("draft_save")).click ();


        WebDriverWait webDriverWait = new WebDriverWait (webDriver, 5);
        webDriverWait.until( ExpectedConditions.presenceOfElementLocated(By.id ("draft_save")));
        Assertions.assertTrue(webDriver.findElement(By.id ("draft_save")).isDisplayed());
        
        Thread.sleep(5000);

        webDriver.quit ();
    }
}