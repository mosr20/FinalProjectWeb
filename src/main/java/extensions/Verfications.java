package extensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;
import java.util.List;

public class Verfications extends CommonOps  {

    //receives a element and a string makes a comparison between them//
    public static void veryfiTextElements(WebElement elem,String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertEquals(elem.getText(), expected);
    }

    //receives a list  and  int makes a comparison between them//
    public static void veryfiIntElements(List<WebElement> elem, int expected){
            wait.until(ExpectedConditions.visibilityOf(elem.get(elem.size()-1)));
            Assert.assertEquals(elem.size(),expected);
        }

     //receives a element and makes sure it exists//
    public static void veryfiProdInCart(WebElement elem){
        UIAction.click(cart.bthcart);
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertTrue(elem.isEnabled());


    }
    //receives a Srting and makes sure Comparison between images//

    public static void veryfiVisualElement(String excpectedpng) throws FindFailed {
        screen.find(getData("ImageRepo")+excpectedpng+".png");


    }









}
