package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DeleteProjectTest extends BaseTest {

    @Test(description = "Create and delete the project")
    public void projectDelete() {
        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        assertTrue(dashboardPage.isDashboardPageOpened(), "DashboardPage was not opened");
        dashboardPage.addAnotherProject();
        addProjectPage.isPageOpened();
        assertTrue(addProjectPage.isPageOpened(), "Page to add new project was not opened");
        addProjectPage.createNewProject("Project to delete", "This is a new project");
        assertTrue(administrationPage.projectWasCreated("Project to delete"), "Project wasn't created");
        administrationPage.deleteProject("Project to delete");
        String confirm = administrationPage.projectWasDeleted();
        assertEquals(confirm, "Successfully deleted the project.");
    }
}
