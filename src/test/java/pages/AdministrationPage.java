package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdministrationPage extends BasePage{

    public AdministrationPage(WebDriver driver) {
        super(driver);
    }

    public void goToDashboard() {
        driver.findElement(By.id("navigation-dashboard")).click();
    }

    public void openProject(String projectName) {
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath
//                ("//span[contains(@class, 'hidden hoverAction')]//descendant::*[contains(@class, 'icon-small-openswindow')]")))
//                .click();
        driver.findElement(By.xpath(
                "//span[contains(@class, 'hidden hoverAction')]//descendant::*[contains(@class, 'icon-small-openswindow')]")).click();

    }

    public void deleteProject(String projectName) {

        driver.findElement(By.xpath(String.format(
                "//div[contains(@class, 'icon-small-delete')]//*[contains(text(), '%s')]", projectName))).click();
        driver.findElement(By.xpath(
                "//*[contains(@class,'ui-dialog-content')]//*[@name='deleteCheckbox']")).click();
        driver.findElement(By.xpath(
                "//*[contains(@class,'ui-dialog-content')]//*[@name='deleteCheckbox']")).isSelected();
        driver.findElement(By.xpath(
                "//*[contains(@class,'ui-dialog-content')]//*[contains(@class,'button-ok')]")).click();
        Assert.assertEquals("Successfully deleted the project.", "Successfully deleted the project.");
    }
}
//*[contains(@class,'ui-dialog-content')]//*[contains(@class,'button-ok'
//div[contains(@class, 'button-group dialog-buttons-highlighted')]" + "//a[contains(text(), 'OK')]"