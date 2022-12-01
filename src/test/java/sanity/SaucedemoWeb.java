package sanity;

import extensions.Verfications;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SaucedemoWeb extends CommonOps  {
    @Test(description = "test01_veryfi_title")
    public void test01(){
        WebFlows.log_in(getData("LoginUser"),getData("LoginPass"));
        Verfications.veryfiTextElements(main.products_title,"PRODUCTS");
    }
    @Test(description = "test02_veryfi_namber_of_element")
    public void test02(){
        WebFlows.log_in(getData("LoginUser"),getData("LoginPass"));
        Verfications.veryfiIntElements(main.inventory_container,6);

    }

    @Test(description = "test03_veryfiprodcart")
    public void test03(){
        WebFlows.log_in(getData("LoginUser"),getData("LoginPass"));
        WebFlows.add_to_cart(getData("ProductType"));
        Verfications.veryfiProdInCart(cart.cartBackpack);

    }

    @Test(description = "test04_veryfiprodcart")
    public void test04() throws FindFailed {
        WebFlows.log_in(getData("LoginUser"),getData("LoginPass"));
        Verfications.veryfiVisualElement("Sauce Labs Backpack");

    }






}
