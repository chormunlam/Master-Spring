package com.example.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//1 this controller will have rest api
@RestController
public class HelloWorldController {
    // /hello-world
    @GetMapping(path = "/basicauth")
    public String basicAuthCheck() {
        return "Success";
    }

    // return "hellow world"
    @GetMapping( path= "/hello-world")
    public String helloWorld() {
        return "Hello Worldgf";

    }

    @GetMapping(path = "/hello-world-bean")
    public HellowWorldBean helloWorldBean(){
        return new HellowWorldBean("hello world");
    }//this return json file

    //path parameters
    // /user/{id}/todos/{id} => /users/2/todos/200
    //hello-world/path-variable/cm

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HellowWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HellowWorldBean(
                String.format("hello world %s", name));
    }


    }
