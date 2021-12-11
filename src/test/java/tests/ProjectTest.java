package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProjectTest extends BaseTest {

    @Test(description = "Create and then update the project")
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

    @AfterMethod
    public void deleteProjectByApi() {
        int actualId = projectAdapter.getProjectId("Project #1");
        projectAdapter.getProject(actualId);
        projectAdapter.deleteProject(actualId);
        assertFalse(projectAdapter.isProjectExist("Project #1"), "Project wasn't deleted");
    }

}
