package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//a[@class='btn is-lg mr-2 ml-2 btn-brand-cta']")
    private WebElement usePreFilledDataButton;
    @FindBy(xpath = "//span[contains(text(), 'USB + Remoto')]")
    private WebElement usbPlusRemoteFormatButton;
    @FindBy(xpath = "//span[contains(text(), '1 Ano')]")
    private WebElement oneYearUsageTimeButton;
    @FindBy(id = "02_01_05_05")
    private WebElement continueButton;
    private JavascriptExecutor js;

    public ProductPage(WebDriver driver){
        initElements(driver);
    }


    public OrderDetails selectProductDetails(){
        usePreFilledDataButton.click();
        js = (JavascriptExecutor)browser;
        js.executeScript("arguments[0].scrollIntoView()", oneYearUsageTimeButton);
        oneYearUsageTimeButton.click();
        js.executeScript("arguments[0].scrollIntoView()", continueButton);
        continueButton.click();
        return new OrderDetails(browser);
    }
}
