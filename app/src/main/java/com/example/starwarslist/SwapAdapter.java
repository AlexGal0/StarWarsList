package com.example.starwarslist;

import android.app.PendingIntent;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.People;

public class SwapAdapter extends RecyclerView.Adapter {

    private ArrayList<People> list;

    public SwapAdapter(ArrayList<People> list){
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.custom_layout, parent, false);

        BindViewHolder holder = new BindViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder h, int i) {

        BindViewHolder holder = (BindViewHolder) h;
        People p = list.get(i);

        holder.name.setText(p.getName());
        holder.height.setText(p.getHeight() + "");
        holder.gender.setText(p.getGender());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
