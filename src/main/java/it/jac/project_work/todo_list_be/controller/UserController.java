package it.jac.project_work.todo_list_be.controller;

import it.jac.project_work.todo_list_be.dto.TodoInDTO;
import it.jac.project_work.todo_list_be.dto.TodoOutDTO;
import it.jac.project_work.todo_list_be.entity.User;
import it.jac.project_work.todo_list_be.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private final TodoService todoService;
    public UserController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/{id}/todo/all")
    public List<TodoOutDTO> findAllTodosByUserId(@PathVariable("id") Long userId){
        return this.todoService.findAllByUser(userId);
    }
    @PostMapping("/{id}/todo")
    public TodoOutDTO add(@PathVariable("id")Long userId, @RequestBody TodoInDTO dto){
        dto.setUserId(userId);
        return this.todoService.add(dto);
    }
    @PatchMapping("/{id}/todo/{todoId}")
    public TodoOutDTO update(@PathVariable("id")Long userId, @PathVariable("todoId") Long todoId, @RequestBody TodoInDTO dto){
        dto.setUserId(userId);
        return this.todoService.update(todoId,dto);
    }

    @DeleteMapping("/{id}/todo/{todoId}")
    public void delete(@PathVariable("id") Long userId, @PathVariable("todoId") Long todoId){
        this.todoService.delete(userId,todoId);
    }
}
