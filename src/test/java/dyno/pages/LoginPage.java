package dyno.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "prependedInput")
    public WebElement userNameBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordBox;

    @FindBy(id = "_submit")
    public WebElement logInBtn;

    @FindBy(linkText = "Forgot your password")
    public WebElement forgotPasswordBtn;

    @FindBy(id = "remember_me")
    public WebElement rememberMeBtn;

    public void login(String username, String password){
        userNameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        logInBtn.click();
    }
}
