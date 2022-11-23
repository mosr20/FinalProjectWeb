package pageobjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Products {

    @FindBy(how = How.XPATH,using = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    public WebElement productsBikeLight;

    @FindBy(how = How.XPATH,using = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement productsbackpack;





}
