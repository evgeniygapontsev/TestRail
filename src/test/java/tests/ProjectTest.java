package tests;

import models.CaseInfo;
import models.CaseInfoFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test
    public void createProject() {

        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        assertTrue(dashboardPage.isDashboardPageOpened(), "DashboardPage was not opened");
        dashboardPage.addAnotherProject();
        addProjectPage.isPageOpened();
        assertTrue(addProjectPage.isPageOpened(), "Page to add new project was not opened");
        addProjectPage.createNewProject("Demo Project", "This is a new project");
        assertTrue(administrationPage.projectWasCreated("Demo Project"), "Project wasn't created");
    }

    @Test
    public void updateProject() {
        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        assertTrue(dashboardPage.isDashboardPageOpened(), "DashboardPage was not opened");
        dashboardPage.openProject("Demo Project");
        projectPage.isPageOpened();
        assertTrue(projectPage.isPageOpened(), "ProjectPage wasn't opened");
        projectPage.editButton();
        addProjectPage.updateInfoOfProject("Project #1");
        String confirmMessage = projectPage.confirmUpdate();
        assertEquals(confirmMessage, "Successfully updated the project.");

    }
}
