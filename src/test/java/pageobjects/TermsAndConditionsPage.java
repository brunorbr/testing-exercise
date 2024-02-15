package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TermsAndConditionsPage extends BasePage{

    @FindBy(xpath = "//a[@class='link-underline']")
    private WebElement termsAndConditionsLink;
    @FindBy(id = "02_03_03_17")
    WebElement termsAgreementCheckbox;
    @FindBy(id = "02_03_05_05")
    private WebElement continueButton;

    public TermsAndConditionsPage(WebDriver browser){
        initElements(browser);
    }

    public PaymentPage agreeToTermsAndConditions(){
        termsAndConditionsLink.click();
        waitForSeconds(3);
        termsAgreementCheckbox.click();
        continueButton.click();
        return new PaymentPage(browser);
    }



}
