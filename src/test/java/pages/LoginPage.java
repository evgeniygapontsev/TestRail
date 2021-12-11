package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Login Page")
    public LoginPage openLoginPage() {
        log.info("Open page with actual url");
        driver.get(baseURL);
        return this;
    }

    @Step("Log in on site with {userName} and {password}")
    public DashboardPage login(String userName, String password) {
        log.info("Log in on site using '{}' and '{}'", userName, password);
        driver.findElement(By.id("name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("button_primary")).click();
        return new DashboardPage(driver);

    }
}
