package pageobjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.XPATH,using = "//input[@id='user-name']")
    public WebElement username;

    @FindBy(how = How.XPATH,using = "//input[@id='password']")
    public  WebElement password;
    @FindBy(how = How.XPATH,using = "//input[@id='login-button']")
    public WebElement login_button;
    @FindBy(how = How.XPATH,using = "//div[@class='login_logo']")
    public WebElement login_logo;





}
