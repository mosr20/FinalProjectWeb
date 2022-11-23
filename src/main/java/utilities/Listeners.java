package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener  {
    public void onStart(ITestContext context) {
        System.out.println("onStart method started");
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish method started");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("New Test Started" +" "+result.getName());
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Passed ------------------");
            try {
                MonteScreenRecorder.stopRecord();
            }
            catch (Exception e) {
                e.printStackTrace();
            }




        File file = new File("./test-recordings/" + test.getName() + ".avi");
        if(file.delete()) {
            System.out.println("Recorded Screen Cast File Deleted Successfully");
        }
        else {
            System.out.println("Failed to Delete the Recorded Screen Cast File");
        }
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure Method" +" "+result.getName());
            saveScreenshot();
            try {
                MonteScreenRecorder.stopRecord();
            }
            catch (Exception e) {
                e.printStackTrace();
            }



    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Method" +" "+result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage" +" "+result.getName());
    }
    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


}
