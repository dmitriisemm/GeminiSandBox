package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;
    protected String url;
    protected String browser;
    protected String testSuiteName;
    protected String testMethodName;


    @Parameters({ "url","browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(String url, @Optional("chrome") String browser, ITestContext ctx, Method method) {
        this.url = url;
        this.testSuiteName = ctx.getSuite().getName();
        this.testMethodName = method.getName();

        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        // Initializing browser
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        driver = factory.createDriver();

        // Maximize browser window
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        // Close browser
        driver.quit();
    }
}
