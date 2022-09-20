package com.firstapp.retrofit_own_api;

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
    TempleModel templeModel;
    JsonAdapter jsonAdapter;
    List<TempleModel> templeModelList = new ArrayList<>();

    Retrofit retrofit;
    myApi myApi12;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.mainRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    progressDialog =new ProgressDialog(this);
        progressDialog.setCancelable(false);

    retrofit = new Retrofit.Builder().baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
            .build();

    myApi12 = retrofit.create(myApi.class);
    jsonAdapter = new JsonAdapter(this,templeModelList);
        recyclerView.setAdapter(jsonAdapter);

    loadData();



}

    private void loadData() {

        Call<JsonResponse> call = myApi12.getresponsedetails();
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                progressDialog.dismiss();

                if(response.code()!=200)
                {
                    Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    List<TempleModel> templeModelList1=response.body().getTempleModelList();

                    for(TempleModel templeModel22:templeModelList1)
                    {
                        String templename1=templeModel22.getTempleName();
                        String location1=templeModel22.getLocation();
                        String state1=templeModel22.getState();

                        String url1=templeModel22.getUrl();
                        DetailsModel detailsModel = new DetailsModel(templeModel22.getDetailsModel().getDirector(),templeModel22.getDetailsModel().getChairman());

                        templeModel = new TempleModel(templename1,location1,state1,url1,detailsModel);
                        templeModelList.add(templeModel);
                        jsonAdapter.notifyDataSetChanged();

                    }
                }

            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                progressDialog.dismiss();

            }
        });

    }
}