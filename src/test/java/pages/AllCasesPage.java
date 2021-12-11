package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class AllCasesPage extends BasePage {

    public AllCasesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check the drag and drop option")
    public void dragAndDrop() {
        log.info("Drag and drop done");
        WebElement startPosition = driver.findElement(By.xpath(
                "//*[contains(@class, 'odd caseDroppable')]//*[contains(@class, 'dragdrop-action')]"));
        WebElement finishPosition = driver.findElement(By.xpath(
                "//*[contains(@class, 'even caseDroppable')]//*[contains(@class, 'dragdrop-action')]"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(startPosition)
                .clickAndHold()
                .moveToElement(finishPosition)
                .release().build().perform();

    }

    @Step("Confirm move with drag and drop")
    public void moveClick() {
        log.info("Drag and drop confirmed");
        driver.findElement(By.xpath(
                "//li[contains(@id, 'casesDndMove')]//a[contains(@onclick, 'this.blur(); App.Cases.dropMove(); return false;')]"))
                .click();
    }

    @Step("Click to button to select cases' checkbox")
    public void selectCheckbox() {
        driver.findElement(By.xpath("//*[contains(@onclick, 'App.Cases.onToggleAllClick(this)')]")).click();
    }

    @Step("Confirm deleting cases")
    public void deleteCases() {
        log.info("Delete cases by checkbox");
        driver.findElement(By.id("deleteCases")).click();
        driver.findElement(By.xpath(
                "//a[contains(@class, 'button-no-margin-right dialog-action-secondary button-black')]")).click();
        driver.findElement(By.xpath(
                "//a[contains(@class, 'button button-left button-black dialog-action-default')]")).click();
    }

    @Step("Confirm that cases was deleted")
    public String wasCasesDeleted() {
        log.info("Cases was deleted");
        return driver.findElement(By.xpath("//span[contains(@class, 'text-secondary section-count')]")).getText();
    }
}
