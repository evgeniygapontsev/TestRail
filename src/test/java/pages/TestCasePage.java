package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestCasePage extends BasePage{

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Check that case is already created")
    public String caseCreated() {
        log.info("Case was created");
        return driver.findElement(By.xpath(
                "//*[contains(@id, 'content-inner')]//*[contains(@class, 'message-success')]")).getText();
    }

    public void addAnotherCase() {
        driver.findElement(By.xpath(
                "//*[contains(@class, 'message message-success')]//a[contains(text(), 'Add another')]")).click();
    }

    public void testCasesButton() {
        driver.findElement(By.xpath(
                "//*[contains(@class, 'content-breadcrumb')]//a[contains(text(), 'Test Cases')]")).click();
    }
}
