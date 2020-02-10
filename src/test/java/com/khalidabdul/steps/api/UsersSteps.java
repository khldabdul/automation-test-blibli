package com.khalidabdul.steps.api;

import com.khalidabdul.module.api.ApiController;
import com.khalidabdul.module.api.data.UsersData;
import com.khalidabdul.module.api.response.get.bannerdisplay.GetBannerDisplayResponse;
import com.khalidabdul.module.api.response.get.searchautocomplete.data.AnchorStore;
import com.khalidabdul.module.api.response.get.searchbyproduct.GetSearchByProductResponse;
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
        UsersData.setUsername(value);
    }

    @Given("^\\[api] set password to '(.*)'$")
    public void set_password_to (String value) {
        UsersData.setPassword(value);
    }

    @Given("^\\[api] set page name to '(.*)'$")
    public void set_page_name_to (String value) {
        UsersData.setPageName(value);
    }

    @Given("^\\[api] set display type to '(.*)'$")
    public void set_display_type_to (String value) {
        UsersData.setDisplayType(value);
    }

    @Given("^\\[api] set search term prefix to '(.*)'$")
    public void set_search_term_prefix_to (String value) {
        UsersData.setSearchTermPrefix(value);
    }

    @Given("^\\[api] set search term to '(.*)'$")
    public void set_search_term_to (String value) {
        UsersData.setSearchTerm(value);
    }

    //---------------------------- Send Request
    @When("^\\[api] send post login user request$")
    public void send_post_login_user_request () {
        UsersData.setPostLoginResponse(ApiController.loginUser());
    }

    @When("^\\[api] send get trending search request$")
    public void send_get_trending_search_request () {
        UsersData.setGetPageResponse(ApiController.getTrendingSearch());
    }

    @When("^\\[api] send get curated keywords request$")
    public void send_get_curated_keywords_request () {
        UsersData.setGetPageResponse(ApiController.getCuratedKeywords());
    }

    @When("^\\[api] send get banner display request$")
    public void send_get_banner_display_request () {
        UsersData.setGetPageResponse(ApiController.getBannerDisplay());
    }

    @When("^\\[api] send get search autocomplete prefix request$")
    public void send_get_search_autocomplete_prefix_request () {
        UsersData.setGetPageResponse(ApiController.getSearchAutocomplete());
    }

    @When("^\\[api] send get search by product request$")
    public void send_get_search_by_product_request () {
        UsersData.setGetPageResponse(ApiController.getSearchByProduct());
    }

    @When("^\\[api] send get search by product request2$")
    public void send_get_search_by_product_request2 () {
        GetSearchByProductResponse response = ApiController.getSearchByProduct2();
        System.out.println(response);
    }

    @When("^\\[api] send get payments active request$")
    public void send_get_payments_active_request () {
        UsersData.setGetPageResponse(ApiController.getPaymentsActive());
    }

    //---------------------------- Check Status Code
    @Then("^\\[api] get status code must be '(\\d+)'$")
    public void api_get_status_code_must_be (int code) {
        //HAMCREST
        // Assert the status code from the Response to be equal to input code
        assertThat(UsersData.getGetPageResponse().statusCode(), equalTo(code));

        //REST-ASSURED
        // Assert status code directly from the Response method
        UsersData.getGetPageResponse().
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
        assertThat(UsersData.getPostLoginResponse().statusCode(), equalTo(code));
    }

    @Then("^\\[api] assert with rest assured that login user status code must be '(\\d+)'$")
    public void assert_with_rest_assured_that_login_user_status_code_must_be (int code) {
        UsersData.getPostLoginResponse().
                then().
                statusCode(code);
    }

    //---------------------------- Assert Response
    @Then("^\\[api] post login user response equals with request$")
    public void api_post_login_user_response_equals_with_request () {
        //HAMCREST assert
        PostLoginUserResponse response = UsersData.getPostLoginResponse().
                getBody().as(PostLoginUserResponse.class);
        assertThat(response.getData().getUsername(), equalTo(UsersData.getUsername()));

        //REST-ASSURED assert
        UsersData.getPostLoginResponse().
                then().
                    body("data.username", equalTo(UsersData.getUsername()));
    }

    @Then("^\\[api] get banner display response equals with request$")
    public void api_get_banner_display_response_equals_with_request () {
        GetBannerDisplayResponse response = UsersData.getGetPageResponse().getBody().as(GetBannerDisplayResponse.class);
        assertThat(response.getData().getDisplayType(), equalTo(UsersData.getDisplayType()));

        UsersData.getGetPageResponse().
                then().
                    body("data.displayType", equalTo(UsersData.getDisplayType()));
    }

    List<AnchorStore> autoCompleteData;

    @Then("^\\[api] get search autocomplete prefix response equals with request$")
    public List<String> api_get_search_autocomplete_prefix_response_equals_with_request () {
//        List<GetSearchAutocompletePrefixResponse> response = UsersData.getGetPageResponse().getBody().as(GetSearchAutocompletePrefixResponse.class);
        List<String> listStore = new ArrayList<>();
        for (int i = 0; i < autoCompleteData.size(); i++) {
            listStore.add(autoCompleteData.get(i).getTerm());
            assertThat(autoCompleteData.get(i).getTerm(), containsString(UsersData.getSearchTermPrefix()));
        }return listStore;
    }

    @Then("^\\[api] get search by product response equals with request$")
    public void api_get_search_by_product_response_equals_with_request () {

    }

}