package pageobjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.Base;
import utilities.CommonOps;
import static utilities.Base.*;


public class LoginPage extends CommonOps {
    @FindBy(how = How.XPATH,using = "//input[@id='user-name']")
    public  WebElement username;

    @FindBy(how = How.XPATH,using = "//input[@id='password']")
    public  WebElement password;
    @FindBy(how = How.XPATH,using = "//input[@id='login-button']")
    public WebElement login_button;

    @FindBy(how = How.XPATH,using = "//h3[@data-test='error']")
    public WebElement error_message;









}
