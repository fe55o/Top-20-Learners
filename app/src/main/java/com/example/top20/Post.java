package com.example.top20;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String name;
    private int hours;
    private String badgeUrl;
    private String country;

    Post(String mname ,int mhours ,String mcountry , String mbadgeUrl ){
        this.name = mname;
        this.hours=mhours;
        this.country=mcountry;
        this.badgeUrl= mbadgeUrl;
    }
    public String getName() {
        return this.name;
    }

    public int getHours() {
        return this.hours;
    }

    public String getBadgeUrl() {
        return this.badgeUrl;
    }

    public String getCountry() {
        return this.country;
    }
}
