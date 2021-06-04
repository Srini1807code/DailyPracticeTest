package MouseActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyntraActions {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions cos = new ChromeOptions();
        cos.addArguments("Disable Notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void myntraMouse() throws InterruptedException {

        driver.get("https://www.myntra.com/");

        WebElement women = driver.findElement(By.xpath("(//a[text()='Women'])[1]"));
        Thread.sleep(2000);

        Actions act = new Actions(driver);
        act.moveToElement(women).build().perform();

        WebElement tops = driver.findElement(By.xpath("//a[text()='Tops']"));
        Thread.sleep(2000);
        act.click(tops).build().perform();

    }
}
