package it.jac.project_work.todo_list_be.service;


import it.jac.project_work.todo_list_be.dto.CategoryOutDTO;
import it.jac.project_work.todo_list_be.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryOutDTO> findAll(){
        return this.categoryRepository.findAll()
                .stream().map(CategoryOutDTO::build).collect(Collectors.toList());
    }
}
