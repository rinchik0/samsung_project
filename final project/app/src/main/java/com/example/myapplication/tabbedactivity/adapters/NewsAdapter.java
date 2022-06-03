package com.example.myapplication.tabbedactivity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.dataclasses.News;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, R.layout.adapter_item, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final News news = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

// Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.header)).setText(news.getHeader());
        ((TextView) convertView.findViewById(R.id.discription)).setText(String.valueOf(news.getDiscription()));
        ((TextView) convertView.findViewById(R.id.author)).setText(String.valueOf(news.getAuthor()));
        return convertView;
    }
}
