package com.example.myapplication.repositories;

import com.example.myapplication.dataclasses.Task;

import java.util.ArrayList;

public class TasksRepository {
    public static ArrayList<Task> repository = new ArrayList<Task>();
    public static void add(Task task){
        repository.add(task);
    }

    public static void createTasks() {
        repository.add(new Task("Ленинский проспект, 73а", "Убрать мусор вокруг дома.", "Админ", 20));
        repository.add(new Task("Ленинский проспект, 38", "Убрать мусор рядом с подъездом.", "Админ", 10));
        repository.add(new Task("Ленинский проспект, 92", "Убрать мусор в парке.", "Админ", 150));
        repository.add(new Task("Ленинский проспект, 45", "Убрать мусор в посадке вдоль дороги\n" +
                "на стороне водохранилища.", "Админ", 50));
    }

    public static ArrayList<Task> getAll() {
        return repository;
    }
}
