package com.example.myapplication.tabbedactivity.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myapplication.AddNewsActivity;
import com.example.myapplication.R;
import com.example.myapplication.dataclasses.News;
import com.example.myapplication.dataclasses.persons.Admin;
import com.example.myapplication.dataclasses.persons.User;
import com.example.myapplication.repositories.AdminsRepository;
import com.example.myapplication.repositories.NewsRepository;
import com.example.myapplication.repositories.UsersRepository;
import com.example.myapplication.tabbedactivity.adapters.NewsAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    private ActivityMainBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NICK = "nick";

    // TODO: Rename and change types of parameters
    private String uNick;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param nick Parameter 1.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String nick) {
        NewsFragment fragment = new NewsFragment();
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
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        ArrayList<News> news = NewsRepository.getAll();

        NewsAdapter adapter = new NewsAdapter(getContext(), news);
        ListView lv = (ListView) v.findViewById(R.id.listNews);
        lv.setAdapter(adapter);

        FloatingActionButton addNews = (FloatingActionButton) v.findViewById(R.id.addNews);

        User user = UsersRepository.findByNickname(uNick);
        if (user == null) {
            Admin admin = AdminsRepository.findByNickname(uNick);
            addNews.setVisibility(View.VISIBLE);
        }

        addNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( getContext(), AddNewsActivity.class);
                startActivity(i);
            }
        });

        return v;
    }
}