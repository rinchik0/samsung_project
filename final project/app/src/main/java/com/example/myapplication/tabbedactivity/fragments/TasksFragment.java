package com.example.myapplication.tabbedactivity.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.AddTaskActivity;
import com.example.myapplication.CheakActivity;
import com.example.myapplication.CheckedActivity;
import com.example.myapplication.R;
import com.example.myapplication.dataclasses.DoneTask;
import com.example.myapplication.dataclasses.Task;
import com.example.myapplication.dataclasses.persons.Admin;
import com.example.myapplication.dataclasses.persons.User;
import com.example.myapplication.repositories.AdminsRepository;
import com.example.myapplication.repositories.DoneTasksRepository;
import com.example.myapplication.repositories.TasksRepository;
import com.example.myapplication.repositories.UsersRepository;
import com.example.myapplication.tabbedactivity.dialogs.DialogTaskFragment;
import com.example.myapplication.tabbedactivity.adapters.TasksAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TasksFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NICK = "nick";

    // TODO: Rename and change types of parameters
    private String uNick;

    public TasksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param nick Parameter 1.
     * @return A new instance of fragment TasksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TasksFragment newInstance(String nick) {
        TasksFragment fragment = new TasksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NICK, nick);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            uNick = getArguments().getString(ARG_NICK);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tasks, container, false);

        ArrayList<Task> tasks = TasksRepository.getAll();
        ArrayList<DoneTask> doneTasks = DoneTasksRepository.getAll();

        TasksAdapter adapter = new TasksAdapter(getContext(), tasks);
        ListView lv = (ListView) v.findViewById(R.id.listTasks);
        lv.setAdapter(adapter);

        FloatingActionButton addTask = (FloatingActionButton) v.findViewById(R.id.addTask);
        FloatingActionButton refresh = (FloatingActionButton) v.findViewById(R.id.refresh);
        FloatingActionButton checkTask = (FloatingActionButton) v.findViewById(R.id.checkTask);

        User user = UsersRepository.findByNickname(uNick);
        if (user == null) {
            Admin admin = AdminsRepository.findByNickname(uNick);
            addTask.setVisibility(View.VISIBLE);
            checkTask.setVisibility(View.VISIBLE);
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (user != null) {
                    if (tasks.get(position).getReservation().equals("false")) {
                        DialogTaskFragment dialog = new DialogTaskFragment();
                        dialog.show(getFragmentManager(), String.valueOf(position));
                    }
                    if (tasks.get(position).getReservation().equals(user.getNickname())) {
                        Intent i = new Intent(getContext(), CheakActivity.class);
                        i.putExtra("position", position);
                        startActivity(i);
                    }
                }
            }
        });

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( getContext(), AddTaskActivity.class);
                startActivity(i);
            }
        });

        checkTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), CheckedActivity.class);
                startActivity(i);
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyDataSetChanged();
            }
        });

        return v;
    }
}