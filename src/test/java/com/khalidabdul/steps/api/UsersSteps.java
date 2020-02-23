package com.khalidabdul.steps.api;

import com.khalidabdul.module.api.ApiController;
import com.khalidabdul.module.api.data.ApiData;
import com.khalidabdul.module.api.response.get.bannerdisplay.GetBannerDisplayResponse;
import com.khalidabdul.module.api.response.get.searchautocomplete.data.AnchorStore;
import com.khalidabdul.module.api.response.post.PostLoginUserResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class UsersSteps extends ScenarioSteps {

    //---------------------------- Set Parameters
    @Given("^\\[api] set username to '(.*)'$")
    public void api_set_username_to (String value) {
        ApiData.setUsername(value);
    }

    @Given("^\\[api] set password to '(.*)'$")
    public void set_password_to (String value) {
        ApiData.setPassword(value);
    }

    @Given("^\\[api] set page name to '(.*)'$")
    public void set_page_name_to (String value) {
        ApiData.setPageName(value);
    }

    @Given("^\\[api] set display type to '(.*)'$")
    public void set_display_type_to (String value) {
        ApiData.setDisplayType(value);
    }

    @Given("^\\[api] set search term prefix to '(.*)'$")
    public void set_search_term_prefix_to (String value) {
        ApiData.setSearchTermPrefix(value);
    }

    @Given("^\\[api] set search term to '(.*)'$")
    public void set_search_term_to (String value) {
        ApiData.setSearchTerm(value);
    }

    //---------------------------- Send Request
    @When("^\\[api] send post login user request$")
    public void send_post_login_user_request () {
        ApiData.setPostLoginResponse(ApiController.loginUser());
    }

    @When("^\\[api] send get trending search request$")
    public void send_get_trending_search_request () {
        ApiData.setGetPageResponse(ApiController.getTrendingSearch());
    }

    @When("^\\[api] send get curated keywords request$")
    public void send_get_curated_keywords_request () {
        ApiData.setGetPageResponse(ApiController.getCuratedKeywords());
    }

    @When("^\\[api] send get banner display request$")
    public void send_get_banner_display_request () {
        ApiData.setGetPageResponse(ApiController.getBannerDisplay());
    }

    @When("^\\[api] send get search autocomplete prefix request$")
    public void send_get_search_autocomplete_prefix_request () {
        ApiData.setGetPageResponse(ApiController.getSearchAutocomplete());
    }

    @When("^\\[api] send get search by product no '(\\d+)' request$")
    public void send_get_search_by_product_request (int value) {
        ApiData.setGetPageResponse(ApiController.getSearchByProduct(value));
    }

    @When("^\\[api] send get payments active request$")
    public void send_get_payments_active_request () {
        ApiData.setGetPageResponse(ApiController.getPaymentsActive());
    }

    //---------------------------- Check Status Code
    @Then("^\\[api] get status code must be '(\\d+)'$")
    public void api_get_status_code_must_be (int code) {
        //HAMCREST
        // Assert the status code from the Response to be equal to input code
        assertThat(ApiData.getGetPageResponse().statusCode(), equalTo(code));

        //REST-ASSURED
        // Assert status code directly from the Response method
        ApiData.getGetPageResponse().
                then().
                    statusCode(code);
    }

    @Then("^\\[api] login user status code must be '(\\d+)'$")
    public void api_login_user_status_code_must_be (int code) {
        //HAMCREST method call
        assert_with_hamcrest_that_login_user_status_code_must_be(code);

        //REST-ASSURED method call
        assert_with_rest_assured_that_login_user_status_code_must_be(code);
    }

    @Then("^\\[api] assert with hamcrest that login user status code must be '(\\d+)'$")
    public void assert_with_hamcrest_that_login_user_status_code_must_be (int code) {
        assertThat(ApiData.getPostLoginResponse().statusCode(), equalTo(code));
    }

    @Then("^\\[api] assert with rest assured that login user status code must be '(\\d+)'$")
    public void assert_with_rest_assured_that_login_user_status_code_must_be (int code) {
        ApiData.getPostLoginResponse().
                then().
                statusCode(code);
    }

    //---------------------------- Assert Response
    @Then("^\\[api] post login user response equals with request$")
    public void api_post_login_user_response_equals_with_request () {
        //HAMCREST assert
        PostLoginUserResponse response = ApiData.getPostLoginResponse().
                getBody().as(PostLoginUserResponse.class);
        assertThat(response.getData().getUsername(), equalTo(ApiData.getUsername()));

        //REST-ASSURED assert
        ApiData.getPostLoginResponse().
                then().
                    body("data.username", equalTo(ApiData.getUsername()));
    }

    @Then("^\\[api] get banner display response equals with request$")
    public void api_get_banner_display_response_equals_with_request () {
        GetBannerDisplayResponse response = ApiData.getGetPageResponse().getBody().as(GetBannerDisplayResponse.class);
        assertThat(response.getData().getDisplayType(), equalTo(ApiData.getDisplayType()));

        ApiData.getGetPageResponse().
                then().
                    body("data.displayType", equalTo(ApiData.getDisplayType()));
    }

    List<AnchorStore> autoCompleteData;

    @Then("^\\[api] get search autocomplete prefix response equals with request$")
    public List<String> api_get_search_autocomplete_prefix_response_equals_with_request () {
//        List<GetSearchAutocompletePrefixResponse> response = ApiData.getGetPageResponse().getBody().as(GetSearchAutocompletePrefixResponse.class);
        List<String> listStore = new ArrayList<>();
        for (int i = 0; i < autoCompleteData.size(); i++) {
            listStore.add(autoCompleteData.get(i).getTerm());
            assertThat(autoCompleteData.get(i).getTerm(), containsString(ApiData.getSearchTermPrefix()));
        }return listStore;
    }

    @Then("^\\[api] get search by product response equals with request$")
    public void api_get_search_by_product_response_equals_with_request () {

    }

}