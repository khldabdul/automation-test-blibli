package com.khalidabdul.module.api.response.get;

import lombok.Data;

@Data
public class GetSingleUserResponseData {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
