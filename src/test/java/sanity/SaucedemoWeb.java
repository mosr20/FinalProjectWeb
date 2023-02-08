package sanity;

import extensions.Verifications;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDTT;
import workflows.WebFlows;

import static utilities.GetData.getData;

@Listeners(utilities.Listeners.class)
public class SaucedemoWeb extends CommonOps  {
    @Test(description = "test01_veryfi_title")
    public void test01(){
        WebFlows.log_in(getData("LoginUser"),getData("LoginPass"));
        Assert.assertEquals(main.products_title.getText(),"PRODUCTS");
        Verifications.veryfiTextElements(main.products_title,"PRODUCTS");
    }
    @Test(description ="test02_Negative test login", dataProvider = "data-provider-login",dataProviderClass = ManageDTT.class)
    public void test02(String user,String pass){
        WebFlows.log_in(user,pass);
        Verifications.veryfiTextElements(login.error_message,"Epic sadface: Username and password do not match any user in this service");

    }
    @Test(description = "test03_veryfi_namber_of_element")
    public void test03(){
        WebFlows.log_in(getData("LoginUser"),getData("LoginPass"));
        Verifications.veryfiIntElements(main.inventory_container,6);

    }

    @Test(description = "test04_veryfiprodcart")
    public void test04(){
        WebFlows.log_in(getData("LoginUser"),getData("LoginPass"));
        WebFlows.add_to_cart(getData("ProductType"));
        Verifications.veryfiProdInCart(cart.cartBackpack);

    }

    //@Test(description = "test05_veryfiprodcart")
    //public void test05() throws FindFailed {
        //WebFlows.log_in(getData("LoginUser"),getData("LoginPass"));
        //Verifications.veryfiVisualElement("Sauce Labs Backpack");

    //}






}
