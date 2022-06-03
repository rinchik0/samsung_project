package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.dataclasses.Task;
import com.example.myapplication.dataclasses.persons.Admin;
import com.example.myapplication.repositories.AdminsRepository;
import com.example.myapplication.repositories.TasksRepository;

public class AddTaskActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        EditText address = (EditText) findViewById(R.id.address);
        EditText discription = (EditText) findViewById(R.id.disc_task);
        EditText price = (EditText) findViewById(R.id.price);
        Button post = (Button) findViewById(R.id.post_task);

        Admin admin = AdminsRepository.findByNickname(EnterActivity.enterist);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (address.getText().toString().equals("")) {
                    Toast.makeText(AddTaskActivity.this, R.string.must_address, Toast.LENGTH_SHORT).show();
                } else {
                    if (discription.getText().toString().equals("")) {
                        Toast.makeText(AddTaskActivity.this, R.string.must_disc, Toast.LENGTH_SHORT).show();
                    } else {
                        if (price.getText().toString().equals("")) {
                            Toast.makeText(AddTaskActivity.this, R.string.must_price, Toast.LENGTH_SHORT).show();
                        } else {
                            try {
                                TasksRepository.add(new Task(address.getText().toString(), discription.getText().toString(), admin.getNickname(), Integer.valueOf(price.getText().toString())));
                                Intent i = new Intent(AddTaskActivity.this, MainActivity.class);
                                startActivity(i);
                            } catch (NumberFormatException e) {
                                Toast.makeText(AddTaskActivity.this, R.string.must_price_numbers, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
    }
}