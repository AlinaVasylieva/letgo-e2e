package pageObject;

import org.openqa.selenium.WebDriver;

/**
 * BasePage class contains methods and data to be inherited for other Page Object classes
 */
public class BasePage {

        protected WebDriver driver;

        public static final String MAIN_PAGE_TITLE = "Compra y vende cosas de segunda mano en España - letgo";
        public static final int WAIT_SECONDS = 10;

        public BasePage(WebDriver driver)
        {
            this.driver = driver;
        }

        public String getPageTitle()
        {
            return driver.getTitle();
        }

        public String getPageUrl()
        {
            return driver.getCurrentUrl();
        }

       public void refreshPage(){
            driver.navigate().refresh();
       }

}
