package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
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

import static utilities.GetData.getData;
import static utilities.InitBrowser.initBrowser;

public class CommonOps extends Base {


    @BeforeClass
    public  void startSession() throws IOException {
        screen = new Screen();
        initBrowser(getData("BrowserType"));
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
