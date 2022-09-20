package com.firstapp.retrofit_task_array;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
    ProgressDialog progressDialog;
    Retrofit retrofit;
    MoivezModel moivezModel;
    JsonAdapter jsonAdapter;
    MyApiCall myApiCall;

    List<MoivezModel> moivezModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.simple_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApiCall = retrofit.create(MyApiCall.class);

        jsonAdapter = new JsonAdapter(this, moivezModelList);
        recyclerView.setAdapter(jsonAdapter);

    //    jsonAdapter.notifyDataSetChanged();

        loadData();


    }

    private void loadData() {

        Call<JsonResponse> call=myApiCall.getResponseDetails();

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                progressDialog.dismiss();

                if (response.code()!=200)
                {
                    Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    List<MoivezModel> moivezModelList=response.body().getMoivezModelList();

                    // List<DetailsModel> detailsModelList=response.body().getMoivezModelList();

                    for (MoivezModel moivezModel2:moivezModelList)
                    {
                        String templename=moivezModel2.getTemplename();
                        String location=moivezModel2.getLocation();
                        String state=moivezModel2.getState();
                        String url=moivezModel2.getUrl();

                        DetailsModel details=new DetailsModel(moivezModel2.getDetailsModel().getDirector(),moivezModel2.getDetailsModel().getChairman());


//                        DetailsModel details=new DetailsModel(moivezModel.getDetailsModel().getName1(),moivezModel.getDetailsModel().getName2());

                        moivezModel=new MoivezModel(templename,location,state,url,details);
                        moivezModelList.add(moivezModel);
                        jsonAdapter.notifyDataSetChanged();




                    }
//

                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
    }



