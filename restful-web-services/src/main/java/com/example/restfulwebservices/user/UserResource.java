package com.example.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;
    public UserResource(UserDaoService service){
        this.service=service;
    }

    //Get /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findall();
    }

    @GetMapping("/users/{id}")
    public User retrieveUsers(@PathVariable int id){
        return service.findOne(id);
    }

    //Post /users
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        service.save(user);
    }



}
