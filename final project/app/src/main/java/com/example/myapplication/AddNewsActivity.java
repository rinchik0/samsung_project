package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.dataclasses.News;
import com.example.myapplication.dataclasses.persons.Admin;
import com.example.myapplication.repositories.AdminsRepository;
import com.example.myapplication.repositories.NewsRepository;

public class AddNewsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);
        EditText header = (EditText) findViewById(R.id.header_news);
        EditText discription = (EditText) findViewById(R.id.disc_news);
        Button post = (Button) findViewById(R.id.post_news);

        Admin admin = AdminsRepository.findByNickname(EnterActivity.enterist);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (header.getText().toString().equals("")) {
                    Toast.makeText(AddNewsActivity.this, R.string.must_header, Toast.LENGTH_SHORT).show();
                } else {
                    if (discription.getText().toString().equals("")) {
                        Toast.makeText(AddNewsActivity.this, R.string.must_disc, Toast.LENGTH_SHORT).show();
                    } else {
                        NewsRepository.add(new News(header.getText().toString(), discription.getText().toString(), admin.getNickname()));
                        Intent i = new Intent(AddNewsActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                }
            }
        });
    }
}