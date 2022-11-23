package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import workflows.WebFlows;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {


    public static String getData (String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
    public void initBrowser(String browserType ){
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIeDriver();
        else
            throw new RuntimeException("Invalid browser");
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeouts")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeouts")));

        driver.manage().window().maximize();
        driver.get(getData("Urlweb"));
        ManagePages.initsaucedemo();
        ManagePages.initMainPagesaucedemo();
        ManagePages.initBurgerMenusaucedemo();
        ManagePages.initProductssaucedemo();
        ManagePages.initCartsaucedemo();



    }
    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;

    }
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
    public static WebDriver initIeDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }





    @BeforeClass
    public  void startSession() throws IOException {

        screen = new Screen();
        String PlatformeType = getData("PlatformeType");
        if(PlatformeType.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserType"));
        else
            throw new RuntimeException("Invalid Platforme");

    }
    @BeforeMethod
    public void beforeMethod(Method method) {
        try {
            MonteScreenRecorder.startRecord(method.getName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }    @AfterMethod
    public void logout(){
            WebFlows.log_out();
    }

    @AfterClass
    public void closeSession() throws IOException {
            driver.close();
    }


}
