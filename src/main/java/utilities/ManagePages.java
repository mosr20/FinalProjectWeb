package utilities;

import org.openqa.selenium.support.PageFactory;
import pageobjects.saucedemo.*;

import static utilities.Base.*;

public class ManagePages {
    public static void initsaucedemo(){
        login = PageFactory.initElements(driver, LoginPage.class);
    }
    public static void initMainPagesaucedemo(){
        main = PageFactory.initElements(driver, MainPage.class);
    }
    public static void initBurgerMenusaucedemo(){BurMen = PageFactory.initElements(driver, BurgerMenu.class);}

    public static void initProductssaucedemo(){Prod = PageFactory.initElements(driver, Products.class);}
    public static void initCartsaucedemo(){cart = PageFactory.initElements(driver, Cart.class);}




}
