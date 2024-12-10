package it.jac.project_work.todo_list_be.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="label")
    private String label;

    @OneToMany(mappedBy="category")
    private Set<Todo> todo;

    @Column(name="description")
    private String description;


    public Category(Long id, String label, Set<Todo> todo, String description ) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.todo = todo;
    }

    public Category() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Set<Todo> getTodo() {
        return todo;
    }

    public void setTodo(Set<Todo> todo) {
        this.todo = todo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String name) {
        this.label = label;
    }
}
