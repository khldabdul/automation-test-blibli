package com.khalidabdul.steps.ui;

import com.khalidabdul.module.ui.BlibliPage;
import com.khalidabdul.module.ui.data.BlibliPageData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class BlibliPageSteps extends ScenarioSteps {

    private BlibliPage blibliPage;

    //-------------- PREPARATION
    @Given("^\\[ui] blibli page is opened$")
    public void blibli_page_is_opened() {
        blibliPage.openHomePage();
    }

    @Given("^\\[ui] set keyword to '(.*)'$")
    public void set_keyword_to (String value) {
        BlibliPageData.setKeyword(value);
    }

    //-------------- ACTIONS
    @When("^\\[ui] search using keywords$")
    public void search_using_trending() {
        blibliPage.doSearch();
    }

    @When("^\\[ui] search using category$")
    public void search_using_category() throws InterruptedException {
        blibliPage.doNavigateToCategory();
    }

    //-------------- ASSERTIONS
    @Then("search result should containing keyword")
    public void search_result_should_containing_keyword() {
        List<String> list = blibliPage.getProductNameData();
        for (int i = 0; i <list.size(); i++) {
            assertThat(list.get(i).toLowerCase(), Matchers.containsString(BlibliPageData.getKeyword().toLowerCase()));
            System.out.println(list.get(i).toLowerCase());
        }
    }
}
