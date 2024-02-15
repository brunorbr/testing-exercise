package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DataGenerator;

public class RegisterPage extends BasePage{

    @FindBy(id = "13_03_00_45")
    private WebElement firstNameField;
    @FindBy(id = "13_03_00_46")
    private WebElement lastNameField;
    @FindBy(id = "13_03_00_32")
    private WebElement phoneNumberField;
    @FindBy(id = "13_03_00_51")
    private WebElement emailField;
    @FindBy(id = "13_03_11_85")
    private WebElement passwordField;
    @FindBy(id = "13_03_11_88")
    private WebElement passwordConfirmationField;
    @FindBy(css = "'a[href*=`long`]'")
    private WebElement privacyPolicyURL;
    @FindBy(xpath = "//input[@wfd-id=\"id17\"]")
    private WebElement privacyPolicyCheckbox;
    @FindBy(xpath = "//input[@wfd-id=\"id18\"]")
    private WebElement newsletterSubscriptionCheckbox;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continueButton;

    public RegisterPage(WebDriver browser){
        initElements(browser);
    }

    public void insertRegisterData(String firstName,
                                   String lastName,
                                   String phoneNumber,
                                   String email,
                                   String password){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        phoneNumberField.sendKeys(phoneNumber);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        passwordConfirmationField.sendKeys(password);
        privacyPolicyCheckbox.click();
        newsletterSubscriptionCheckbox.click();
        continueButton.click();
    }
}
