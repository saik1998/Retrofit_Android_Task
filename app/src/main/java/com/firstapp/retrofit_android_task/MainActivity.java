package com.firstapp.retrofit_android_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DetailsModel2 detailsModel2;
    JsonAdapter jsonAdapter;
    JsonResponse1 jsonResponse1;

    List<DetailsModel2> detailsModel2List = new ArrayList<>();
    Retrofit retrofit;
    MyApiCall myApiCall;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        retrofit = new Retrofit.Builder().baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApiCall =retrofit.create(MyApiCall.class);

        jsonAdapter = new JsonAdapter(this,detailsModel2List);
        recyclerView.setAdapter(jsonAdapter);

        loadData();

    }

    private void loadData() {


        Call<JsonResponse1> call = myApiCall.getResponseList();
        call.enqueue(new Callback<JsonResponse1>() {
            @Override
            public void onResponse(Call<JsonResponse1> call, Response<JsonResponse1> response) {
                progressDialog.dismiss();

                if (response.code() != 200) {
                    Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();
                } else {
                    List<DetailsModel2> articlesModelList1 = response.body().getDetailsModel2List();

                    for (DetailsModel2 detailsModel3 : articlesModelList1) {
                        String title1 = detailsModel3.getTitle();
                        String desc = detailsModel3.getDescription();
                        String publishAt1 = detailsModel3.getPublishedAt();
                        String image1 = detailsModel3.getUrlToImage();


                        Details details = new Details(detailsModel3.getDetails().getName());

                        detailsModel2 = new DetailsModel2(title1, desc, image1, publishAt1, details);
                        detailsModel2List.add(detailsModel2);
                        jsonAdapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponse1> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}








