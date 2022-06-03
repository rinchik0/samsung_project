package com.example.myapplication.dataclasses;

import java.util.ArrayList;

public class News {
    private class Comment{
        private String nickname, text;

        public Comment(String nickname, String text) {
            this.nickname = nickname;
            this.text = text;
        }

        private String getNickname() {
            return nickname;
        }

        private String getText() {
            return text;
        }
    }

    private String header, discription, author;
    private ArrayList<Comment> comments = new ArrayList<Comment>();

    public News(String header, String discription, String author) {
        this.header = header;
        this.discription = discription;
        this.author = author;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(String nickname, String text) {
        comments.add(new Comment(nickname, text));
    }
}

