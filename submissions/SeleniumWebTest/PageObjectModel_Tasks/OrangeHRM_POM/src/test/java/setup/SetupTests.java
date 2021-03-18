package setup;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetupTests {


    private WebDriver driver;
    //Create LoginPage object
    protected LoginPage loginPage;
    //Create DashboardPage Object
    protected DashboardPage dashboardPage;

    @BeforeTest
    public void setUp()
    {
        //Selenium WebDriver needs this executable in order to know which browser to run your test
        //Browser setup for Chrome
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //Instantiate WebDriver object
        driver = new ChromeDriver();

        /* Browser setup for Firefox
        System.setProperty("webdriver.gecko.driver", "E:/test_automation/resources/geckodriver.exe");
        driver = new FirefoxDriver();
         */

        //Any activity you want to perform concerning your automated test can now be done using the driver

        //Maximize window size
        driver.manage().window().maximize();

        //Launch the application
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Instantiate login page after launching the browser - Handle
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void closeBrowser()
    {
        // ".close" would close the window but the ".quit" would exit the session
        driver.quit();
    }
}

