package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.dataclasses.DoneTask;
import com.example.myapplication.repositories.DoneTasksRepository;
import com.example.myapplication.tabbedactivity.dialogs.DialogDoneTaskFragment;
import com.example.myapplication.tabbedactivity.adapters.DoneTasksAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CheckedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheaked);

        ListView list = (ListView) findViewById(R.id.listDoneTasks);
        ArrayList<DoneTask> dones = DoneTasksRepository.getAll();
        DoneTasksAdapter adapter = new DoneTasksAdapter(this, dones);
        list.setAdapter(adapter);

        FloatingActionButton refresh = (FloatingActionButton) findViewById(R.id.refresh_done);
        FloatingActionButton back = (FloatingActionButton) findViewById(R.id.back);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyDataSetChanged();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CheckedActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                DialogDoneTaskFragment dialog = new DialogDoneTaskFragment();
                dialog.show(getSupportFragmentManager(), String.valueOf(position));
            }
        });
    }
}
