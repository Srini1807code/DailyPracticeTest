package Alerts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class Generic {

    public static void acceptAlert(WebDriver driver) {

        Alert alt = driver.switchTo().alert();
        System.out.println("Alert Title :" + alt.getText());
        alt.accept();
    }

    public static void dismissAlert(WebDriver driver) {

        Alert alt = driver.switchTo().alert();
        System.out.println("Alert dismiss :" + alt.getText());
        alt.dismiss();
    }

    public static void acceptAlertWithSendKeys(WebDriver driver, String text) {

        Alert alt = driver.switchTo().alert();
        System.out.println("Alert Title :" + alt.getText());
        alt.sendKeys(text);
        alt.accept();

    }

    public static void mouseHover(WebDriver driver, WebElement element) {

        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();

    }
    

    public static void mouseClick(WebDriver driver, WebElement element) {

        Actions act = new Actions(driver);
        act.click(element).build().perform();
    }

    public static void rightClick(WebDriver driver,WebElement element){

        Actions act = new Actions(driver);
        act.contextClick(element).build().perform();
    }

    public static void dragNdrop(WebDriver driver, WebElement src, WebElement dest){

        Actions act = new Actions(driver);
        act.dragAndDrop(src,dest).build().perform();

    }

    public static void scrollIntoView(WebDriver driver, WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public static void assertTitle(WebElement element,String text){


        String actualText = element.getText();
        Assert.assertEquals(actualText,text, "Title Mismatch");
    }


    public static void takingScreenSot(WebDriver driver) throws IOException {
        TakesScreenshot srcShot = (TakesScreenshot) driver;
        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")+File.separator+"TestFiles"+File.separator+"Demo.png";
        File dest = new File(path);
        try {
            FileUtils.copyFile(srcFile,dest);
        }catch (Exception e){

        }



    }
}
