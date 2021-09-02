package BuyMeProject.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class IntroAndRegistrationScreen {
    public static WebDriver driver;
    public IntroAndRegistrationScreen(WebDriver driver) {
        IntroAndRegistrationScreen.driver = driver;
    }

    public void introAndRegistrationTests(){
        driver.get("https://buyme.co.il/");
        driver.findElement(By.className("seperator-link")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@class=\"text-link theme\"]")).click();
        driver.findElement(By.xpath("//input[@placeholder=\"שם פרטי\"]")).sendKeys("amir");
        driver.findElement(By.xpath("//input[@placeholder=\"מייל\"]")).sendKeys("amir322@hotmail.com");
        driver.findElement(By.xpath("//input[@placeholder=\"סיסמה\"]")).sendKeys("Qaz123456");
        driver.findElement(By.xpath("//input[@placeholder=\"אימות סיסמה\"]")).sendKeys("Qaz123456");
        driver.findElement(By.xpath("//button[@gtm=\"הרשמה ל-BUYME\"]")).click();

    }

    public void assertTest(){
        String name = "driver.findElement(By.xpath(//input[@placeholder=\"שם פרטי\"])).getText()";
        System.out.println(name);
        System.out.println( driver.findElement(By.xpath("//input[@placeholder=\"מייל\"]")).getText());

//        Assert.assertEquals( driver.findElement(By.xpath("//input[@placeholder=\"שם פרטי\"]")).getText(),"amir" );
//        Assert.assertEquals( driver.findElement(By.xpath("//input[@placeholder=\"מייל\"]")).getText(),"amir320@hotmail.com" );
//        Assert.assertEquals( driver.findElement(By.xpath("//input[@placeholder=\"סיסמה\"]")).getText(),"Qaz123456" );
//        Assert.assertEquals( driver.findElement(By.xpath("//input[@placeholder=\"אימות סיסמה\"]")).getText(),"Qaz123456" );


    }










}
