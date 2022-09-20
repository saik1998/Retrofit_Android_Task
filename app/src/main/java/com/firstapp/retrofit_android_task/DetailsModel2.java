package com.firstapp.retrofit_android_task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsModel2 {

    private String title;
    private String description;
    private String urlToImage;
    private String publishedAt;

    @SerializedName("source")
    @Expose
    private Details details;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public DetailsModel2(String title, String description, String urlToImage, String publishedAt, Details details) {
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.details = details;
    }
}
