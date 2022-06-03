package com.example.myapplication.tabbedactivity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.dataclasses.DoneTask;

import java.util.ArrayList;

public class DoneTasksAdapter extends ArrayAdapter<DoneTask> {

    public DoneTasksAdapter(Context context, ArrayList<DoneTask> doneTasks) {
        super(context, R.layout.adapter_item_2, doneTasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final DoneTask done = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item_2, null);
        }

// Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.address_done)).setText(done.getAddress());
        ((TextView) convertView.findViewById(R.id.disc_done)).setText(done.getDiscriprion());
        ((TextView) convertView.findViewById(R.id.author_done)).setText(done.getAuthor());
        ((TextView) convertView.findViewById(R.id.price_done)).setText(String.valueOf(done.getPrice()));
        ((TextView) convertView.findViewById(R.id.user_done)).setText(String.valueOf(done.getUserName()));

        return convertView;
    }
}
