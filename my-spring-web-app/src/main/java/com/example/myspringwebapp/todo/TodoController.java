package com.example.myspringwebapp.todo;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public String showNewTodoPage(ModelMap model){
        String username=(String)model.get("name");
        Todo todo =new Todo(0,username,"Default desc",  LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";

    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult res){
        if(res.hasErrors()){
            return "todo";
        }

        String username=(String)model.get("name");
        todoService.addTodo(username , todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";

    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        //delete todo
        todoService.deleteById(id);


        return "redirect:list-todos";

    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model){
        Todo todo =todoService.findById(id);
        model.addAttribute("todo", todo);

        return "todo";

    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult res){
        if(res.hasErrors()){
            return "todo";
        }

        String username=(String)model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";

    }

}
