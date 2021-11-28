package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AddProjectPage extends BasePage{

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navigation-dashboard")));
        } catch (Exception exception) {
            Assert.fail("Page to add new project was not opened");
        }
    }

    public void createNewProject(String name, String announcement) {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("announcement")).sendKeys(announcement);
        driver.findElement(By.id("show_announcement")).click();
        driver.findElement(By.id("accept")).click();
    }
}
