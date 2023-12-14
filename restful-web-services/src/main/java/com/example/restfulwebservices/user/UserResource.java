package com.example.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
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
       User user =service.findOne(id);
       if(user==null)
           throw new UserNotFoundException("id:"+ id);
       return user;
    }

    //Post /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User saveUser=service.save(user);
        // /users/4
        // location -/users/4 =>users/{id}, user.getID
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()//http://localhost:8080/users
                .path("/{id}")//add this path
                .buildAndExpand(saveUser.getId())//and replacing id with this id,
                .toUri();//convert it to uri
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable int id){
        service.deleteById(id);

    }




}
