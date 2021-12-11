package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class AdministrationPage extends BasePage {

    public AdministrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on button to go to Dashboard Page")
    public void goToDashboard() {
        driver.findElement(By.id("navigation-dashboard")).click();
    }

    public void projectsChapter() {
        driver.findElement(By.id("navigation-sub-projects")).click();
    }

    @Step("Delete project with {projectName}")
    public void deleteProject(String projectName) {
        log.info("Delete project with name '{}'", projectName);
        driver.findElement(By.xpath(String.format(
                "//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'hoverSensitive')]" +
                        "//*[contains(@class, 'delete')]", projectName))).click();
        driver.findElement(By.xpath(
                "//*[contains(@class,'ui-dialog-content')]//*[@name='deleteCheckbox']")).click();
        driver.findElement(By.xpath(
                "//*[contains(@class,'ui-dialog-content')]//*[contains(@class,'button-ok')]")).click();
    }

    @Step("Confirm that project doesn't exist")
    public String projectWasDeleted() {
        log.info("Project was deleted");
        return driver.findElement(By.xpath("//*[contains(@class, 'message message-success')]")).getText();
    }

    @Step("Confirm that project was created with {projectName}")
    public boolean projectWasCreated(String projectName) {
        log.info("The project with th name '{}' is exist ", projectName);
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
