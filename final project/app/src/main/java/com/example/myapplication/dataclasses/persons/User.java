package com.example.myapplication.dataclasses.persons;

public class User extends Person{
    private int scores;

    public User(String nickname, String password) {
        super(nickname, password);
        isAdmin = false;
    }

//    public User(String nickname, String password, boolean isAdmin, int scores) {
//        super(nickname, password);
//        this.isAdmin = isAdmin;
//        this.scores = scores;
//    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }
}
