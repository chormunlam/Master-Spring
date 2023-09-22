package com.example.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//repo mean talk to db
@Repository
public class CourseJdbcRepo {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
            insert into course (id, name, author)
            values(2,'learn AWS2', 'in28min');
            """;
    public void insert(){
        springJdbcTemplate.update(INSERT_QUERY);
    }

}
