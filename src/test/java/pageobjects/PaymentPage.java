package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(id = "03_01_00_21")
    private WebElement fiscalNameField;
    @FindBy(id = "03_01_00_22")
    private WebElement vatNumberField;
    @FindBy(id = "03_01_00_23")
    private WebElement addressField;
    @FindBy(id = "03_01_00_24")
    private WebElement zipCodeField;
    @FindBy(id = "03_01_00_25")
    private WebElement cityField;
    @FindBy(id = "03_01_01_26")
    private WebElement countryField;
    @FindBy(id = "03_01_12_30_v_creditCard")
    private WebElement creditCardButton;
    @FindBy(id = "03_01_00_33")
    private WebElement creditCardNumberField;
    @FindBy(id = "03_01_00_34")
    private WebElement validUntilField;
    @FindBy(id = "03_01_00_35")
    private WebElement cvvField;
    @FindBy(id = "03_00_05_05")
    private WebElement continueButton;
    private JavascriptExecutor js;

    public PaymentPage(WebDriver browser){
        initElements(browser);
    }

    public void fillInFiscalData(String fullName,
                                 String vatNumber,
                                 String address,
                                 String zipCode,
                                 String city,
                                 String country){
        fiscalNameField.sendKeys(fullName);
        vatNumberField.sendKeys(vatNumber);
        addressField.sendKeys(address);
        zipCodeField.sendKeys(zipCode);
        cityField.sendKeys(city);
        countryField.click();
        countryField.sendKeys(country + Keys.ENTER);
    }

    public void selectCardAsPaymentMethod(){
        js = (JavascriptExecutor)browser;
        js.executeScript("arguments[0].scrollIntoView()", creditCardButton);
        creditCardButton.click();
    }

    public void fillCreditCardData(String creditCardNumber,
                                   String validUntilDate,
                                   String cvv){
        creditCardNumberField.sendKeys(creditCardNumber);
        validUntilField.sendKeys(validUntilDate);
        cvvField.sendKeys(cvv);
    }

    public ErrorPage submitPayment(){
        js.executeScript("arguments[0].scrollIntoView()", continueButton);
        continueButton.click();
        return new ErrorPage(browser);
    }
}
