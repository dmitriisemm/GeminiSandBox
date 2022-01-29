package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;
    protected String username;
    protected String password;
    protected String url;
    protected String browser;

    @Parameters({ "url","username","password","browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(String url, String username, String password, @Optional("chrome") String browser, ITestContext ctx) {
        this.username = username;
        this.password = password;
        this.url = url;
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        // Initializing browser
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        driver = factory.createDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        // Close browser
        driver.quit();
    }
}
