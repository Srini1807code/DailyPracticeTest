package CheckBox;

import Alerts.Generic;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxSelection {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkBoxSelect()throws InterruptedException{

        driver.get("https://demoqa.com/automation-practice-form");

        WebElement mainheader = driver.findElement(By.xpath("//div[@class='main-header']"));
        Thread.sleep(2000);

        Generic.assertTitle(mainheader,"Practice Form");
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Srini");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[text()='Male']")).click();

        Thread.sleep(2000);
        List<WebElement> cb = driver.findElements(By.cssSelector(".custom-control.custom-checkbox.custom-control-inline"));

        System.out.println("Count is : " +cb.size());
        for (WebElement ele : cb){
            ele.click();
        }

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#uploadPicture")).sendKeys("C:\\Users\\Admin\\IdeaProjects\\DailyPracticeTest\\src\\test\\java\\Frames\\FrameHandling.java");


    }
}
