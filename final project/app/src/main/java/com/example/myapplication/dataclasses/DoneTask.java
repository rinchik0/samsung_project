package com.example.myapplication.dataclasses;

import com.example.myapplication.dataclasses.persons.User;

public class DoneTask {
    private String address, discriprion, author, userName;
    private int price;
    private boolean isCheked;

    public DoneTask(Task task, User user) {
        address = task.getAddress();
        discriprion = task.getDiscriprion();
        author = task.getAuthor();
        price = task.getPrice();
        isCheked = false;
        userName = user.getNickname();
    }

    public Task uncorrectDone() {
        Task task = new Task(this.getAddress(), this.getDiscriprion(), this.getAuthor(), this.getPrice());
        return task;
    }

    public boolean isCheked() {
        return isCheked;
    }

    public void setCheked(boolean cheked) {
        isCheked = cheked;
    }

    public String getAddress() {
        return address;
    }

    public String getDiscriprion() {
        return discriprion;
    }

    public String getAuthor() {
        return author;
    }

    public String getUserName() {
        return userName;
    }

    public int getPrice() {
        return price;
    }
}
