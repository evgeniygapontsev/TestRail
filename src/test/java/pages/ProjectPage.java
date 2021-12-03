package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProjectPage extends BasePage {

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navigation-project")));
        } catch (Exception exception) {
            exception.printStackTrace();
            Assert.fail("ProjectPage wasn't opened");
        }
        return true;
    }

    public void editButton() {
        driver.findElement(By.xpath("//*[contains(@class, 'button-edit')]")).click();
    }

    public String confirmUpdate() {
        return driver.findElement(By.xpath("//*[contains(@class, 'message message-success')]")).getText();
    }


    public void addTestCase() {
        driver.findElement(By.id("sidebar-cases-add")).click();
    }


    public void testCases() {
        driver.findElement(By.id("navigation-suites")).click();
    }


}
