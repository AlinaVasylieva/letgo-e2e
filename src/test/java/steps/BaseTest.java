package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.BasePage;
import pageObject.SearchPage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * BasePage class contains methods and data to be inherited for other Test Step classes
 */
public class BaseTest {

    public WebDriver driver;
    public String urlSearchPage;

    public BaseTest(){
        if(urlSearchPage == null){
            initializeProperties();
        }
    }

    private void initializeProperties(){
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("e2e-tests.properties");

        try{
            prop.load(stream);
        } catch (IOException e){
            //TBD ADD LOGGING HERE!!!
        }

        urlSearchPage = prop.getProperty("e2e-tests.urlHome");

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(BasePage.WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(BasePage.WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(BasePage.WAIT_SECONDS, TimeUnit.SECONDS);
    }

    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public SearchPage openSearchPage(){
        driver.navigate().to(urlSearchPage);
        return new SearchPage(driver);
    }
}
