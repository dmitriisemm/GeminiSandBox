import base.BaseTest;
import org.testng.annotations.Test;

public class New extends BaseTest {

    @Test
    public void newTest() throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);
    }
}
