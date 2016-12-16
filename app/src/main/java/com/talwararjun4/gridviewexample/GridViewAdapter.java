package com.talwararjun4.gridviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by artalwar on 12/16/2016.
 */

public class GridViewAdapter extends ArrayAdapter {

    List<ImagePOJO> data = null;
    int layoutResourceId;
    Context context = null;

    public GridViewAdapter(Context context, int layoutresourceId, List data){
        super(context,layoutresourceId,data);
        this.context = context;
        this.layoutResourceId = layoutresourceId;
        this.data = data;

    }


    static class ViewHolder{
        ImageView imageView ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View view = convertView;
        ViewHolder viewHolder = null;
        if(view == null){
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            view = layoutInflater.inflate(R.layout.grid_item_layout,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)view.findViewById(R.id.imgView);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)view.getTag();
        }

        ImagePOJO imagePOJO = data.get(position);
        viewHolder.imageView.setImageBitmap(imagePOJO.getImage());
        return view;


    }
}
