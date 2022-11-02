package com.martun.services;

import com.martun.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void postUser(String fullName, int age);

    void deleteUserById(int id);
}
