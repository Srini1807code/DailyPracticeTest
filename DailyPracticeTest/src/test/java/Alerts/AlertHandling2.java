package Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertHandling2  {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    @Test

    public void openAlerts() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        Generic.acceptAlert(driver);

        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        Thread.sleep(2000);
        Generic.dismissAlert(driver);

        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        Thread.sleep(2000);
        Generic.acceptAlertWithSendKeys(driver,"Hello Srini");

        String value = driver.findElement(By.cssSelector("#result")).getText();

        System.out.println(value);
        
    }
}
