package com.example.learnjpaandhibernate.course.jdbc;

import com.example.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
            values(?,?,?);
            """;

    private static String Delete_QUERY =
            """
            delete from course 
            where id  = ?
            """;

    private static String Select_QUERY =
            """
            select * from course 
            where id  = ?
            """;
    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long id){
        springJdbcTemplate.update(Delete_QUERY,
                id);
    }

//    public void select(long id){
//        springJdbcTemplate.update(Select_QUERY,
//                id);
//    }

    public Course findById(long id){
        //resultset to Bean=> row mapper
        //id
        return springJdbcTemplate.queryForObject(Select_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);


    }

}
