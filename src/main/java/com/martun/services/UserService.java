package com.martun.services;

import com.martun.dbentity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Iterable<User>> getAllUsers();

    Optional<User> getUserById(long id);
    void postUser(String fullName, int age);

    void deleteUserById(long id);
}
