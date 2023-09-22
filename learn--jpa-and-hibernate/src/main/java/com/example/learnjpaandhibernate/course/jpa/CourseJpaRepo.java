package com.example.learnjpaandhibernate.course.jpa;

import com.example.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepo {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);// they match all the course , name to name, author to aurotr, id to id
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public void delete(long id){
        Course course =entityManager.find(Course.class,id);
        entityManager.remove(course);
    }
}
