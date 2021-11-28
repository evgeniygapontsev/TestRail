package tests;

import models.CaseInfo;
import models.CaseInfoFactory;
import org.testng.annotations.Test;

public class CreateProjectTest extends BaseTest {

    @Test
    public void createProject() {

        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        dashboardPage.addAnotherProject();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject("Project #1", "This is a new project");
        administrationPage.deleteProject("Project #1");

    }
}
