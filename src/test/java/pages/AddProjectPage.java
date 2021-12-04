package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class AddProjectPage extends BasePage{

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navigation-dashboard")));
        } catch (Exception exception) {
            exception.printStackTrace();
            Assert.fail("Page to add new project was not opened");
            log.error(exception.getMessage());
        }
        return true;
    }

    public void createNewProject(String name, String announcement) {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("announcement")).sendKeys(announcement);
        driver.findElement(By.id("show_announcement")).click();
        driver.findElement(By.id("accept")).click();
    }

    public void updateInfoOfProject(String newName) {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(newName);
        driver.findElement(By.id("accept")).click();

    }
}
