package com.example.myapplication.dataclasses.persons;

import java.util.Locale;

public abstract class Person {
    private String nickname;
    private String password;
    public boolean isAdmin;
    private int scores;

    public Person(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
        this.scores = 0;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean signIn(String password) {
        if (password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}
