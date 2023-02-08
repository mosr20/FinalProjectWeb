package utilities;

import com.lowagie.text.ExceptionConverter;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.*;
import workflows.WebFlows;
import java.io.IOException;
import java.lang.reflect.Method;
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
        driver.navigate().refresh();
    }    @AfterMethod
    public void logout(){
        try {
            WebFlows.log_out();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    @AfterClass
    public void closeSession() throws IOException {
            driver.close();

    }


}
