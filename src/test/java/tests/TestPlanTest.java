package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestPlanTest extends BaseTest{

    @Test(description = "Create the project with some test plan")
    public void projectAndPlanCreate() {

        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        assertTrue(dashboardPage.isDashboardPageOpened(), "DashboardPage was not opened");
        dashboardPage.addAnotherProject();
        addProjectPage.isPageOpened();
        assertTrue(addProjectPage.isPageOpened(), "Page to add new project was not opened");
        addProjectPage.createNewProject("Project TP", "This is a new project");
        assertTrue(administrationPage.projectWasCreated("Project TP"), "Project wasn't created");
        administrationPage.goToDashboard();
        dashboardPage.openProject("Project TP");
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
    @AfterMethod
    public void deleteProjectByApi() {
        int actualId = projectAdapter.getProjectId("Project TP");
        projectAdapter.getProject(actualId);
        projectAdapter.deleteProject(actualId);
        assertFalse(projectAdapter.isProjectExist("Project TP"), "Project wasn't deleted");
    }
}
