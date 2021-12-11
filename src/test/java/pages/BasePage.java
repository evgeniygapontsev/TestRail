package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

public class BasePage {
    public static final String baseURL = System.getenv().getOrDefault("TESTRAIL_URL", PropertyReader.getProperty("testrail.url"));
//    public static final String baseURL = "https://gapontsevevg.testrail.io/";
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
}
