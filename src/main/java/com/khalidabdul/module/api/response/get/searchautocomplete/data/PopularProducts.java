package com.khalidabdul.module.api.response.get.searchautocomplete.data;

import lombok.Data;

@Data
public class PopularProducts {
    private String term;
    private String label;
    private String url;
    private String imageUrl;
    private String priceDisplay;
    private String addToCart;
    private String itemSku;
}
