package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;
import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='header-main-button']")
    private WebElement onlineStoreButton;

    public HomePage(WebDriver browser) throws IOException {
        browser.get(loadData().getBaseURL());
        initElements(browser);
    }

    public StorePage goToOnlineStore(){
        onlineStoreButton.click();
        return new StorePage(browser);
    }
}
