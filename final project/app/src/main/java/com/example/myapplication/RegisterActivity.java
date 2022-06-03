package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.dataclasses.persons.User;
import com.example.myapplication.repositories.UsersRepository;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register = (Button) findViewById(R.id.register);
        EditText nick = (EditText) findViewById(R.id.nick);
        EditText password = (EditText) findViewById(R.id.password);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!nick.getText().toString().equals("")) && (!password.getText().toString().equals(""))) {
                    UsersRepository.add(new User(nick.getText().toString(), password.getText().toString()));
                    Toast.makeText(RegisterActivity.this, R.string.rightregister1, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(RegisterActivity.this, EnterActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
