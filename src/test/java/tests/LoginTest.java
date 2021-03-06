package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Log in on website")
    public void login() {
        boolean isOpened = loginPage
                .openLoginPage()
                .login(userName, password)
                .isDashboardPageOpened();
        assertTrue(isOpened, "Dashboard page was opened");

    }
}
