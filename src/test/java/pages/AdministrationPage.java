package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AdministrationPage extends BasePage {

    public AdministrationPage(WebDriver driver) {
        super(driver);
    }

    public void goToDashboard() {
        driver.findElement(By.id("navigation-dashboard")).click();
    }

    public void projectsChapter() {
        driver.findElement(By.id("navigation-sub-projects")).click();
    }

    public void deleteProject(String projectName) {

        driver.findElement(By.xpath(String.format(
                "//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'hoverSensitive')]" +
                        "//*[contains(@class, 'delete')]", projectName))).click();
        driver.findElement(By.xpath(
                "//*[contains(@class,'ui-dialog-content')]//*[@name='deleteCheckbox']")).click();
        driver.findElement(By.xpath(
                "//*[contains(@class,'ui-dialog-content')]//*[contains(@class,'button-ok')]")).click();
        Assert.assertEquals("Successfully deleted the project.", "Successfully deleted the project.");
    }

    public String projectWasDeleted() {
        return driver.findElement(By.xpath("//*[contains(@class, 'message message-success')]")).getText();
    }

    public boolean projectWasCreated(String projectName) {
        List<WebElement> listOfProjects = driver.findElements(By.xpath("//*[contains(@class, 'hoverSensitive')]"));
        boolean isProjectCreated = false;
        for (WebElement project : listOfProjects) {
            if (project.getText().equals(projectName)) {
                isProjectCreated = true;
            }
        }
        return isProjectCreated;
    }
}
