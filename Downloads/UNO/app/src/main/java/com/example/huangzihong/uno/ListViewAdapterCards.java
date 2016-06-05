package com.example.huangzihong.uno;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by huangzihong on 16/6/4.
 */

public class ListViewAdapterCards extends ArrayAdapter<Card> {

    private int resourceId;

    public ListViewAdapterCards(Context context, int textViewResourceId, List<Card> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Card card = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.cardImage = (ImageView) view.findViewById(R.id.imageView_list_item);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.cardImage.setImageResource(card.getImageId());
        return view;
    }

    class ViewHolder{
        ImageView cardImage;
    }
}