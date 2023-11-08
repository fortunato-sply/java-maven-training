package com.fortunato.java_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortunato.java_api.model.UserModel;
import com.fortunato.java_api.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("")
    public List<UserModel> getAll() {
        return service.findAll();
    }

    @GetMapping("/{name}")
    public List<UserModel> getByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/{name}/{age}")
    public List<UserModel> getByNameAndAge(@PathVariable String name, @PathVariable short age) {
        return service.findByNameAndAge(name, age);
    }

    @PostMapping("")
    public void newUser(@RequestBody UserModel newUser) {
        service.save(newUser);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody UserModel newUser) {
        service.save(id, newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.isAdmin());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        service.delete(id);
    }
}