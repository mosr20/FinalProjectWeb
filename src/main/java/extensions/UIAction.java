package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;



public class UIAction extends CommonOps {




    @Step("clice_on_element")
    //receives an element and makes a click on element//
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("sendkeys_element")
    //receives an element and makes a sendKeys on element//
    public static void sendkeys(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }



}
