package Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertHandling {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    @Test

    public void openAlert()throws InterruptedException{

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        driver.findElement(By.id("login1")).sendKeys("Arvind");

        Thread.sleep(2000);

        driver.findElement(By.name("proceed")).click();
        Thread.sleep(2000);

        Alert alt =  driver.switchTo().alert();
        alt.accept();


        driver.findElement(By.cssSelector("#password")).sendKeys("Password");




    }


}
