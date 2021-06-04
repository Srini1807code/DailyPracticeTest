package FileDownload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class FileDownloading {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void fileDownloading(){

       String path = System.getProperty("user.dir")+ File.separator+"TestFiles";
        ChromeOptions ops = new ChromeOptions();
        HashMap<String,Object> ChromePref = new  HashMap<>();
        ops.setExperimentalOption("prefs",ChromePref);

    }

    @Test
    public void fileDownload()throws InterruptedException{

        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.linkText("Sample.txt")).click();

    }
}
