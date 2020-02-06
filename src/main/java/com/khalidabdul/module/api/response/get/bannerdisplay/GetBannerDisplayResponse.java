package com.khalidabdul.module.api.response.get.bannerdisplay;

import lombok.Data;

@Data
public class GetBannerDisplayResponse {
    private int code;
    private String status;
    private GetBannerDisplayResponseData data;
}
