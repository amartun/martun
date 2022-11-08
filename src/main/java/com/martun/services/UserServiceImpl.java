package com.martun.services;

import com.martun.dbentity.User;
import com.martun.repository.UserRepository;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private List<Iterable<User>> userList = new ArrayList<>();
    private Map<Long, User> userMap = new HashMap<>();

    @Override
    public List<Iterable<User>> getAllUsers() {
        userList.add(this.userRepository.findAll());
        return this.userList;
    }

    @Override
    public Optional<User> getUserById(long id) {
        Optional<User> user = this.userRepository.findById(id);
        user.ifPresentOrElse(
                (user1) -> {
                    System.out.println("User found successfully " + "\nUser name "
                            + user1.getName() + "\nUser age " + user1.getAge() + "\nUser id " + user1.getId());
                    },
                () -> {
                    throw new NoSuchElementException("User not found, check user id");
                });
        return user;
    }

    @Override
    public void postUser(String fullName, int age) {
        com.martun.dbentity.User user = new com.martun.dbentity.User(fullName, age);
        this.userRepository.save(user);
        this.userMap.put(user.getId(), user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
        userMap.remove(id);
    }

}
