package com.firstapp.retrofit_android_task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.GET;

public class JsonResponse1 {
    @SerializedName("articles")
    List<DetailsModel2> detailsModel2List;


    public void setDetailsModel2List(List<DetailsModel2> detailsModel2List) {
        this.detailsModel2List = detailsModel2List;
    }

    public List<DetailsModel2> getDetailsModel2List() {
        return detailsModel2List;
    }
}
