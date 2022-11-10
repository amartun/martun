package com.martun.web;


import com.martun.dbentity.User;
import com.martun.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startPage() {
        return "index.html";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form.html";
    }

    @RequestMapping(value = "/process_register", method = RequestMethod.GET)
    public String processRegister(User user) {
        this.userService.registerUser(user);
        return "register_success.html";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    private String getAllUsers(Model model) {
        this.userService.getAllUsers(model);
        return "users.html";
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
