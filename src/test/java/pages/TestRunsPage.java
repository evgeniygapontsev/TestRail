package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class TestRunsPage extends BasePage{

    public TestRunsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTestRunsPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'content-header-title page_title')]")));
        } catch (Exception exception) {
            exception.printStackTrace();
            Assert.fail("Test Runs and Results page was not opened");
            log.error(exception.getMessage());
        }
        return true;
    }

    public void addTestPlan() {
        driver.findElement(By.id("navigation-plans-add")).click();
        driver.findElement(By.id("name")).sendKeys("Demo Test Plan");
        driver.findElement(By.id("description_display")).sendKeys("Check out new added fitches");
        driver.findElement(By.id("accept")).click();
    }
}
