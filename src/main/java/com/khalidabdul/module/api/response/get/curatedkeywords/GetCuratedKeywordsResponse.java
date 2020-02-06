package com.khalidabdul.module.api.response.get.curatedkeywords;

import lombok.Data;

@Data
public class GetCuratedKeywordsResponse {
    private int code;
    private String status;
    private GetCuratedKeywordsResponseData data;
}
