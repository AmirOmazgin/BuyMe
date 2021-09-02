package BuyMeProject;

import BuyMeProject.Tests.HomeScreen;
import BuyMeProject.Tests.IntroAndRegistrationScreen;
import BuyMeProject.Tests.SendAndReceiveInformation;
import BuyMeProject.Tests.pickBusiness;
import BuyMeProject.singelton.singeltonClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTests {
    public static ExtentReports extent= new ExtentReports();
    public static ExtentTest test = extent.createTest("BuyMeTesting", "Sample description");
    public static WebDriver driver;


    @BeforeClass
    public void start() throws Exception {
        if (driver == null ) {
            driver = singeltonClass.getDriverInstance();
        }
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\amiro\\Desktop\\report//extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");
    }

    @Test (priority = 1)
    public void introAndRegistrationTest() throws InterruptedException {
        IntroAndRegistrationScreen intro = new IntroAndRegistrationScreen(driver);
        test.log(Status.INFO, "intro and registration");
        intro.introAndRegistrationTests();
        intro.assertTest();
    }

    @Test (priority = 2)
    public void homeScreenTest() throws InterruptedException {
        HomeScreen home = new HomeScreen(driver, test);
        test.log(Status.INFO, "Home Screen Test");
        home.homeScreenTests();
    }

    @Test (priority = 3)
    public void pickBusinessTest() throws InterruptedException {
        pickBusiness pick = new pickBusiness(driver);
        test.log(Status.INFO, "Pick business Test");
        pick.assertUrl();
        pick.pickBusinessTests();
    }

    @Test (priority = 4)
    public void SendAndReceiveInformationTest() throws InterruptedException {
        SendAndReceiveInformation informationTest = new SendAndReceiveInformation(driver, test);
        test.log(Status.INFO, "Send And Receive Information");
        Thread.sleep(1000);
        informationTest.enterReceiverName();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(1000);
        informationTest.pickEvent();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(1000);
        informationTest.enterBlessing();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(1000);
        informationTest.uploadPic();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(1000);
        informationTest.nextPage();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(1000);
        informationTest.chooseSms();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(1000);
        informationTest.senderName();
        Thread.sleep(1000);
        informationTest.assertTesting();

    }

    @AfterClass
    public  void afterClass() {
        extent.flush();
        driver.quit();
    }


}
