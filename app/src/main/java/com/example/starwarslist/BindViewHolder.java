package com.example.starwarslist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BindViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView height;
    public TextView gender;
    public BindViewHolder(@NonNull View v) {
        super(v);

        this.name   = v.findViewById(R.id.name);
        this.height = v.findViewById(R.id.height);
        this.gender = v.findViewById(R.id.gender);
    }
}
