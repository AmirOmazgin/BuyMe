package BuyMeProject.Tests;

import BuyMeProject.TakeScreenShot.TakeScreenShot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendAndReceiveInformation {
    public static WebDriver driver;
    private static ExtentTest test;

    public SendAndReceiveInformation(WebDriver driver, ExtentTest test) {
        SendAndReceiveInformation.driver = driver;
        this.test = test;
    }

    public void enterReceiverName(){
        driver.get("https://buyme.co.il/money/4299680?price=300");
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("eli");

    }

    public void pickEvent(){
        driver.findElement(By.className("selected-text")).click();
        try {
            driver.findElement(By.id("ember1564")).click();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("sometimes can and sometimes cannot pick this event");
            test.log(Status.FAIL, "sometimes can and sometimes cannot pick this event");
            test.fail("cannot catch the element", MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShot.takeScreenShot(driver, "C:\\Users\\amiro\\Desktop\\report//picName")).build());
        }
    }

    public void enterBlessing(){
        driver.findElement(By.className("parsley-success")).clear();
        driver.findElement(By.className("parsley-success")).sendKeys("יאללה, מזל טוב מותק");
    }
    public void uploadPic(){
        try {
            driver.findElement(By.className("bm-caption-2")).sendKeys("C:\\Users\\amiro\\Desktop\\image//2.jpg");
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println("cannot upload image");
            test.log(Status.FAIL, "cannot  upload image");
            test.fail("cannot catch the element", MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShot.takeScreenShot(driver, "C:\\Users\\amiro\\Desktop\\report//picName")).build());


        }
    }
    public void nextPage(){
        driver.findElement(By.className("bm-btn")).click();
    }

    public void chooseSms(){
        try {
            driver.findElement(By.cssSelector("path[d=\"M41.6,23c1.3,0,2.4,1.1,2.4,2.5v20c0,1.4-1.1,2.5-2.4,2.5H28.4c-1.3,0-2.4-1.1-2.4-2.5v-20\n" +
                    "            c0-1.4,1.1-2.5,2.4-2.5H41.6z M42.8,43H27.2l0,2.5c0,0.7,0.5,1.3,1.2,1.3h13.2c0.7,0,1.2-0.6,1.2-1.3L42.8,43z M36.8,44.3v1.3h-3.6\n" +
                    "            v-1.3H36.8z M28.4,24.3c-0.7,0-1.2,0.6-1.2,1.3V28h15.6v1.3H27.2l0,12.5h15.6l0-16.3c0-0.7-0.5-1.3-1.2-1.3H28.4z M38,25.5v1.3h-6\n" +
                    "            v-1.3H38z\"]")).click();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("cannot catch the element");
            test.log(Status.FAIL, "cannot catch the element");
            test.fail("cannot catch the element", MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShot.takeScreenShot(driver, "C:\\Users\\amiro\\Desktop\\report//picName")).build());
        }

    }
    public void senderName(){
        driver.findElement(By.id("ember1628")).sendKeys("אמיר");

    }
    public void assertTesting(){
        System.out.println(driver.findElement(By.id("ember1629")).getText());

    }
}
