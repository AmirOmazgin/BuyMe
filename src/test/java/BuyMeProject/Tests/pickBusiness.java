package BuyMeProject.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class pickBusiness {
    public static WebDriver driver;

    public pickBusiness(WebDriver driver) {
        pickBusiness.driver = driver;
    }

    public void pickBusinessTests (){
        driver.findElement(By.linkText("BUYME KOSHER - שובר למסעדות כשרות")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@placeholder=\"הכנס סכום\"]")).sendKeys("300");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        driver.getCurrentUrl();

    }
    public void assertUrl(){
       driver.get("https://buyme.co.il/categories/%D7%92%D7%99%D7%A4%D7%98%20%D7%A7%D7%90%D7%A8%D7%93%20%D7%9C%D7%9E%D7%A1%D7%A2%D7%93%D7%95%D7%AA");
       String ExpectedUrlAddress = "https://buyme.co.il/categories/%D7%92%D7%99%D7%A4%D7%98%20%D7%A7%D7%90%D7%A8%D7%93%20%D7%9C%D7%9E%D7%A1%D7%A2%D7%93%D7%95%D7%AA";
       String urlAddress = driver.getCurrentUrl();
        Assert.assertEquals(urlAddress, ExpectedUrlAddress);
    }

}
