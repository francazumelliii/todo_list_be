package it.jac.project_work.todo_list_be.service;


import it.jac.project_work.todo_list_be.dto.StatusOutDTO;
import it.jac.project_work.todo_list_be.dto.TodoInDTO;
import it.jac.project_work.todo_list_be.dto.TodoOutDTO;
import it.jac.project_work.todo_list_be.entity.Category;
import it.jac.project_work.todo_list_be.entity.Status;
import it.jac.project_work.todo_list_be.entity.Todo;
import it.jac.project_work.todo_list_be.entity.User;
import it.jac.project_work.todo_list_be.repository.CategoryRepository;
import it.jac.project_work.todo_list_be.repository.StatusRepository;
import it.jac.project_work.todo_list_be.repository.TodoRepository;
import it.jac.project_work.todo_list_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private final TodoRepository todoRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final StatusRepository statusRepository;
    @Autowired
    private final CategoryRepository categoryRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository, StatusRepository statusRepository, CategoryRepository categoryRepository){
        this.statusRepository = statusRepository;
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<TodoOutDTO> findAllByUser(Long userId){
        if(userId == null || userId < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required parameter: userId");
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User entity not found"));

        return this.todoRepository.findAllByUser(user)
                .stream()
                    .map(TodoOutDTO::build).collect(Collectors.toList());
    }

    public TodoOutDTO add( TodoInDTO dto){
        if(dto == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing body required parameters");
        if(dto.getUserId() == null || dto.getUserId() < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required parameter: userId");
        Todo entity = new Todo();
        User user = this.userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User entity not found"));

        entity.setUser(user);

        entity.setLabel(dto.getLabel().isBlank() ? "Unknown" : dto.getLabel());
        if(!dto.getDescription().isBlank()) entity.setDescription(dto.getDescription());

        entity.setExpDate(dto.getExpDate() == null ? LocalDate.now() : dto.getExpDate());
        if(dto.getExpDate().isBefore(LocalDate.now())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Expiring date");

        entity.setCreatedAt(LocalDateTime.now());
        Status status = this.statusRepository.findByLabel("CREATED");
        entity.setStatus(status);

        Category category = new Category();
        if(dto.getCategoryId() == null || dto.getCategoryId() < 0) {
            category = this.categoryRepository.findByLabel("EXTRA");
        }else{
            category = this.categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category entity not found"));
        }
        entity.setCategory(category);
        return TodoOutDTO.build(this.todoRepository.save(entity));
    }

    public TodoOutDTO update(Long todoId,  TodoInDTO dto){
        if(dto.getUserId() == null || dto.getUserId() < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required parameter: userId");
        if(todoId == null || todoId < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required parameter: todoId");

        User user = this.userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User entity not found"));
        Todo todo = this.todoRepository.findById(todoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo entity not found"));
        boolean isPresent = user.getTodo().stream().anyMatch(t -> Objects.equals(t.getId(), todoId));
        if(!isPresent) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Cannot update other user's todo list");

        if(dto.getLabel() != null && !dto.getLabel().isBlank()) todo.setLabel(dto.getLabel());
        if(dto.getDescription() != null && !dto.getDescription().isBlank()) todo.setDescription(dto.getDescription());
        if(dto.getExpDate() != null && !dto.getExpDate().isBefore(LocalDate.now())) todo.setExpDate(dto.getExpDate());
        if(dto.getCategoryId() != null && dto.getCategoryId() >= 0){
            Category category = this.categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category entity not found"));
            todo.setCategory(category);
        }
        if(dto.getStatusId() != null && dto.getStatusId() >= 0){
            Status status = this.statusRepository.findById(dto.getStatusId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Status entity not found"));
            todo.setStatus(status);
        }

        return TodoOutDTO.build(this.todoRepository.save(todo));

    }

    public void delete(Long userId, Long todoId){
        if(userId == null || userId < 0 ) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required parameter: userId");
        if(todoId == null || todoId < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required parameter: todoId");

        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User entity not found"));
        Todo todo = this.todoRepository.findById(todoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo entity not found"));

        boolean isPresent = user.getTodo().stream().anyMatch(t -> Objects.equals(t.getId(), todoId));
        if(!isPresent) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Cannot delete other user's todo list");
        this.todoRepository.delete(todo);
    }
}
