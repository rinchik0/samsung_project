package com.example.myapplication.repositories;

import com.example.myapplication.dataclasses.News;

import java.util.ArrayList;

public class NewsRepository {
    public static ArrayList<News> repository = new ArrayList<News>();
    public static void add(News news){
        repository.add(news);
    }

    public static void createNews() {
        repository.add(new News("Запуск приложения", "Мы запустили приложение, оно работает. Новости на месте.", "Админ"));
        repository.add(new News("Задания", "Задания работают корректно", "Админ"));
        repository.add(new News("Ищем дизайнера", "Если вы можете помочь нам более качественно и эстетично оформить приложение, мы будем очень рады.", "Админ"));
        repository.add(new News("Экология", "В нашем мире мало кто следит за тем, куда он выбрасывает мусор, поэтому вокруг становится очень грязно.", "Админ"));
    }

    public static ArrayList<News> getAll() {
        return repository;
    }
}
