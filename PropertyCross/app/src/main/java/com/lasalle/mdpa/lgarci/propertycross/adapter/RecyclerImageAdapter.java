package com.lasalle.mdpa.lgarci.propertycross.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lasalle.mdpa.lgarci.propertycross.R;

/**
 * Created by FurruPi on 2/4/17.
 */

public class RecyclerImageAdapter extends RecyclerView.Adapter<RecyclerImageHolder> {

    @Override
    public RecyclerImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());
        ViewGroup current = (ViewGroup) mLayoutInflater.inflate(R.layout.recycler_item_image, parent, false);
        RecyclerImageHolder recyclerImageHolder = new RecyclerImageHolder(current);
        return recyclerImageHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerImageHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
