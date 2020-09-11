package com.example.top20;

import com.google.gson.annotations.SerializedName;

public class FormPost {
    @SerializedName("First Name")
    private String fname;
    @SerializedName("Last Name")
    private String lname;
    @SerializedName("Email Address")
    private String email;
    @SerializedName("Link your project on GitHub")
    private String github;
    private String Track;

    public FormPost(String fname, String lname, String email, String track, String github) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.github = github;
        this.Track = track;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public void setTrack(String track) {
        Track = track;
    }

    public String getTrack() {
        return Track;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getGithub() {
        return github;
    }
}
