package com.firstapp.retrofit_own_api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.MyHolder> {
    Context context;
    List<TempleModel> templeModelList=new ArrayList<>();

    public JsonAdapter(Context context, List<TempleModel> templeModelList) {
        this.context = context;
        this.templeModelList = templeModelList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);

        return new MyHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int i) {
        holder.templename.setText(""+templeModelList.get(i).getTempleName());
        holder.location.setText(""+templeModelList.get(i).getLocation());
        holder.state.setText(""+templeModelList.get(i).getState());
        holder.director.setText(""+templeModelList.get(i).getDetailsModel().getDirector());
        holder.chairman.setText(""+templeModelList.get(i).getDetailsModel().getChairman());

        Glide.with(context).load(templeModelList.get(i).getUrl()).centerCrop().placeholder(R.mipmap.ic_launcher).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return templeModelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView templename,location,state,director,chairman;
        ImageView imageView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            templename=itemView.findViewById(R.id.templename);
            location=itemView.findViewById(R.id.location);
            state=itemView.findViewById(R.id.state);
            director=itemView.findViewById(R.id.director);
            chairman=itemView.findViewById(R.id.chairman);
            imageView=itemView.findViewById(R.id.imaeview1);

        }
    }
}
