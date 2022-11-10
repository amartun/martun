package com.martun.services;

import com.google.common.collect.Iterables;
import com.martun.dbentity.User;
import com.martun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    public List<Iterable<User>> userList = new ArrayList<>();
    private Map<Long, User> userMap = new HashMap<>();

    @Override
    public void getAllUsers(Model model) {
        this.userList.add(this.userRepository.findAll());
        List<User> userListForView = new ArrayList<>();
        int i = 0;
        for(Iterable<User> userIterable : this.userList){
            userListForView.add(userIterable.iterator().next());
            //TODO: Fix ConcurrentModificationException
            this.userList.remove(i);
            i++;
        }
        model.addAttribute("users", userListForView.toArray());
    }

    @Override
    public Optional<User> getUserById(long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user;
    }

    @Override
    public void postUser(String fullName, int age) {
        User user = new User();
        this.userRepository.save(user);
        this.userMap.put(user.getId(), user);
    }

    @Override
    public void registerUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
        userMap.remove(id);
    }

}
