package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public void addMilestones() {
        driver.findElement(By.id("sidebar-milestones-add")).click();
    }

    public void addTestRun() {
        driver.findElement(By.id("sidebar-runs-add")).click();
    }

    public void addTestCase() {
        driver.findElement(By.id("sidebar-cases-add")).click();
    }

    public void overview() {
        driver.findElement(By.id("navigation-projects")).click();
    }

    public void toDo() {
        driver.findElement(By.id("navigation-todos")).click();
    }

    public void milestones() {
        driver.findElement(By.id("navigation-milestones")).click();
    }

    public void testRunsAndResults() {
        driver.findElement(By.id("navigation-runs")).click();
    }

    public void testCases() {
        driver.findElement(By.id("navigation-suites")).click();
    }

    public void reports() {
        driver.findElement(By.id("navigation-reports")).click();
    }

}
