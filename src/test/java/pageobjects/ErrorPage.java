package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorPage extends BasePage {

    @FindBy(xpath = "//h3[@class='h2 modal-title co-brand-dark mb-5']")
    private WebElement errorTitle;
    @FindBy(xpath = "//p[@class='mb-5']")
    private WebElement errorText;
    @FindBy(id = "00_03_06_93_v_close")
    private WebElement errorButton;

    public ErrorPage(WebDriver browser){
        initElements(browser);
    }

    public String getErrorTitle(){
        return errorTitle.getText();
    }

    public String getErrorText(){
        return errorText.getText();
    }

    public String getErrorButton(){
        return errorButton.getText();
    }
}
