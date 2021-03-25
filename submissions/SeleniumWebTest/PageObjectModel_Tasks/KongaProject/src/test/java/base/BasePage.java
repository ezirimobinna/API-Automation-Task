package base;

import Home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage {

    private WebDriver driver;
    public HomePage homePage;

    //Initialize WebDriver, open the browser  & go to the URL before conducting the test
    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\addmin\\TestCodeCamp_Programme\\submissions\\SeleniumWebTest\\PageObjectModel_Tasks\\KongaProject\\resources\\chromedriver.exe");
        //Initializing WebDriver
        driver = new ChromeDriver();

        //Maximize web browser
        driver.manage().window().maximize();
        //Open URL on browser
        driver.get("https://www.konga.com/");
        homePage = new HomePage(driver);
    }

    //Close WebDriver and browser after completing the test
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
