package tests;

import models.CaseInfo;
import models.CaseInfoFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestCaseTest extends BaseTest{

    @Test(description = "Create and delete test cases of the project")
    public void testCaseCreate() {

        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        assertTrue(dashboardPage.isDashboardPageOpened(), "DashboardPage was not opened");
        dashboardPage.addAnotherProject();
        addProjectPage.isPageOpened();
        assertTrue(addProjectPage.isPageOpened(), "Page to add new project was not opened");
        addProjectPage.createNewProject("Project WTC", "This is a new project");
        assertTrue(administrationPage.projectWasCreated("Project WTC"), "Project wasn't created");
        administrationPage.goToDashboard();
        dashboardPage.openProject("Project WTC");
        projectPage.isPageOpened();
        assertTrue(projectPage.isPageOpened(), "ProjectPage wasn't opened");
        projectPage.addTestCase();
        CaseInfo caseInfo = CaseInfoFactory.get();
        addTestCasePage.fillInDetails(caseInfo);
        addTestCasePage.addNewCase();
        String confirm = testCasePage.caseCreated();
        assertEquals(confirm, "Successfully added the new test case. Add another");
        testCasePage.addAnotherCase();
        CaseInfo caseInfoMore = CaseInfoFactory.get();
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

    @AfterMethod
    public void deleteProjectByApi() {
        int actualId = projectAdapter.getProjectId("Project WTC");
        projectAdapter.getProject(actualId);
        projectAdapter.deleteProject(actualId);
        assertFalse(projectAdapter.isProjectExist("Project WTC"), "Project wasn't deleted");
    }
}
