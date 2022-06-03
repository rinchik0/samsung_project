package com.example.myapplication.repositories;

import com.example.myapplication.dataclasses.persons.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersRepository {
    private static ArrayList<User> repository = new ArrayList<User>();
    public static void add(User user){
        repository.add(user);
    }
    public static User findByNickname(String nick) {
        if (repository.size() != 0) {
            for (User user : repository) {
                if (user.getNickname().equals(nick)) {
                    return user;
                }
            }
        }
        return null;
    }

//    public static void connectToDB() {
//        Connection conn = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/final_project", "postgres", "postgresRin.8");
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM users");
//            while (rs.next()) {
//                repository.add(new User(rs.getString("nickname"), rs.getString("password"), Boolean.valueOf(rs.getString("administration")), Integer.valueOf(rs.getString("scores"))));
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
