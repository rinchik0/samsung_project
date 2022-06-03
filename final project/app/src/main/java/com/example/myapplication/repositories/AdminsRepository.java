package com.example.myapplication.repositories;

import com.example.myapplication.dataclasses.persons.Admin;

import java.util.ArrayList;

public class AdminsRepository {
    private static ArrayList<Admin> repository = new ArrayList<Admin>();
    private static void add(Admin admin){
        repository.add(admin);
    }
    public static Admin findByNickname(String nick) {
        if (repository.size() != 0) {
            for (Admin admin : repository) {
                if (admin.getNickname().equals(nick)) {
                    return admin;
                }
            }
        }
        return null;
    }
    public static void createSuper(){
        repository.add(new Admin("Администратор", "12345678"));
    }
}
