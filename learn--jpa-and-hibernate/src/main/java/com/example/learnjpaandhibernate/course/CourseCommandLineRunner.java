package com.example.learnjpaandhibernate.course;

import com.example.learnjpaandhibernate.course.Course;
import com.example.learnjpaandhibernate.course.jpa.CourseJpaRepo;
import com.example.learnjpaandhibernate.course.springdatajpa.CourseSpirngDataJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepo repo;
    //switch to jpa
//    @Autowired
//    private CourseJpaRepo repo;
    //siwtch to spring jpa
    @Autowired
    private CourseSpirngDataJpaRepo repo;

    @Override
    public void run(String... args) throws Exception {
//        repo.insert(new Course(1, "Learn AWS now!", "in28 min"));
//        repo.insert(new Course(2, "Learn cloue now!", "in28 min"));
//        repo.insert(new Course(3, "Learn doker now!", "in28 min"));
//        repo.insert(new Course(4, "Learn kafka now!", "in28 min"));
        //for springJPA
        repo.save(new Course(4, "Learn kafka now!", "in28 min"));
        repo.save(new Course(1, "Learn AWS now!", "in28 min"));
        repo.save(new Course(2, "Learn cloue now!", "in28 min"));
        repo.save(new Course(3, "Learn doker now!", "in28 min"));


       // repo.delete(1);
        repo.deleteById(1l);

        System.out.println(repo.findById(2l));



    }
}
