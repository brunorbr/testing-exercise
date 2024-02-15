package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasePage {

    @FindBy(xpath = "//h2[@class='h2 modal-title mb-5']")
    private WebElement confirmationMessage;

    public ConfirmationPage(WebDriver browser){
        initElements(browser);
    }

    public String getConfirmationText(){
        return confirmationMessage.getText();
    }

    public WebElement getConfirmationElement(){
        return confirmationMessage;
    }
}
