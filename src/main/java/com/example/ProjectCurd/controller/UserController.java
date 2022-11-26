package com.example.ProjectCurd.controller;


import com.example.ProjectCurd.entity.Users;
import com.example.ProjectCurd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAll() {
        return userService.getAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Users getOne(@PathVariable int id) {
        return userService.getOneUser(id);
    }

    @PostMapping
    @RequestMapping("addUser")
    public Users addUser(@RequestBody Users users) {
        return userService.create(users);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Users update(@PathVariable int id, @RequestBody Users users) {
        return userService.update(users);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
