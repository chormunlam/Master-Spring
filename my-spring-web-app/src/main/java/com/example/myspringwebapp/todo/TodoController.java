package com.example.myspringwebapp.todo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
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

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(){
        return "todo";

    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(@RequestParam String description, ModelMap model){

        String username=(String)model.get("name");
        todoService.addTodo(username , description, LocalDate.now(), false);
        return "redirect:list-todos";

    }

}
