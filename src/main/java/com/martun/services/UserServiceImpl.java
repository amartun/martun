package com.martun.services;

import com.martun.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    Map<Integer, User> userMap = new HashMap<>();
    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>(userMap.values());
        return userList;
    }

    @Override
    public void postUser(String fullName, int age) {
        User user = new User(fullName, age);
        this.userMap.put(user.getId(), user);
    }

    @Override
    public void deleteUserById(int id) {
        userMap.remove(id);
    }

}
