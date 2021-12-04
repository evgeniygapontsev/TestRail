package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import pages.*;
import utils.PropertyReader;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    String userName;
    String password;
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AddProjectPage addProjectPage;
    AddTestCasePage addTestCasePage;
    ProjectPage projectPage;
    AdministrationPage administrationPage;
    TestCasePage testCasePage;
    AllCasesPage allCasesPage;

    @BeforeMethod
    public void setup(@Optional ITestContext context) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // only if you are ACTUALLY running headless
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        userName = System.getenv().getOrDefault("TESTRAIL_USER", PropertyReader.getProperty("testrail.user"));
        password = System.getenv().getOrDefault("TESTRAIL_PASS", PropertyReader.getProperty("testrail.pass"));
        loginPage = new LoginPage(driver);
        dashboardPage =  new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);
        addTestCasePage = new AddTestCasePage(driver);
        projectPage = new ProjectPage(driver);
        administrationPage = new AdministrationPage(driver);
        testCasePage = new TestCasePage(driver);
        allCasesPage = new AllCasesPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
