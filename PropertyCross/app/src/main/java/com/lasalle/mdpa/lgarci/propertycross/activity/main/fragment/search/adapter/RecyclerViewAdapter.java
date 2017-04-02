package com.lasalle.mdpa.lgarci.propertycross.activity.main.fragment.search.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lasalle.mdpa.lgarci.propertycross.R;
import com.lasalle.mdpa.lgarci.propertycross.adapter.RecyclerImageAdapter;

/**
 * Created by FurruPi on 2/4/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    Context context;

    public RecyclerViewAdapter(Context context){
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());
        ViewGroup current = (ViewGroup) mLayoutInflater.inflate(R.layout.cardview_recycler_search, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(current);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(new RecyclerImageAdapter());
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
