package it.jac.project_work.todo_list_be.controller;


import it.jac.project_work.todo_list_be.dto.CategoryOutDTO;
import it.jac.project_work.todo_list_be.dto.StatusOutDTO;
import it.jac.project_work.todo_list_be.repository.StatusRepository;
import it.jac.project_work.todo_list_be.service.CategoryService;
import it.jac.project_work.todo_list_be.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final StatusService statusService;

    public TodoController(CategoryService categoryService, StatusService statusService) {
        this.categoryService = categoryService;
        this.statusService = statusService;
    }

    @GetMapping("/categories/all")
    public List<CategoryOutDTO> findAllCategories() {
        return this.categoryService.findAll();
    }
    @GetMapping("/status/all")
    public List<StatusOutDTO> findAllStatuses() {
        return this.statusService.findAll();
    }

}
