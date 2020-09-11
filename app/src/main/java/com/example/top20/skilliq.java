package com.example.top20;

public class skilliq {

    private String name;
    private int score;
    private String badgeUrl;
    private String country;

    skilliq(String mname ,int mscore ,String mcountry , String mbadgeUrl ){
        this.name = mname;
        this.score=mscore;
        this.country=mcountry;
        this.badgeUrl= mbadgeUrl;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public String getCountry() {
        return country;
    }
}
