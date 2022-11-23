package pageobjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cart {
    @FindBy(how = How.XPATH,using = "//a[@class='shopping_cart_link']")
    public WebElement bthcart;

    @FindBy(how = How.XPATH,using = "//*[text()='Sauce Labs Bike Light']")
    public WebElement cartbikelight;

    @FindBy(how = How.XPATH,using = "//*[text()='Sauce Labs Backpack']")
    public WebElement cartBackpack;


}


