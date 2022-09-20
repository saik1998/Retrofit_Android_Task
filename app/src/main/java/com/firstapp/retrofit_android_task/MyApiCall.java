package com.firstapp.retrofit_android_task;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

//   //https://run.mocky.io/v3/bec4c8df-0bec-437a-89e6-a7ee65c53e0d
//    @GET("bec4c8df-0bec-437a-89e6-a7ee65c53e0d")
//    Call<JsonResponse> getApiList();


    //https://run.mocky.io/v3/bec4c8df-0bec-437a-89e6-a7ee65c53e0d
    @GET("bec4c8df-0bec-437a-89e6-a7ee65c53e0d")
    Call<JsonResponse1> getResponseList();

}
