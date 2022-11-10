package com.martun.services;

import com.martun.dbentity.User;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void getAllUsers(Model model);

    Optional<User> getUserById(long id);
    void postUser(String fullName, int age);

    void registerUser(User user);

    void deleteUserById(long id);
}
