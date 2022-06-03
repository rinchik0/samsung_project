package com.example.myapplication.tabbedactivity.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.EnterActivity;
import com.example.myapplication.R;
import com.example.myapplication.dataclasses.persons.Admin;
import com.example.myapplication.dataclasses.persons.User;
import com.example.myapplication.repositories.AdminsRepository;
import com.example.myapplication.repositories.UsersRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProfileFragment extends Fragment {

    private static final String ARG_NICK = "nick";
    private String uNick;

    public static ProfileFragment newInstance(String nick) {
        ProfileFragment fragment = new ProfileFragment();
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
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);

        TextView nickName = (TextView) v.findViewById(R.id.nickname_profile);
        TextView scores = (TextView) v.findViewById(R.id.scores_profile);
        TextView role = (TextView) v.findViewById(R.id.role_profile);
        nickName.setText(uNick);

        User user = UsersRepository.findByNickname(uNick);
        if (user == null) {
            Admin admin = AdminsRepository.findByNickname(uNick);
            role.setText(R.string.admin);
        } else {
            scores.setVisibility(View.VISIBLE);
            scores.setText(String.valueOf(user.getScores()));
            role.setText(R.string.user);
        }

        FloatingActionButton exit = (FloatingActionButton) v.findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( getContext(), EnterActivity.class);
                startActivity(i);
            }
        });

        return v;
    }
}