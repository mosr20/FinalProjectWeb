package pageobjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BurgerMenu {

    @FindBy(how = How.XPATH,using = "//button[@id='react-burger-menu-btn']")
    public WebElement burgermenu;
    @FindBy(how = How.XPATH,using = "//a[@id='logout_sidebar_link']")
    public WebElement logout_bth;
    @FindBy(how = How.XPATH,using = "//a[@id='reset_sidebar_link']")
    public  WebElement reset_bth;


}
