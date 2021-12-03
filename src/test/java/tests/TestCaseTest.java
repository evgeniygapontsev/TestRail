package tests;

import models.CaseInfo;
import models.CaseInfoFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCaseTest extends BaseTest{

    @Test
    public void createTestCase() {

        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        assertTrue(dashboardPage.isDashboardPageOpened(), "DashboardPage was not opened");
        dashboardPage.openProject("Project #1");
        projectPage.isPageOpened();
        assertTrue(projectPage.isPageOpened(), "ProjectPage wasn't opened");
        projectPage.addTestCase();
        CaseInfo caseInfo = CaseInfoFactory.get();
        addTestCasePage.fillInDetails(caseInfo);
        addTestCasePage.addNewCase();
        String confirm = testCasePage.caseCreated();
        assertEquals(confirm, "Successfully added the new test case. Add another");
        testCasePage.addAnotherCase();
        CaseInfo caseInfoMore = CaseInfoFactory.getAgain();
        addTestCasePage.fillInDetails(caseInfoMore);
        addTestCasePage.addNewCase();
        String confirmation = testCasePage.caseCreated();
        assertEquals(confirmation, "Successfully added the new test case. Add another");
        testCasePage.testCasesButton();
        allCasesPage.dragAndDrop();
        allCasesPage.moveClick();
        allCasesPage.selectCheckbox();
        allCasesPage.deleteCases();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@class, 'text-secondary section-count')]"), "0"));
        String messageDel = allCasesPage.wasCasesDeleted();
        assertEquals(messageDel, "0");
    }
}
