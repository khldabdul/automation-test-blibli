package com.khalidabdul.module.api.response.get.searchbyproduct;

import lombok.Data;

@Data
public class ProductsData {
    private String id;
    private String sku;
    private String merchantCode;
    private String status;
    private String name;
    private PriceData price;
    private String url;
}
