package com.lasalle.mdpa.lgarci.propertycross.activity.main.fragment.search.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lasalle.mdpa.lgarci.propertycross.R;

/**
 * Created by FurruPi on 2/4/17.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    public RecyclerView recyclerView;

    public RecyclerViewHolder(View view){
        super(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_image_fragment_search);
        //imageView = (ImageView) view.findViewById(R.id.imageView);
    }

    //public void setImageView(Bitmap imageBitmap){
    //    imageView.setImageBitmap(imageBitmap);
    //}
}
