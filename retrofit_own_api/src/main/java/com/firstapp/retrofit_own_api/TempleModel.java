package com.firstapp.retrofit_own_api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TempleModel {
    String TempleName;
    String Location;

    String State;
    String url;

    @SerializedName("Details")
    @Expose
    private DetailsModel detailsModel;

    public String getTempleName() {
        return TempleName;
    }

    public void setTempleName(String templeName) {
        TempleName = templeName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DetailsModel getDetailsModel() {
        return detailsModel;
    }

    public void setDetailsModel(DetailsModel detailsModel) {
        this.detailsModel = detailsModel;
    }

    public TempleModel(String templeName, String location, String state, String url, DetailsModel detailsModel) {
        TempleName = templeName;
        Location = location;
        State = state;
        this.url = url;
        this.detailsModel = detailsModel;
    }
}
