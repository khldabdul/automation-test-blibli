package com.khalidabdul.module.api.data;

import com.khalidabdul.module.api.response.get.searchbyproduct.GetSearchByProductResponse;
import io.restassured.response.Response;

public class ApiData {

    private static String username;
    private static String password;

    private static String pageName;
    private static String displayType;
    private static String searchTermPrefix;
    private static String searchTerm;

    private static String urlProduct;

    private static Response getPageResponse;
    private static Response postLoginResponse;

    private static GetSearchByProductResponse getSearchByProductResponse;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        if (username.equalsIgnoreCase("null")) {
            ApiData.username = null;
        }else {
            ApiData.username = username;
        }
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        if (password.equalsIgnoreCase("null")) {
            ApiData.password = null;
        }else {
            ApiData.password = password;
        }
    }

    public static String getPageName() {
        return pageName;
    }

    public static void setPageName(String pageName) {
        ApiData.pageName = pageName;
    }

    public static String getDisplayType() {
        return displayType;
    }

    public static void setDisplayType(String displayType) {
        ApiData.displayType = displayType;
    }

    public static String getSearchTermPrefix() {
        return searchTermPrefix;
    }

    public static void setSearchTermPrefix(String searchTermPrefix) {
        ApiData.searchTermPrefix = searchTermPrefix;
    }

    public static String getSearchTerm() {
        return searchTerm;
    }

    public static void setSearchTerm(String searchTerm) {
        ApiData.searchTerm = searchTerm;
    }


    public static String getUrlProduct() {
        return urlProduct;
    }

    public static void setUrlProduct(String urlProduct) {
        ApiData.urlProduct = urlProduct;
    }


    public static Response getGetPageResponse() {
        return getPageResponse;
    }

    public static void setGetPageResponse(Response getPageResponse) {
        ApiData.getPageResponse = getPageResponse;
    }

    public static Response getPostLoginResponse() {
        return postLoginResponse;
    }

    public static void setPostLoginResponse(Response postLoginResponse) {
        ApiData.postLoginResponse = postLoginResponse;
    }

    public static GetSearchByProductResponse getGetSearchByProductResponse() {
        return getSearchByProductResponse;
    }

    public static void setGetSearchByProductResponse(GetSearchByProductResponse getSearchByProductResponse) {
        ApiData.getSearchByProductResponse = getSearchByProductResponse;
    }

}
