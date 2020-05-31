package com.example.abanoub.topsportstories_MVP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Abanoub on 2018-01-31.
 */

public class StoriesAdapter extends BaseAdapter {

    Context context;
    ArrayList<Story> list;

    public StoriesAdapter(Context context, ArrayList<Story> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_single_item, null);
        }
        Story story=list.get(position);

        ((TextView)view.findViewById(R.id.title_textView)).setText(story.title);
        ((TextView)view.findViewById(R.id.description_textView)).setText(story.abstract_);

        Glide.with(context)
                .load(story.photo_url)
                .into((ImageView) view.findViewById(R.id.imageView));

        return view;
    }
}
