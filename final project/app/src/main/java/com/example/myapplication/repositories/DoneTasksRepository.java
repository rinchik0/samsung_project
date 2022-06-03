package com.example.myapplication.repositories;

import com.example.myapplication.dataclasses.DoneTask;

import java.util.ArrayList;

public class DoneTasksRepository {
    public static ArrayList<DoneTask> repository = new ArrayList<DoneTask>();
    public static void add(DoneTask done){
        repository.add(done);
    }
    public static ArrayList<DoneTask> getAll() {
        return repository;
    }
}
