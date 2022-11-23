package pageobjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how = How.XPATH,using = "//span[@class='title']")
    public WebElement products_title;

    @FindBy(how = How.XPATH,using = "//div[@class='inventory_list']/div")
    public List <WebElement> inventory_container;



}
