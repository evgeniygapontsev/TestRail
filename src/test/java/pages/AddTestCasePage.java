package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.CaseInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Dropdown;
import wrappers.Input;

@Log4j2
public class AddTestCasePage extends BasePage {
    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Create new test case with {caseInfo}")
    public void fillInDetails(CaseInfo caseInfo) {
        log.info("Fill info of case '{}'", caseInfo);
        new Input(driver, "Title").writeInFields(caseInfo.getTitle());
        new Dropdown(driver, "Section").selectOption(caseInfo.getSection());
        new Dropdown(driver, "Template").selectOption(caseInfo.getTemplate());
        new Dropdown(driver, "Type").selectOption(caseInfo.getType());
        new Dropdown(driver, "Priority").selectOption(caseInfo.getPriority());
        new Input(driver, "Estimate").writeInFields(caseInfo.getEstimate());
        driver.findElement(By.id("refs")).sendKeys(caseInfo.getReferences());
        new Dropdown(driver, "Automation Type").selectOption(caseInfo.getAutomationType());
        new Input(driver, "preconditions").writeNextFields(caseInfo.getPreconditions());
        new Input(driver, "steps").writeNextFields(caseInfo.getSteps());
        new Input(driver, "expected result").writeNextFields(caseInfo.getExpectedResult());
    }

    @Step("Confirm adding new case")
    public void addNewCase() {
        driver.findElement(By.id("accept")).click();
    }

    public void addAndNext() {
        driver.findElement(By.id("accept_and_next")).click();
    }

    public void cancel() {
        driver.findElement(By.xpath("//*[@class='button-group']/..//*[contains(text(), 'Cancel')]")).click();
    }

}
