package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WholeDeletingTest extends BaseTest {

    @Test
    public void deleteProject() {
        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        assertTrue(dashboardPage.isDashboardPageOpened(), "DashboardPage was not opened");
        dashboardPage.openAdminPage();
        administrationPage.projectsChapter();
        administrationPage.deleteProject("Project #1");
        String confirm = administrationPage.projectWasDeleted();
        assertEquals(confirm, "Successfully deleted the project.");
    }
}
