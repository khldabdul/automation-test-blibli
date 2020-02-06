package com.khalidabdul.module.api.response.post;

import lombok.Data;

@Data
public class PostLoginUserResponse {
    private int code;
    private String status;
    private PostLoginUserResponseData data;
    private String errors;
}
