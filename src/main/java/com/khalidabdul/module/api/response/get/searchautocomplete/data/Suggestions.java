package com.khalidabdul.module.api.response.get.searchautocomplete.data;

import lombok.Data;

@Data
public class Suggestions {
    private String term;
    private String label;
    private String url;
}
