package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check that Dashboard Page was opened")
    public boolean isDashboardPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navigation-dashboard")));
        } catch (Exception exception) {
            exception.printStackTrace();
            Assert.fail("DashboardPage was not opened");
            log.error(exception.getMessage());
        }
        return true;
    }

    public void openAdminPage() {
        driver.findElement(By.id("navigation-admin")).click();
    }

    public void addFirstProject() {
        driver.findElement(By.id("navigation-empty-addproject")).click();
    }

    @Step("Click to start creating a project")
    public void addAnotherProject() {
        driver.findElement(By.id("sidebar-projects-add")).click();
    }

    public void addExampleProject() {
        driver.findElement(By.id("navigation-empty-addexampleproject")).click();
    }

    @Step("Open project with {projectName}")
    public void openProject(String projectName) {
        log.info("Open project with name '{}'", projectName);
        driver.findElement(By.xpath(String.format(
                "//div[contains(@class, 'summary-title text-ppp')]//descendant::a[contains(text(), '%s')]",
                projectName))).click();
    }
}
