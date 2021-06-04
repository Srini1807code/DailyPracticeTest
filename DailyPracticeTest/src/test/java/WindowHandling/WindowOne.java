package WindowHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowOne {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void windowOpen() throws InterruptedException{

        driver.get("https://support.google.com/mail/answer/56256?hl=en");

        String win1= driver.getWindowHandle();
        System.out.println("Woindow id is : " +win1);
        System.out.println("Title : " +driver.getTitle());
        driver.findElement(By.xpath("//a[@class='action-button']")).click();

        Set<String> wins = driver.getWindowHandles();

        for (String st : wins){
            System.out.println("Window id" +st);
            driver.switchTo().window(st);
        }

        System.out.println("Get Title :" +driver.getTitle());
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Srini");
        Thread.sleep(2000);

    }
}
