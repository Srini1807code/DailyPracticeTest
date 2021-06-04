package SyncWaits;

import Alerts.Generic;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExampleWaits {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void waitExample() throws InterruptedException, IOException {

        driver.get("https://www.expedia.co.in/");

        driver.findElement(By.xpath("//span[text()='Flights']")).click();

        driver.findElement(By.xpath("//span[text()='One-way']")).click();

        driver.findElement(By.xpath("//button[@aria-label='Leaving from']")).click();

        driver.findElement(By.cssSelector("#location-field-leg1-origin")).sendKeys("Bengaluru (BLR - Kempegowda Intl.)", Keys.ENTER);

       driver.findElement(By.xpath("//button[@aria-label='Going to']")).click();

       driver.findElement(By.cssSelector("#location-field-leg1-destination")).sendKeys("London (LON - All Airports)",Keys.ENTER);

       driver.findElement(By.xpath("//button[text()='Search']")).click();

        Generic.takingScreenSot(driver);

    }

}
