package com.firstapp.retrofit_task_array;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoivezModel {
    private String templename;
    private String location;
    private String state;
    private String url;
    @SerializedName("Details")
    @Expose
    private DetailsModel detailsModel;

    public MoivezModel(String templename, String location, String state, String url, DetailsModel detailsModel) {
        this.templename = templename;
        this.location = location;
        this.state = state;
        this.url = url;
        this.detailsModel = detailsModel;
    }

    public String getTemplename() {
        return templename;
    }

    public void setTemplename(String templename) {
        this.templename = templename;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}