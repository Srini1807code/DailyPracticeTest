package AutoSuggestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AutoSuggestions {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("Disable Notifications");
    }

    @Test
    public void autoSugesttion() throws InterruptedException {

        driver.get("https://www.redbus.in/");

        driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Ban");

        Thread.sleep(2000);
        List<WebElement> src = driver.findElements(By.xpath("//ul[@class='autoFill']/li"));

        System.out.println("Total Number of count : " + src.size());

        for (WebElement ele : src) {
            System.out.println(ele.getText());
            if (ele.getText().equalsIgnoreCase("Banda")) ;
            ele.click();
            break;
        }

        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Che");

        List<WebElement> dest = driver.findElements(By.xpath("//ul[@class='autoFill']/li"));

        System.out.println("Total Number of count : " + src.size());

        for (WebElement ele : dest) {
            System.out.println(ele.getText());
            if (ele.getText().equalsIgnoreCase("Chennai")) ;
            ele.click();
            break;
        }

        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

        Thread.sleep(2000);
        List<WebElement> cal = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));

        for (WebElement ele : cal) {

            if (ele.getText() != "June 2021") {
                driver.findElement(By.xpath("//button[text()='>']")).click();
                break;
            }

        }

//        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

        List<WebElement> cal2 = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));

        for (WebElement ele : cal) {

            if (ele.equals("4")) {
                ele.click();
                break;

            }
        }


    }
}
