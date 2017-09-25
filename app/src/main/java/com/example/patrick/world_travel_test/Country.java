package com.example.patrick.world_travel_test;

/**
 * Created by Patrick on 23.09.2017.
 */

public class Country {

    private String imgURL;
    private String countryName;
    private String continent;

    public Country( String imgURL, String countryName, String continent) {
        this.countryName = countryName;
        this.continent = continent;
        this.imgURL = imgURL;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }


    public String getCountryName() {
        return countryName;
    }

    public String getContinent() {
        return continent;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
