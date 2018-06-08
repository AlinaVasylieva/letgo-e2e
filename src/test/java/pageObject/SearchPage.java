package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

/**
 * SearchPage class elements and methods for them for Sign up webpage process
 */
public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);

        if(!MAIN_PAGE_TITLE.equals(getPageTitle())){
            String url = getPageUrl();
            throw new IllegalStateException("This is not home page! " + url);
        }
    }

    //Locators

    @FindBy(name = "searchField")
    @CacheLookup
    private WebElement searchField;

    @FindBy(className = "Icon__icon-search___E1j1G")
    @CacheLookup
    private WebElement searchIcon;

    @FindBy(className = "Header__searchForm___22ULt")
    @CacheLookup
    private WebElement searchFieldPlaceholder;

    @FindBy(css = "div.ProductListContainer__noContent___3ObXR > div > h5 > span")
    @CacheLookup
    private WebElement noResultsFound;

    @FindBy(css = "div.NotFound__e404___27nFc > div > p > span")
    @CacheLookup
    private WebElement noWebPageResultsFound;

    @FindBy(id = "9")
    @CacheLookup
    private WebElement carsSection;

    @FindBy (className = "Header__clearSearch___21TfM")
    @CacheLookup
    private  WebElement crossIcon;

    @FindBy(css = "button[data-test='login']")
    @CacheLookup
    private WebElement loginBtn;

    //Methods
    public SearchPage searchForTxt(String text){
        searchField.sendKeys(text);
        searchField.submit();
        return this;
    }

    public String getSearchFieldTxt(){
        return searchField.getText();
    }

    public List<String> getAllResultsTitles(){
        List<String> titles = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.
                cssSelector("div.ReactVirtualized__Item_Info.flex.flex-column.justify-center > h4"));

        for (WebElement elem : elements){
            titles.add(elem.getText());
        }
        return titles;
    }

    public SearchPage clearInputAndSubmit(){
        searchField.clear();
        searchField.submit();
        return this;
    }

    public SearchPage searchForItemViaSearchIcon(String text){
        searchField.sendKeys(text);
        searchIcon.click();
        return this;
    }

    public String getSearchFieldPlaceholderTxt(){
        return searchFieldPlaceholder.getText();
    }

    public String getResultsEmptyTxt(){
        return noResultsFound.getText();
    }

    public SearchPage clickCarsSection(){
        carsSection.click();
        return this;
    }

    public SearchPage clickCrossIcon(){
        crossIcon.click();
        return this;
    }

    public SearchPage clickLoginBtn(){
        loginBtn.click();
        return this;
    }

}
