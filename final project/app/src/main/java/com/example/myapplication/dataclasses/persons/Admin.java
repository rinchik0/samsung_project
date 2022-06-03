package com.example.myapplication.dataclasses.persons;

public class Admin extends Person{
    public Admin(String nickname, String password) {
        super(nickname, password);
        isAdmin = true;
    }
}
