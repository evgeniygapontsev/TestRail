package pages;

import models.CaseInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.Dropdown;
import wrappers.Input;

public class AddTestCasePage extends BasePage {
    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    public void fillInDetails(CaseInfo caseInfo) {
        new Input(driver, "Title").writeInFields(caseInfo.getTitle());
        new Dropdown(driver, "Section").selectOption(caseInfo.getSection());
        new Dropdown(driver, "Template").selectOption(caseInfo.getTemplate());
        new Dropdown(driver, "Type").selectOption(caseInfo.getType());
        new Dropdown(driver, "Priority").selectOption(caseInfo.getPriority());
        new Input(driver, "Estimate").writeInFields(caseInfo.getEstimate());
        new Input(driver, "References").writeInFields(caseInfo.getReferences());
        new Dropdown(driver, "Automation Type").selectOption(caseInfo.getAutomationType());
        new Input(driver, "Preconditions").writeInFields(caseInfo.getPreconditions());
        new Input(driver, "Steps").writeInFields(caseInfo.getSteps());
        new Input(driver, "Expected Result").writeInFields(caseInfo.getExpectedResult());

    }

    public void addNewCase() {
        driver.findElement(By.id("accept")).click();
        try {
            driver.findElement(By.xpath("//*[contains(@class, 'message-success)]" +
                    "[contains(text(), 'Successfully added the new test case. ')]")).isDisplayed();
        } catch (Exception exception) {
            exception.printStackTrace();
            Assert.fail("Message wasn't appeared");
        }
    }

    public void addAndNext() {
        driver.findElement(By.id("accept_and_next")).click();
    }

    public void cancel() {
        driver.findElement(By.xpath("//*[@class='button-group']/..//*[contains(text(), 'Cancel')]")).click();
    }

}
