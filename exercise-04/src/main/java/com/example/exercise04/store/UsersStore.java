package com.example.exercise04.store;

import com.example.exercise04.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


public class UsersStore {
    public static List<User> users = new ArrayList<>();
    static {
        users.add(new User("Dang Hoang Phuong" ,"phuong", "123"));
        users.add(new User("Do Tien Anh" ,"tienanh", "123"));
        users.add(new User("Nguyen Tien Kien" ,"kien", "123"));
        users.add(new User("Nguyen Duy Minh Quan" ,"quan", "123"));
    }

    public UsersStore() {
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        UsersStore.users = users;
    }
}
