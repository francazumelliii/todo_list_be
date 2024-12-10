package it.jac.project_work.todo_list_be.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Status {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label")
    private String label;

    @OneToMany(mappedBy = "status")
    private Set<Todo> todo;

    public Status(Long id, String label, Set<Todo> todo) {
        this.id = id;
        this.label = label;
        this.todo = todo;
    }

    public Status() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<Todo> getTodo() {
        return todo;
    }

    public void setTodo(Set<Todo> todo) {
        this.todo = todo;
    }
}
