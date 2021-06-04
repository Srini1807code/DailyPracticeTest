package Pagenation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Pagenation {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    @Test

    public void pageNations() throws InterruptedException{

        driver.get("https://datatables.net/");

        int pagenationSize = driver.findElements(By.cssSelector("#example_paginate>span>a")).size();

        List<String> names = new ArrayList<String>();

        for (int i=1;i<=pagenationSize;i++){

            String paginationSelector = "#example_paginate>span>a:nth-child("+i+")";

            driver.findElement( By.cssSelector(paginationSelector)).click();

            List<WebElement> nameElements = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));

            for (WebElement ele : nameElements){
                System.out.println(ele.getText());
                names.add(ele.getText());
                
            }

        }
        System.out.println("Total names :" + names.size());

    }
}
