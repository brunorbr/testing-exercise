package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobjects.*;
import utils.BrowserManager;
import utils.DataGenerator;
import utils.MailValidator;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreTests {

    private final String CONFIRMATION_TEXT = "Conta ativada com sucesso!";
    private final String ERROR_TITLE = "Dados incorretos";
    private final String ERROR_TEXT = "Por favor verifique os dados inseridos.";
    private final String ERROR_BUTTON = "Fechar";

    private HomePage home;
    private StorePage store;
    private LoginPage loginPage;
    private RegisterPage register;
    private ConfirmationPage confirmationPage;
    private CustomerPage customer;
    private ProductPage product;
    private OrderDetails order;
    private TermsAndConditionsPage terms;
    private PaymentPage payment;
    private ErrorPage error;
    private WebDriver browser;
    private static MailValidator validator;
    private static DataGenerator data;

    @BeforeAll
    public static void generateData(){
        data = new DataGenerator();
        validator = new MailValidator();
    }

    @BeforeEach
    public void setUp(){
        browser = BrowserManager.selectBrowser();
        browser.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        browser.quit();
    }


    @DisplayName("Validate if the customer is able to register and confirm their account")
    @Test
    @Order(1)
    public void validateRegistrationAndEmailConfirmation() throws IOException, InterruptedException, URISyntaxException {
        home = new HomePage(browser);
        store = home.goToOnlineStore();
        loginPage = store.goToLoginPage();
        register = loginPage.goToRegistration();
        register.insertRegisterData(data.firstName,
                data.lastName,
                data.phoneNumber,
                data.email,
                data.password);
        browser.get(validator.getValidationURL(data.email));
        confirmationPage = new ConfirmationPage(browser);
        confirmationPage.waitForSeconds(10);
        assertEquals(CONFIRMATION_TEXT, confirmationPage.getConfirmationText());
    }

    @DisplayName("Validate if the user gets an error message when using an invalid credit card")
    @Test
    @Order(2)
    public void validateIfTheUserGetsAnErrorMessageWhenUsingAnInvalidCreditCard() throws IOException {
        home = new HomePage(browser);
        store = home.goToOnlineStore();
        loginPage = store.goToLoginPage();
        customer = loginPage.performLogin(data.email, data.password);
        customer.waitForSeconds(5);
        store = customer.clickOnNewOrderButton();
        product = store.selectCertType();
        order = product.selectProductDetails();
        terms = order.proceedWithoutCitizenCard();
        payment = terms.agreeToTermsAndConditions();
        payment.fillInFiscalData(data.fullName,
                data.vatNumber,
                data.streetAdress,
                data.zipCode,
                data.city,
                "Portugal");
        payment.selectCardAsPaymentMethod();
        payment.fillCreditCardData(data.creditCardNumber,
                "02/2033",
                data.cvv);
        error = payment.submitPayment();
        assertEquals(ERROR_TITLE, error.getErrorTitle());
        assertEquals(ERROR_TEXT, error.getErrorText());
        assertEquals(ERROR_BUTTON, error.getErrorButton());
    }
}
