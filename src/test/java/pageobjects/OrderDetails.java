package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetails extends BasePage{

    @FindBy(xpath = "//a[@class='link-underline tt-u cursor-pointer']")
    private WebElement customerHasNoCitizenCardURL;
    private JavascriptExecutor js;

    public OrderDetails(WebDriver browser){
        initElements(browser);
    }

    public TermsAndConditionsPage proceedWithoutCitizenCard(){
        js = (JavascriptExecutor)browser;
        js.executeScript("arguments[0].scrollIntoView()", customerHasNoCitizenCardURL);
        customerHasNoCitizenCardURL.click();
        return new TermsAndConditionsPage(browser);
    }
}
