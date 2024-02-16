package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ConfirmationPage extends BasePage {

    @FindBy(xpath = "//h2[@class='h2 modal-title mb-5']")
    private WebElement confirmationMessage;

    public ConfirmationPage(WebDriver browser){
        initElements(browser);
    }

    public String getConfirmationText(){
        waitFor(confirmationMessage, 5);
        return confirmationMessage.getText();
    }

    public WebElement getConfirmationElement(){
        return confirmationMessage;
    }
}
