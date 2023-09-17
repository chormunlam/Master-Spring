package com.chormun.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    //course
    //Course: id, name, author

    @RequestMapping("/courses")
    public List<Course> retrivedAllCourses(){
        return Arrays.asList(
                new Course(1, "learn AWS", "in28mins"),
                new Course(2, "Learn DevOps", "in28mins"),
                new Course(3, "Learn Azure", "in28mins")
        );
    }

}
