package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage extends BasePage{

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    public String caseCreated() {
        return driver.findElement(By.xpath(
                "//*[contains(@id, 'content-inner')]//*[contains(@class, 'message-success')]")).getText();
    }

    public void adminPageButton() {
        driver.findElement(By.id("navigation-admin")).click();
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
