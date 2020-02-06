package com.khalidabdul.module.api.response.get.searchautocomplete;

import com.khalidabdul.module.api.response.get.searchautocomplete.data.AnchorStore;
import com.khalidabdul.module.api.response.get.searchautocomplete.data.AnchorStoreData;
import com.khalidabdul.module.api.response.get.searchautocomplete.data.PopularProducts;
import com.khalidabdul.module.api.response.get.searchautocomplete.data.Suggestions;
import lombok.Data;

import java.util.List;

@Data
public class GetSearchAutocompletePrefixResponseData {
    private AnchorStoreData anchorStoreData;
    private List<AnchorStore> anchorStore;
    private List<Suggestions> suggestions;
    private List<PopularProducts> popularProducts;
}
