package com.example.cordlia.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class EltHolder extends RecyclerView.ViewHolder {

    public TextView name;


    public EltHolder(View v) {
        super(v);
        name = (TextView)itemView.findViewById(R.id.my_recycler_view_elt1);
    }

}