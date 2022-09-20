package com.firstapp.retrofit_task_array;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {

    @SerializedName("temples")
    @Expose
    private List<MoivezModel> moivezModelList;

    public List<MoivezModel> getMoivezModelList() {
        return moivezModelList;
    }

    public void setMoivezModelList(List<MoivezModel> moivezModelList) {
        this.moivezModelList = moivezModelList;
    }
}
