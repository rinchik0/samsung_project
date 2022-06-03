package com.example.myapplication.dataclasses;

public class Task {
    private String address, discriprion, author, reservation;
    private int price;

    public Task(String address, String discriprion, String author, int price) {
        this.address = address;
        this.discriprion = discriprion;
        this.author = author;
        this.price = price;
        this.reservation = "false";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiscriprion() {
        return discriprion;
    }

    public void setDiscriprion(String discriprion) {
        this.discriprion = discriprion;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
