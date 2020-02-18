package com.khalidabdul.module.ui.data;

public class BlibliPageData {
    private static String keyword;
    private static String email;
    private static String password;

    public static String getKeyword() {
        return keyword;
    }

    public static void setKeyword(String keyword) {
        BlibliPageData.keyword = keyword;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        BlibliPageData.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        BlibliPageData.password = password;
    }
}
