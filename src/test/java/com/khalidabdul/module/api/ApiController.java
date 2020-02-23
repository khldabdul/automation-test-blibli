package com.khalidabdul.module.api;

import com.khalidabdul.module.api.data.ApiData;
import com.khalidabdul.module.api.request.post.LoginUserRequest;
import io.restassured.response.Response;

import java.util.List;

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
        String pageNameURL = "pageName="+ ApiData.getPageName()+"&";
        String displayTypeURL = "displayType="+ ApiData.getDisplayType();

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
        String searchTermPrefixURL = "searchTermPrefix="+ ApiData.getSearchTermPrefix();

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

    public static Response getSearchByProduct(int value) {
        String searchTermURL = "searchTerm="+ ApiData.getSearchTerm();

        Response response = given().
                header("Accept", "application/json").
                when().
                get("https://www.blibli.com/backend/search/products?" + searchTermURL);
        System.out.println(separator);
        System.out.println("SEARCH BY PRODUCT NUMBER " + value);
        System.out.println(separator);

        List<String> urlProduct = response.path("data.products.url");
        List<String> productName = response.jsonPath().getList("data.products.name");
        List<String> productPrice = response.path("data.products.price.priceDisplay");
        List<String> productStatus = response.path("data.products.status");

        value-= 1;

        System.out.println("Name: " + productName.get(value));
        System.out.println("Price: " + productPrice.get(value));
        System.out.println("Status: " + productStatus.get(value));

        ApiData.setUrlProduct(urlProduct.get(value));

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
        request.setUsername(ApiData.getUsername());
        request.setPassword(ApiData.getPassword());

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