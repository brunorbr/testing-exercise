package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public abstract class BasePage {

    protected WebDriver browser;
    protected WebDriverWait wait;

    public void initElements(WebDriver driver){
        this.browser = driver;
        waitForSeconds(3);
        PageFactory.initElements(browser, this);
    }

    public void waitFor(WebElement element, int seconds){
        wait = new WebDriverWait(browser, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public PropertiesReader loadData() throws IOException {
        return new PropertiesReader("./test.properties");
    }

    public void changeTabs(WebDriver browser){
        ArrayList<String> windowIDs = new ArrayList<>(browser.getWindowHandles());
        browser.switchTo().window(windowIDs.get(1));
    }

    public void waitForSeconds(int seconds){
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}