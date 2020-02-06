package com.khalidabdul.module.api.response.get.searchautocomplete;

import lombok.Data;

import java.util.List;

@Data
public class GetSearchAutocompletePrefixResponse {
    private int code;
    private String status;
    private List<GetSearchAutocompletePrefixResponseData> data;

}
