package com.khalidabdul.module.api.response.get.searchautocomplete.data;

import lombok.Data;

@Data
public class AnchorStore {
    private String term;
    private String label;
    private String url;
    private String imageUrl;
}
