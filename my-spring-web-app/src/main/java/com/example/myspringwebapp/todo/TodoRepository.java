package com.example.myspringwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//<bean, id type>
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username);
}
