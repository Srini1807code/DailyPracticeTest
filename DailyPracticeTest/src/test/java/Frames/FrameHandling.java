package Frames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameHandling {

    WebDriver driver ;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void frameClick(){

        driver.get("https://docs.oracle.com/javase/7/docs/api/");

        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.xpath("//a[text()='java.applet']")).click();
        driver.switchTo().defaultContent();

        driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("//i[text()='AudioClip']")).click();
        driver.switchTo().defaultContent();

        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("//a[text()='loop']")).click();
        driver.switchTo().defaultContent();

    }

}
