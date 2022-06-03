package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.dataclasses.persons.Admin;
import com.example.myapplication.dataclasses.persons.User;
import com.example.myapplication.repositories.AdminsRepository;
import com.example.myapplication.repositories.NewsRepository;
import com.example.myapplication.repositories.TasksRepository;
import com.example.myapplication.repositories.UsersRepository;

public class EnterActivity extends AppCompatActivity {

    public static String enterist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        Button enter = (Button) findViewById(R.id.enter);
        Button register = (Button) findViewById(R.id.register);
        EditText login = (EditText) findViewById(R.id.login);
        EditText password = (EditText) findViewById(R.id.password);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log = login.getText().toString();
                String pas = password.getText().toString();
                if (log.equals("")) {
                    Toast.makeText(EnterActivity.this, R.string.log2, Toast.LENGTH_SHORT).show();
                } else {
                    if (pas.equals("")) {
                        Toast.makeText(EnterActivity.this, R.string.pas2, Toast.LENGTH_SHORT).show();
                    } else {
                        User user = UsersRepository.findByNickname(log);
                        if (user != null) {
                            if (user.signIn(pas)) {
                                Toast.makeText(EnterActivity.this, R.string.win, Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(EnterActivity.this, MainActivity.class);
                                enterist = user.getNickname();
                                startActivity(i);
                            } else {
                                Toast.makeText(EnterActivity.this, R.string.lose, Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Admin admin = AdminsRepository.findByNickname(log);
                            if (admin != null) {
                                if (admin.signIn(pas)) {
                                    Toast.makeText(EnterActivity.this, R.string.win, Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(EnterActivity.this, MainActivity.class);
                                    enterist = admin.getNickname();
                                    startActivity(i);
                                } else {
                                    Toast.makeText(EnterActivity.this, R.string.lose, Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(EnterActivity.this, R.string.lose, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EnterActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        //
        AdminsRepository.createSuper();
        NewsRepository.createNews();
        TasksRepository.createTasks();
//        UsersRepository.connectToDB();
    }
}