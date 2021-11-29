package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdministrationPage extends BasePage {

    public AdministrationPage(WebDriver driver) {
        super(driver);
    }

    public void goToDashboard() {
        driver.findElement(By.id("navigation-dashboard")).click();
    }

    public void openProject(String projectName) {
        driver.findElement(By.xpath(
                "//span[contains(@class, 'hidden hoverAction')]//descendant::*[contains(@class, 'icon-small-openswindow')]")).click();

    }

    public void deleteProject(String projectName) {

        driver.findElement(By.xpath(String.format(
                "//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'hoverSensitive')]" +
                        "//*[contains(@class, 'delete')]", projectName))).click();
        //привязать к тексту, подняться вверх, спуститься к крестику
        driver.findElement(By.xpath(
                "//*[contains(@class,'ui-dialog-content')]//*[@name='deleteCheckbox']")).click();
        driver.findElement(By.xpath(
                "//*[contains(@class,'ui-dialog-content')]//*[contains(@class,'button-ok')]")).click();
        Assert.assertEquals("Successfully deleted the project.", "Successfully deleted the project.");
    }
}
