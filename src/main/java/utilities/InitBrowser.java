package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static utilities.GetData.getData;

public class InitBrowser extends CommonOps {
    public static   void initBrowser(String browserType ){
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

}
