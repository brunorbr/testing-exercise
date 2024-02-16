package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends BasePage{

    @FindBy(id = "11_00_05_57")
    private WebElement newOrderButton;

    public CustomerPage(WebDriver browser){
        initElements(browser);
    }

    public StorePage clickOnNewOrderButton(){
        waitFor(newOrderButton, 5);
        newOrderButton.click();
        return new StorePage(browser);
    }
}
