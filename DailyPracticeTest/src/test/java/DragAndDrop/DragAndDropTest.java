package DragAndDrop;

import Alerts.Generic;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropTest {


    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dragAndDrop()throws InterruptedException{

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement src1 = driver.findElement(By.xpath("(//li[@id='fourth']/a)[1]"));
        WebElement dest1 = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));

        Generic.dragNdrop(driver,src1,dest1);


    }
}
