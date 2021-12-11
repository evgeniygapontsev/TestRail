package tests;

import adapters.ProjectAdapter;
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
    TestRunsPage testRunsPage;
    ProjectAdapter projectAdapter;

    @BeforeMethod
    public void setup(@Optional ITestContext context) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
        options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
        options.addArguments("--headless"); // only if you are ACTUALLY running headless
        options.addArguments("--headless"); // only if you are ACTUALLY running headless
        options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
        options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
//        userName = System.getenv().getOrDefault("TESTRAIL_USER", PropertyReader.getProperty("testrail.user"));
//        password = System.getenv().getOrDefault("TESTRAIL_PASS", PropertyReader.getProperty("testrail.pass"));
        userName = "gapontsev_testrail@mailinator.com";
        password = "wdNMO3SgU6GSJ6XKkB/2";
        loginPage = new LoginPage(driver);
        dashboardPage =  new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);
        addTestCasePage = new AddTestCasePage(driver);
        projectPage = new ProjectPage(driver);
        administrationPage = new AdministrationPage(driver);
        testCasePage = new TestCasePage(driver);
        allCasesPage = new AllCasesPage(driver);
        testRunsPage = new TestRunsPage(driver);
        projectAdapter = new ProjectAdapter();
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
