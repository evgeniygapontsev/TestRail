package tests;

import models.CaseInfo;
import models.CaseInfoFactory;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest{

    @Test
    public void createTestCase() {

        loginPage.openLoginPage();
        loginPage.login(userName, password);
        dashboardPage.isDashboardPageOpened();
        dashboardPage.addAnotherProject();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject("Project #1", "This is a new project");
//        administrationPage.openProject("Project #1");
        administrationPage.goToDashboard();
        dashboardPage.openProject("Project #1");
        projectPage.addTestCase();
        CaseInfo caseInfo = CaseInfoFactory.get();
        addTestCasePage.fillInDetails(caseInfo);
        addTestCasePage.addNewCase();
    }
}
