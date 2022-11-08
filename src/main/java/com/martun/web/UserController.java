package com.martun.web;


import com.martun.dbentity.User;
import com.martun.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @RequestMapping(value = "/getAllUsers",
            produces = "application/json",
            method = RequestMethod.GET)
    private ResponseEntity<Iterable> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @RequestMapping(value = "/createUsers",
            produces = "application/json",
            method = RequestMethod.POST)
    public ResponseEntity<String> createUsers(@RequestParam(name = "fullName", required = false) String fullName, @RequestParam(name = "age", required = false) int age) {
        userService.postUser(fullName, age);
        return new ResponseEntity<>(fullName + age, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteUserById",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseEntity<String> deleteUserById(@RequestParam(name = "id") long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserById",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseEntity<Optional<User>> getUserById(@RequestParam(name = "id") long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
