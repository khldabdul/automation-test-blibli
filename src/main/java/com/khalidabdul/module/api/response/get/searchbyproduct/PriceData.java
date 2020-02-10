package com.khalidabdul.module.api.response.get.searchbyproduct;

import lombok.Data;

@Data
public class PriceData {
    private String priceDisplay;
    private String strikeThroughPriceDisplay;
    private int discount;
    private String offerPriceDisplay;
}
