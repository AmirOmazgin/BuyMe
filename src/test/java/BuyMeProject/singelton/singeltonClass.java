package BuyMeProject.singelton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class singeltonClass {

    public singeltonClass() {
    }

    public static WebDriver getDriverInstance() throws Exception {
            String type = getData("browserType");
            if (type.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\amiro\\Downloads\\chromedriver_win32\\chromedriver.exe");
              return new ChromeDriver();
            } else if (type.equals("FF")) {
                System.setProperty("webdriver.firefox.driver", "C:\\geckodriver\\geckodriver.exe");
                return new FirefoxDriver();
            }
            return null;
    }

    public static String getData (String keyName) throws Exception{
        File fXmlFile = new File("C:\\Users\\amiro\\IdeaProjects\\BuyMe\\src\\main\\resources\\data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }


}



