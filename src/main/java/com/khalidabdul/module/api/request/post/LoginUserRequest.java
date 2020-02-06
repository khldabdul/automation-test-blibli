package com.khalidabdul.module.api.request.post;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String username;
    private String password;
}
