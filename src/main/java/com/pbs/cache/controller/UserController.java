package com.pbs.cache.controller;


import com.pbs.cache.model.User;
import com.pbs.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        System.out.println("Request received to the controller");
        return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {
        System.out.println("Request received to the controller");
        return userService.searchUser(id);
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        System.out.println("Request received to the controller");
        List<User> userList= userService.addNewUser(user);
        return userList.get(userList.size() - 1);
    }

    @DeleteMapping(path = "/users/{id}")
    public boolean removeUser(@PathVariable int id) {
        System.out.println("Request received to the controller");
        return userService.removeUser(id);
    }
}