package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserManager {
    private static WebDriver browser;

    public static WebDriver selectBrowser() {
        String selectedBrowser = System.getProperty(
                "browser",
                "chrome");
        switch (selectedBrowser) {

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                browser = new FirefoxDriver();
                break;
            case "chrome-mobile":
                WebDriverManager.chromedriver().setup();
                Map<String, String> device = new HashMap<>();
                device.put("deviceName", "Nexus 5");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("mobileEmulation", device);
                browser = new ChromeDriver(options);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                browser = new ChromeDriver();
                break;
        }
        return browser;
    }
}
