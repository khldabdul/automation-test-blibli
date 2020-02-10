package com.khalidabdul.module.api.response.get.searchbyproduct;

import lombok.Data;

@Data
public class GetSearchByProductResponseData {
    private String searchTerm;
    private ProductsData[] products;
    private String code;
}
