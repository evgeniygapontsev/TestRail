package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navigation-dashboard")));
        } catch (Exception exception) {
            exception.printStackTrace();
            Assert.fail("DashboardPage was not opened");
        }
        return true;
    }

    public void addFirstProject() {
        driver.findElement(By.id("navigation-empty-addproject")).click();
    }

    public void addAnotherProject() {
        driver.findElement(By.id("sidebar-projects-add")).click();
    }

    public void addExampleProject() {
        driver.findElement(By.id("navigation-empty-addexampleproject")).click();
    }

    public void openProject(String projectName) {
//        WebElement project = driver.findElement(By.id(""));
//        project.getText().contains(projectName);
//        project.click();
        driver.findElement(By.xpath(String.format(
                "//div[contains(@class, 'summary-title text-ppp')]//descendant::a[contains(text(), '%s')]", projectName))).click();
//        driver.findElement(By.xpath("//*[@id='content_container']/..//*[contains(text(), 'Project #1']")).click();
    }
}
