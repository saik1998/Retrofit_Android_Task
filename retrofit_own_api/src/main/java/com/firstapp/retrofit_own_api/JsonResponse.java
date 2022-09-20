package com.firstapp.retrofit_own_api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {

    @SerializedName("temples")
    @Expose
    private List<TempleModel>templeModelList;

    public List<TempleModel> getTempleModelList() {
        return templeModelList;
    }

    public void setTempleModelList(List<TempleModel> templeModelList) {
        this.templeModelList = templeModelList;
    }

    public JsonResponse(List<TempleModel> templeModelList) {
        this.templeModelList = templeModelList;
    }
}
