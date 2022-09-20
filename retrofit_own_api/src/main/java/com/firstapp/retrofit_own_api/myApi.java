package com.firstapp.retrofit_own_api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myApi {

    //https://run.mocky.io/v3/c7bb8199-675b-4644-969c-876288f2627e
    //https://run.mocky.io/v3/   c7bb8199-675b-4644-969c-876288f2627e

    //https://run.mocky.io/v3/     21d6550f-5da4-499a-808c-d974a1460bcd

    //https://run.mocky.io/v3/ade567e0-569a-40f4-8010-d2c449a58522


    //https://run.mocky.io/v3/4640390a-ca07-4949-84fa-a03cd28fbe78

    @GET("4640390a-ca07-4949-84fa-a03cd28fbe78")
    Call<JsonResponse> getresponsedetails();
}


