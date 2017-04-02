package com.lasalle.mdpa.lgarci.propertycross.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by FurruPi on 2/4/17.
 */

public class RecyclerImageHolder extends RecyclerView.ViewHolder{

    public ImageView imageView;

    public RecyclerImageHolder(View view){
        super(view);
        //imageView = (ImageView) view.findViewById(R.id.imageView);
    }

    public void setImageView(Bitmap imageBitmap){
        imageView.setImageBitmap(imageBitmap);
    }
}
