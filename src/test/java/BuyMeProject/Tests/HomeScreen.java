package BuyMeProject.Tests;
import BuyMeProject.TakeScreenShot.TakeScreenShot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeScreen {
    private static WebDriver driver;
    private  ExtentTest test;
    public HomeScreen(WebDriver driver, ExtentTest test) {
       HomeScreen.driver = driver;
        this.test = test;
    }

    public void homeScreenTests(){
        driver.get("https://buyme.co.il/");
        driver.findElement(By.linkText("סכום")).click();
        try {
            driver.findElement(By.id("ember1679_chosen")).click();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("couldn't pick price");
            test.log(Status.FAIL, "couldn't pick price");
            test.fail("couldn't pick price", MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShot.takeScreenShot(driver, "C:\\Users\\amiro\\Desktop\\report//picName")).build());
        }
        driver.findElement(By.linkText("אזור")).click();

        try {
            driver.findElement(By.linkText("מרכז")).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("cannot pick region");
            test.log(Status.FAIL, "cannot pick region");
            test.fail("cannot pick region", MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShot.takeScreenShot(driver, "C:\\Users\\amiro\\Desktop\\report//picName")).build());


        }
        driver.findElement(By.linkText("קטגוריה")).click();

        try {
            driver.findElement(By.linkText("מתנות לחג")).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("couldn't pick category");
            test.log(Status.FAIL, "couldn't pick category");
            test.fail("couldn't pick category", MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShot.takeScreenShot(driver, "C:\\Users\\amiro\\Desktop\\report//picName")).build());


        }
        driver.findElement(By.linkText("תמצאו לי מתנה")).click();

    }





}
