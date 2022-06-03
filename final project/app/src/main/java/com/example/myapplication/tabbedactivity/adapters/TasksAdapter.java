package com.example.myapplication.tabbedactivity.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.dataclasses.Task;

import java.util.ArrayList;

public class TasksAdapter extends ArrayAdapter<Task> {

    public TasksAdapter(Context context, ArrayList<Task> tasks) {
        super(context, R.layout.adapter_item_1, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Task task = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item_1, null);
        }

// Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.address)).setText(task.getAddress());
        ((TextView) convertView.findViewById(R.id.discriptionT)).setText(task.getDiscriprion());
        ((TextView) convertView.findViewById(R.id.authorT)).setText(task.getAuthor());
        ((TextView) convertView.findViewById(R.id.price)).setText(String.valueOf(task.getPrice()));

        TextView reservation = (TextView) convertView.findViewById(R.id.reservation);
        if (task.getReservation().equals("false")) {
            reservation.setText(R.string.free);
            reservation.setTextColor(Color.GREEN);
        } else {
            String s = getContext().getResources().getString(R.string.reserv);
            reservation.setText(s + " " + task.getReservation());
            reservation.setTextColor(Color.RED);
        }

        return convertView;
    }
}
