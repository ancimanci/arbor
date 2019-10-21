import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import util.WebDriverWrapper;

public class TestHomePage {

    private HomePage homePage;
    private static final Logger logger = LoggerFactory.getLogger(TestHomePage.class);

    @BeforeTest

    public void setUp() {
        WebDriverWrapper.setUpDriver();
    }

    @BeforeMethod
    public void openBrowser() throws Exception {
        homePage = new HomePage(WebDriverWrapper.createDriver());
        homePage.open();

    }


    @Test
    public void testLogin() {
        homePage.sendUsername("user");
        homePage.sendPassword("pwd");
        homePage.clickbuttonLogin();

        homePage.assertElementText();

    }
    @AfterMethod
    public void tearDown() {
        homePage.quit();
    }

}
