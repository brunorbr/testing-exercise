package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="12_03_00_51")
    private WebElement emailField;
    @FindBy(id="12_03_11_85")
    private WebElement passwordField;
    @FindBy(id="12_03_05_05")
    private WebElement loginButton;
    @FindBy(id="12_03_05_87")
    private WebElement registerURL;

    public LoginPage (WebDriver browser){
        initElements(browser);
    }

    public RegisterPage goToRegistration(){
        registerURL.click();
        return new RegisterPage(browser);
    }

    public CustomerPage performLogin(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return new CustomerPage(browser);
    }
}
