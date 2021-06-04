package Scrolling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollingEnd {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("Disable Notifications");
    }

    @Test
    public void scrollingEnd()throws InterruptedException{

        driver.get("https://www.amazon.com/");

        WebElement backToTop = driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",backToTop);
        Thread.sleep(5000);

        backToTop.click();



    }
}
