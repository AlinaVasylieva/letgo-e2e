package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.TestHelper;
import org.junit.Assert;
import pageObject.SearchPage;

import java.util.ArrayList;
import java.util.List;

/**
 * SearchSteps class contains implementation of search.feature steps
 */
public class SearchSteps extends BaseTest {

    SearchPage searchPage;
    List<String> beforeSearchItems = new ArrayList<String>();

    @After
    public void afterTest(){
        tearDown();
    }

    //Given's

    @Given("^I navigate to search page$")
    public void iNavigateToSearchPage() throws Throwable {
        searchPage = openSearchPage();
    }

    //And's

    @And("^I get current search items on the page$")
    public void iGetCurrentSearchItemsOnThePage() throws Throwable {
        beforeSearchItems = searchPage.getAllResultsTitles();
    }

    @And("^click on Cars section filter$")
    public void clickOnCarsSectionFilter() throws Throwable {
        searchPage.clickCarsSection();
    }

    @And("^search field contains \"([^\"]*)\" placeholder text$")
    public void searchFieldContainsPlaceholderText(String searchFieldEmptyText) throws Throwable {
        Assert.assertTrue(searchPage.getSearchFieldPlaceholderTxt().equals(searchFieldEmptyText));
    }

    //When's

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String searchTxt) throws Throwable {
        searchPage.searchForTxt(searchTxt);
        //TestHelper.generate1260CharsString();
    }

    @When("^I search for \"([^\"]*)\" using Search Button$")
    public void iSearchForUsingSearchButton(String searchTxt) throws Throwable {
        searchPage.searchForItemViaSearchIcon(searchTxt);
    }

    @When("^I clear search field$")
    public void iClearSearchField() throws Throwable {
        searchPage.clearInputAndSubmit();
    }

    @When("^I click on Cross Icon$")
    public void iClickOnCrossIcon() throws Throwable {
        searchPage.clickCrossIcon();
    }

    @When("^I search for item using heavy query$")
    public void iSearchForItemUsingHeavyQuery() throws Throwable {
        searchPage.searchForTxt(TestHelper.generate1260CharsString());
    }

    @When("^I refresh the page$")
    public void iRefreshThePage() throws Throwable {
        searchPage.refreshPage();
        searchPage = new SearchPage(driver);
    }

    //Then's

    @Then("^each of results displayed contains \"([^\"]*)\"$")
    public void eachOfResultsDisplayedContains(String expectedDisplayedTxt) throws Throwable {
        List<String> titles = searchPage.getAllResultsTitles();
        for (String title : titles){
            Assert.assertTrue(title.contains(expectedDisplayedTxt));
        }
    }

    @Then("^search items on page are updated$")
    public void searchItemsOnPageAreUpdated() throws Throwable {
        List<String> afterSearchItems = searchPage.getAllResultsTitles();
        Assert.assertFalse(beforeSearchItems.equals(afterSearchItems));
    }

    @Then("^I get \"([^\"]*)\" result$")
    public void iGetResult(String emptyResultExpected) throws Throwable {
        String emptyResultText = searchPage.getResultsEmptyTxt();
        Assert.assertTrue(emptyResultText.equals(emptyResultExpected));
    }

    @Then("^search field is empty$")
    public void searchFieldIsEmpty() throws Throwable {
        Assert.assertTrue(searchPage.getSearchFieldTxt().equals(""));
    }

}
