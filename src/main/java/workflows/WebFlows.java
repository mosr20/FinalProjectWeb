package workflows;

import extensions.UIAction;
import io.qameta.allure.Step;
import utilities.CommonOps;


public class WebFlows extends CommonOps {
    @Step("WebFlows_Login")
    public static void log_in(String user,String pass){
        UIAction.sendkeys(login.username,user);
        UIAction.sendkeys(login.password,pass);
        UIAction.click(login.login_button);
    }
    @Step("WebFlows_Logout")
    public static void log_out(){
        UIAction.click(BurMen.burgermenu);
        UIAction.click(BurMen.reset_bth);
        UIAction.click(BurMen.logout_bth);
    }
    @Step("WebFlows_add_to_cart")
    public static void add_to_cart(String ProductType){
        if (ProductType.equalsIgnoreCase("BikeLight"))
            UIAction.click(Prod.productsBikeLight);

        else if (ProductType.equalsIgnoreCase("productsbackpack"))
            UIAction.click(Prod.productsbackpack);
        else
            throw new RuntimeException("Invalid browser");

    }


}
