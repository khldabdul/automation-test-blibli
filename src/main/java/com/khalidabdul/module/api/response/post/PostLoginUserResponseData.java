package com.khalidabdul.module.api.response.post;

import lombok.Data;

@Data
public class PostLoginUserResponseData {
    private int id;
    private String username;
    private String firstName;
    private Boolean emailVerified;
}
