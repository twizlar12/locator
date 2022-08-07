package com.example.locator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Restaurant {

    @JsonProperty("place_name")
    private String placeName;

    @JsonProperty("place_name")
    public String getPlaceName() {
        return placeName;
    }

    @JsonProperty("place_name")
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
