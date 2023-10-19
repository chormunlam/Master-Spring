package com.example.myspringwebapp.todo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name") //ensure the atrrinte put in to the seession
public class TodoController {
    //list-todos



    public TodoController(TodoService todoService) {
        ///super();
        this.todoService = todoService;
    }

    private TodoService todoService;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos =todoService.findByUsername("chormun");
        model.addAttribute("todos", todos);
        return "listTodo";

    }

}
