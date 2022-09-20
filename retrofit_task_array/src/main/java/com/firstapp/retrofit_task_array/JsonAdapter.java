package com.firstapp.retrofit_task_array;

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

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.ViewHolder> {
    Context context;
    List<MoivezModel> moivezModelList=new ArrayList<>();

    public JsonAdapter(Context context, List<MoivezModel> moivezModelList) {
        this.context = context;
        this.moivezModelList = moivezModelList;
    }

    @NonNull
    @Override
    public JsonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);

        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonAdapter.ViewHolder holder, int i) {
        holder.templename.setText(""+moivezModelList.get(i).getTemplename());
        holder.location.setText(""+moivezModelList.get(i).getLocation());
        holder.state.setText(""+moivezModelList.get(i).getState());
        holder.director.setText(""+moivezModelList.get(i).getDetailsModel().getDirector());
        holder.chairman.setText(""+moivezModelList.get(i).getDetailsModel().getChairman());

        Glide.with(context).load(moivezModelList.get(i).getUrl()).centerCrop().
                placeholder(R.drawable.ic_launcher_background).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return moivezModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView templename,location,state,director,chairman;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            templename=itemView.findViewById(R.id.templename);
            location=itemView.findViewById(R.id.location);
            state=itemView.findViewById(R.id.state);
            director=itemView.findViewById(R.id.director);
            chairman=itemView.findViewById(R.id.chairman);

            imageView=itemView.findViewById(R.id.frameimg);



        }
    }
}
