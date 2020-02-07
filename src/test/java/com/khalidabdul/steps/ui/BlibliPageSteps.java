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

    @When("^\\[ui] search using gaming audio category$")
    public void search_using_gaming_audio_category() {
        blibliPage.doNavigateToCategory();
        blibliPage.goToGamingAudio();
    }

    //-------------- ASSERTIONS
    @Then("^\\[ui] search result should containing keyword$")
    public void search_result_should_containing_keyword() {
        List<String> list = blibliPage.getProductNameData();
        for (int i = 0; i <list.size(); i++) {
            assertThat(list.get(i).toLowerCase(), Matchers.containsString(BlibliPageData.getKeyword().toLowerCase()));
//            System.out.println(list.get(i).toLowerCase());
        }
    }

    @Then("^\\[ui] category title equal with '(.*)'$")
    public void category_title_equal_with(String text) {
        String title = blibliPage.getCategoryTitle().toLowerCase();
//        String[] arrOfTitle = title.split("[, &]+");
        String[] arrOfText = text.split("[, &]+");

        for (String b : arrOfText) assertThat(title, Matchers.containsString(b));

//        System.out.println(title);
//        System.out.println(text);
    }
}
