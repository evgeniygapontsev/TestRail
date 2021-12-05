package tests;

import models.CaseInfo;
import models.CaseInfoFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test(description = "Create the project")
    public void projectAndPlanCreate() {

        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        assertTrue(dashboardPage.isDashboardPageOpened(), "DashboardPage was not opened");
        dashboardPage.addAnotherProject();
        addProjectPage.isPageOpened();
        assertTrue(addProjectPage.isPageOpened(), "Page to add new project was not opened");
        addProjectPage.createNewProject("Project TR", "This is a new project");
        assertTrue(administrationPage.projectWasCreated("Project TR"), "Project wasn't created");
        administrationPage.goToDashboard();
        dashboardPage.openProject("Project TR");
        projectPage.isPageOpened();
        assertTrue(projectPage.isPageOpened(), "ProjectPage wasn't opened");
        projectPage.testRuns();
        testRunsPage.isTestRunsPageOpened();
        assertTrue(testRunsPage.isTestRunsPageOpened(), "Test Runs and Results page was not opened");
        testRunsPage.addTestPlan();
        projectPage.overviewButton();
        projectPage.testPlanExist("Demo Test Plan");
        assertTrue(projectPage.testPlanExist("Demo Test Plan"), "Test Plan wasn't created");

    }

    @Test(description = "Update the project")
    public void createUpdateProject() {
        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        assertTrue(dashboardPage.isDashboardPageOpened(), "DashboardPage was not opened");
        dashboardPage.addAnotherProject();
        addProjectPage.isPageOpened();
        assertTrue(addProjectPage.isPageOpened(), "Page to add new project was not opened");
        addProjectPage.createNewProject("Demo Project", "This is a new project");
        assertTrue(administrationPage.projectWasCreated("Demo Project"), "Project wasn't created");
        administrationPage.goToDashboard();
        dashboardPage.openProject("Demo Project");
        projectPage.isPageOpened();
        assertTrue(projectPage.isPageOpened(), "ProjectPage wasn't opened");
        projectPage.editButton();
        addProjectPage.updateInfoOfProject("Project #1");
        String confirmMessage = projectPage.confirmUpdate();
        assertEquals(confirmMessage, "Successfully updated the project.");

    }
}
