package com.khalidabdul.module.api.response.get.trendingsearch;

import lombok.Data;

@Data
public class GetTrendingSearchResponse {
    private int code;
    private String status;
    private String[] data;
}
