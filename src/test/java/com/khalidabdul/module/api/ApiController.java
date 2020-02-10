package com.khalidabdul.module.api;

import com.khalidabdul.module.api.request.post.LoginUserRequest;
import com.khalidabdul.module.api.data.UsersData;
import com.khalidabdul.module.api.response.get.searchbyproduct.GetSearchByProductResponse;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.given;

public class ApiController {

    private static String separator = "=========================================";

    public static Response getTrendingSearch() {
        Response response = given().
                    header("Accept", "application/json").
                when().
                    get("https://www.blibli.com/backend/search/trending-search-terms");
        System.out.println(separator);
        System.out.println("TRENDING SEARCH");
        System.out.println(separator);
        response.getBody().prettyPrint();
        return response;
    }

    public static Response getCuratedKeywords() {
        Response response = given().
                    header("Accept", "application/json").
                when().
                    get("https://www.blibli.com/backend/search/curatedKeywords");
        System.out.println(separator);
        System.out.println("CURATED KEYWORDS");
        System.out.println(separator);
        response.getBody().prettyPrint();
        return response;
    }

    public static Response getBannerDisplay() {
        String pageNameURL = "pageName="+UsersData.getPageName()+"&";
        String displayTypeURL = "displayType="+UsersData.getDisplayType();

        Response response = given().
                    header("Accept", "application/json").
                when().
                    get("https://www.blibli.com/backend/common/banners?" + pageNameURL + displayTypeURL);
        System.out.println(separator);
        System.out.println("BANNER DISPLAY");
        System.out.println(separator);
        response.getBody().prettyPrint();
        return response;
    }

    public static Response getSearchAutocomplete() {
        String searchTermPrefixURL = "searchTermPrefix="+UsersData.getSearchTermPrefix();

        Response response = given().
                header("Accept", "application/json").
                when().
                get("https://www.blibli.com/backend/search/autocomplete?" + searchTermPrefixURL);
        System.out.println(separator);
        System.out.println("SEARCH AUTOCOMPLETE PREFIX");
        System.out.println(separator);
        response.getBody().prettyPrint();
        return response;
    }

    public static Response getSearchByProduct() {
        String searchTermURL = "searchTerm="+UsersData.getSearchTerm();

        Response response = given().
                header("Accept", "application/json").
                when().
                get("https://www.blibli.com/backend/search/products?" + searchTermURL);
        System.out.println(separator);
        System.out.println("SEARCH BY PRODUCT");
        System.out.println(separator);
        response.getBody().prettyPrint();
        return response;
    }

    public static GetSearchByProductResponse getSearchByProduct2() {
        String searchTermURL = "searchTerm="+UsersData.getSearchTerm();

        GetSearchByProductResponse response = SerenityRest.given()
                .header("Content-Type", "application/json")
                .get("https://www.blibli.com/backend/search/products?" + searchTermURL)
                .getBody().as(GetSearchByProductResponse.class);
        return response;
    }

    public static Response getPaymentsActive() {
        Response response = given().
                header("Accept", "application/json").
                when().
                get("https://www.blibli.com/backend/common/payments/_active/web");
        System.out.println(separator);
        System.out.println("PAYMENT ACTIVE");
        System.out.println(separator);
        response.getBody().prettyPrint();
        return response;
    }

    public static Response loginUser () {
        LoginUserRequest request = new LoginUserRequest();
        request.setUsername(UsersData.getUsername());
        request.setPassword(UsersData.getPassword());

        Response response = given().
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                body(request).
                when().
                post("https://www.blibli.com/backend/common/users/_login");

        System.out.println(separator);
        System.out.println("LOGIN USER");
        System.out.println(request);
        System.out.println(separator);
        response.getBody().prettyPrint();
        return  response;
    }
}