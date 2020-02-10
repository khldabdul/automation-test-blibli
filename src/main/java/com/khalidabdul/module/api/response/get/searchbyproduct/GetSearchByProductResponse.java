package com.khalidabdul.module.api.response.get.searchbyproduct;

import lombok.Data;

@Data
public class GetSearchByProductResponse {
    private int code;
    private String status;
    private GetSearchByProductResponseData data;
}
