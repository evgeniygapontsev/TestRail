package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

@Log4j2
public class ProjectPage extends BasePage {

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check that Page was opened")
    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navigation-project")));
        } catch (Exception exception) {
            exception.printStackTrace();
            Assert.fail("ProjectPage wasn't opened");
            log.error(exception.getMessage());
        }
        return true;
    }

    public void editButton() {
        driver.findElement(By.xpath("//*[contains(@class, 'button-edit')]")).click();
    }

    @Step("Confirm that project was updated")
    public String confirmUpdate() {
        return driver.findElement(By.xpath("//*[contains(@class, 'message message-success')]")).getText();
    }

    public void addTestCase() {
        driver.findElement(By.id("sidebar-cases-add")).click();
    }

    public void testCases() {
        driver.findElement(By.id("navigation-suites")).click();
    }

    public void testRuns() {
        driver.findElement(By.id("navigation-runs")).click();
    }

    public void overviewButton() {
        driver.findElement(By.id("navigation-projects")).click();
    }

    @Step("Check that Test plan with {testPlanName} is exist")
    public boolean testPlanExist(String testPlanName) {
        log.info("Test plan with name '{}' was created", testPlanName);
        List<WebElement> listOfPlans = driver.findElements(By.xpath("//*[contains(@class, 'grid')]//a[contains(text(),'')]"));
        boolean isTestPlanCreated = false;
        for (WebElement project : listOfPlans) {
            if (project.getText().equals(testPlanName)) {
                isTestPlanCreated = true;
            }
        }
        return isTestPlanCreated;
    }
}

