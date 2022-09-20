package com.firstapp.retrofit_task_array;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

//    https://run.mocky.io/v3/0ca0a682-b3e0-421e-9c34-f8834e5a04ce


    @GET("0ca0a682-b3e0-421e-9c34-f8834e5a04ce")
    Call <JsonResponse> getResponseDetails();
}
