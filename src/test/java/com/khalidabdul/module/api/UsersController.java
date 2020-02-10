package com.khalidabdul.module.api;

import com.khalidabdul.module.api.request.post.LoginUserRequest;
import com.khalidabdul.module.api.data.UsersData;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class UsersController {

    public static Response getTrendingSearch() {
        return given().
                    header("Accept", "application/json").
                when().
                    get("https://www.blibli.com/backend/search/trending-search-terms");
    }

    public static Response getCuratedKeywords() {
        return given().
                    header("Accept", "application/json").
                when().
                    get("https://www.blibli.com/backend/search/curatedKeywords");
    }

    public static Response getBannerDisplay() {
        String pageNameURL = "pageName="+UsersData.getPageName()+"&";
        String displayTypeURL = "displayType="+UsersData.getDisplayType();

        return given().
                    header("Accept", "application/json").
                when().
                    get("https://www.blibli.com/backend/common/banners?" + pageNameURL + displayTypeURL);
    }

    public static Response getSearchAutocomplete() {
        String searchTermPrefixURL = "searchTermPrefix="+UsersData.getSearchTermPrefix();

        return given().
                header("Accept", "application/json").
                when().
                get("https://www.blibli.com/backend/search/autocomplete?" + searchTermPrefixURL);
    }

    public static Response getSearchByProduct() {
        String searchTermURL = "searchTerm="+UsersData.getSearchTerm();

        return given().
                header("Accept", "application/json").
                when().
                get("https://www.blibli.com/backend/search/products?" + searchTermURL);
    }

    public static Response getPaymentsActive() {
        return given().
                header("Accept", "application/json").
                when().
                get("https://www.blibli.com/backend/common/payments/_active/web");
    }

    public static Response loginUser () {
        LoginUserRequest request = new LoginUserRequest();
        request.setUsername(UsersData.getUsername());
        request.setPassword(UsersData.getPassword());

        System.out.println(request);

        Response response = given().
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                body(request).
                when().
                post("https://www.blibli.com/backend/common/users/_login");
        System.out.println("=============================");
        response.getBody().prettyPrint();
        return  response;
    }
}