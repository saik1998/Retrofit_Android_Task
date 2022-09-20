package com.firstapp.retrofit_android_task;

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

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.Myholder> {
    Context context;
    List<DetailsModel2>detailsModel2List=new ArrayList<>();

    public JsonAdapter(Context context, List<DetailsModel2> detailsModel2List) {
        this.context = context;
        this.detailsModel2List = detailsModel2List;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_design,parent,false);

        return new Myholder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.nameText.setText(detailsModel2List.get(position).getDetails().getName());
        holder.titleText.setText(detailsModel2List.get(position).getTitle());
        holder.descriptionText.setText(detailsModel2List.get(position).getDescription());
        holder.publishedAtText.setText(detailsModel2List.get(position).getPublishedAt());

        Glide.with(context).load(detailsModel2List.get(position).getUrlToImage())
                .centerCrop().placeholder(R.mipmap.ic_launcher).into(holder.imageDisplay);
    }

    @Override
    public int getItemCount() {
        return detailsModel2List.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView nameText, titleText,descriptionText, publishedAtText;
        ImageView imageDisplay;
        public Myholder(@NonNull View itemView) {
            super(itemView);


            nameText = itemView.findViewById(R.id.name);
            titleText = itemView.findViewById(R.id.title);
            descriptionText = itemView.findViewById(R.id.desciption);

            publishedAtText = itemView.findViewById(R.id.publishedAt);

            imageDisplay = itemView.findViewById(R.id.image);

        }
    }
}
