package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class StorePage extends BasePage{

    @FindBy(xpath = "//span[contains(text(), 'Pessoal')]")
    private WebElement personalPurpose;

    @FindBy(id = "01_04_06_01_v_cdqi")
    private WebElement privateIndividualCert;

    @FindBy(id = "00_07_05_73")
    private WebElement loginPageButton;

    public StorePage(WebDriver browser){
        changeTabs(browser);
        initElements(browser);
    }

    public LoginPage goToLoginPage(){
        loginPageButton.click();
        return new LoginPage(browser);
    }

    public ProductPage selectCertType(){
        personalPurpose.click();
        privateIndividualCert.click();
        return new ProductPage(browser);
    }
}
