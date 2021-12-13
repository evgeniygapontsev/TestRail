package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AllCasesPage extends BasePage {

    public AllCasesPage(WebDriver driver) {
        super(driver);
    }

    public void dragAndDrop() {
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

    public void moveClick() {
        driver.findElement(By.xpath(
                "//li[contains(@id, 'casesDndMove')]//a[contains(@onclick, 'this.blur(); App.Cases.dropMove(); return false;')]"))
                .click();
    }

    public void selectCheckbox() {
        driver.findElement(By.xpath("//*[contains(@onclick, 'App.Cases.onToggleAllClick(this)')]")).click();
    }

    public void deleteCases() {
        driver.findElement(By.id("deleteCases")).click();
        driver.findElement(By.xpath(
                "//a[contains(@class, 'button-no-margin-right dialog-action-secondary button-black')]")).click();
        driver.findElement(By.xpath(
                "//a[contains(@class, 'button button-left button-black dialog-action-default')]")).click();
    }

    public String wasCasesDeleted() {
        return driver.findElement(By.xpath("//span[contains(@class, 'text-secondary section-count')]")).getText();
    }
}
