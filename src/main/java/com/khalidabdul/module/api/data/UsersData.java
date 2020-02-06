package com.khalidabdul.module.api.data;

import io.restassured.response.Response;

public class UsersData {
//    private static Integer id;
//    private static String name;
//    private static String job;

    private static String username;
    private static String password;

    private static String pageName;
    private static String displayType;
    private static String searchTermPrefix;
    private static String searchTerm;

    private static Response getPageResponse;
    private static Response postLoginResponse;

//    private static Response getSingleUserResponse;
//    private static Response createUserResponse;
//    private static Response updateUserResponse;
//    private static Response deleteUserResponse;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UsersData.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UsersData.password = password;
    }

    public static String getPageName() {
        return pageName;
    }

    public static void setPageName(String pageName) {
        UsersData.pageName = pageName;
    }

    public static String getDisplayType() {
        return displayType;
    }

    public static void setDisplayType(String displayType) {
        UsersData.displayType = displayType;
    }

    public static String getSearchTermPrefix() {
        return searchTermPrefix;
    }

    public static void setSearchTermPrefix(String searchTermPrefix) {
        UsersData.searchTermPrefix = searchTermPrefix;
    }

    public static String getSearchTerm() {
        return searchTerm;
    }

    public static void setSearchTerm(String searchTerm) {
        UsersData.searchTerm = searchTerm;
    }
//    public static Integer getId() {
//        return id;
//    }
//
//    public static void setId(Integer id) {
//        UsersData.id = id;
//    }
//
//    public static String getName() {
//        return name;
//    }
//
//    public static void setName(String name) {
//        UsersData.name = name;
//    }
//
//    public static String getJob() {
//        return job;
//    }
//
//    public static void setJob(String job) {
//        UsersData.job = job;
//    }

    public static Response getGetPageResponse() {
        return getPageResponse;
    }

    public static void setGetPageResponse(Response getPageResponse) {
        UsersData.getPageResponse = getPageResponse;
    }

    public static Response getPostLoginResponse() {
        return postLoginResponse;
    }

    public static void setPostLoginResponse(Response postLoginResponse) {
        UsersData.postLoginResponse = postLoginResponse;
    }

//    public static Response getGetSingleUserResponse() {
//        return getSingleUserResponse;
//    }
//
//    public static void setGetSingleUserResponse(Response getSingleUserResponse) {
//        UsersData.getSingleUserResponse = getSingleUserResponse;
//    }
//
//    public static Response getCreateUserResponse() {
//        return createUserResponse;
//    }
//
//    public static void setCreateUserResponse(Response createUserResponse) {
//        UsersData.createUserResponse = createUserResponse;
//    }
//
//    public static Response getUpdateUserResponse() {
//        return updateUserResponse;
//    }
//
//    public static void setUpdateUserResponse(Response updateUserResponse) {
//        UsersData.updateUserResponse = updateUserResponse;
//    }
//
//    public static Response getDeleteUserResponse() {
//        return deleteUserResponse;
//    }
//
//    public static void setDeleteUserResponse(Response deleteUserResponse) {
//        UsersData.deleteUserResponse = deleteUserResponse;
//    }
}
