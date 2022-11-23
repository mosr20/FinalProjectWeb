package extensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;
import java.util.List;

public class Verfications extends CommonOps  {
    public static void veryfiTextElements(WebElement elem,String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertEquals(elem.getText(), expected);
    }

        public static void veryfiIntElements(List<WebElement> elem, int expected){
            wait.until(ExpectedConditions.visibilityOf(elem.get(elem.size()-1)));
            Assert.assertEquals(elem.size(),expected);
        }

    public static void veryfiprodcart(WebElement elem){
        UIAction.click(cart.bthcart);
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertTrue(elem.isEnabled());


    }

    public static void veryfivisualelement(String excpectedpng) throws FindFailed {
        screen.find(getData("ImageRepo")+excpectedpng+".png");


    }

    public static void veryEqualsint(int CounKeytValue, int expected){
        Assert.assertEquals(CounKeytValue,expected);
    }

    public static void veryEqualsString(String CounKeytValue, String expected){
        Assert.assertEquals(CounKeytValue,expected);
    }







}
